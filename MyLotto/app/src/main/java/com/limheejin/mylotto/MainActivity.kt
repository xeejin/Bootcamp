package com.limheejin.mylotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private val clearButton by lazy {findViewById<Button>(R.id.btn_clear)}
    private val addButton by lazy {findViewById<Button>(R.id.btn_add)}
    private val runButton by lazy {findViewById<Button>(R.id.btn_run)}
    private val numPick by lazy {findViewById<NumberPicker>(R.id.np_num)}

    private val numTextViewList : List<TextView> by lazy {
        listOf<TextView>(
            findViewById(R.id.tv_num1),
            findViewById(R.id.tv_num2),
            findViewById(R.id.tv_num3),
            findViewById(R.id.tv_num4),
            findViewById(R.id.tv_num5),
            findViewById(R.id.tv_num6)
        )
    }

    private var didRun = false
    private val pickNumberSet = hashSetOf<Int>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        numPick.minValue = 1
        numPick.maxValue = 45

        initRunButton()
        initAddButton()
        initClearButton()



    }


    private fun initAddButton() {
        addButton.setOnClickListener {
            when {
                didRun -> showToast("초기화 후에 시도해주세요.")

                pickNumberSet.size >= 6 -> showToast("숫자는 최대 6개까지 선택할 수 있습니다.")

                pickNumberSet.contains(numPick.value) -> showToast("이미 선택된 숫자입니다.")

                else -> {
                    val textView = numTextViewList[pickNumberSet.size] //size는 선택한 개수만큼 갖고오기 위함
                    textView.isVisible = true
                    textView.text = numPick.value.toString()

                    setNumBack(numPick.value, textView)
                    pickNumberSet.add(numPick.value)

                }
            }


        }
    }

    private fun initClearButton(){

        clearButton.setOnClickListener {
            pickNumberSet.clear()
            numTextViewList.forEach{it.isVisible = false}
            didRun = false
            numPick.value = 1

        }
    }


    private fun initRunButton(){
        runButton.setOnClickListener {
            val list = getRandom() // 아래 getRandom함수에 의해 list에 6개의 숫자가 들어가 있을 것

            when {pickNumberSet.size >= 6 -> showToast("이미 6개를 다 고르셨네요!")}

            didRun = true

            list.forEachIndexed{index, number ->
                val textView = numTextViewList[index]
                textView.text = number.toString()
                textView.isVisible = true
                setNumBack(number, textView)

            }


        }
    }

    private fun getRandom(): List<Int> {
        val numbers = (1..45).filter{ it !in pickNumberSet} // 1부터 45중에 사용자가 먼저 선택한 걸 뺀 나머지
        return (pickNumberSet + numbers.shuffled().take(6-pickNumberSet.size)).sorted()
    // 미리 고른 것과 랜덤숫자를 섞은 뒤 더해준 것중, 6개에서 사용자가 먼저 설정한 사이즈를 빼고 take하고, 차례대로 sorting

    }

    private fun setNumBack(number:Int, textView: TextView){
        val background = when(number){
            in 1..10 -> R.drawable.circle_yellow
            in 11..20 -> R.drawable.circle_blue
            in 21..30 -> R.drawable.circle_red
            in 31..40 -> R.drawable.circle_gray
            else -> R.drawable.circle_green

        }

        textView.background = ContextCompat.getDrawable(this, background)

    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}