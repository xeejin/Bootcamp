package com.limheejin.mybmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)

        submitButton.setOnClickListener{//버튼이 클릭이 되었을 때 아래 내용이 실행

            if(heightEditText.text.isEmpty()){
                Toast.makeText(this, "신장을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(weightEditText.text.isEmpty()){
                Toast.makeText(this, "체중을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height : Int = heightEditText.text.toString().toInt() // height라는 변수를 선언해놓고, heightEditText에서 받아온 문자열을 숫자로 바꿔서 변수로 넣어줌
            val weight : Int = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java) //activity에서 activity로 전달할 때는 Intent라는 걸 씀
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)


        }
    }
}