package com.limheejin.mbtitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2

class TestActivity : AppCompatActivity() {

    private lateinit var viewPager : ViewPager2

    val questionnaireResults = QuestionnaireResults()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this)
        viewPager.isUserInputEnabled = false //화면 좌우로 움직이면 페이지가 나오는 걸 막음

        }

        // 다음 페이지로 넘기는 함수
        fun moveToNextQuestion(){
            if(viewPager.currentItem==3){ // 0부터 시작하기 때문에 총 4페이지면 3이 마지막 페이지 의미
            val intent = Intent(this, ResultActivity::class.java)
                intent.putIntegerArrayListExtra("results", ArrayList(questionnaireResults.results)) //결과에 대한 화면 뿌리기 위함
                startActivity(intent)
        }else {
            val nextItem = viewPager.currentItem + 1
                if(nextItem < viewPager.adapter?.itemCount?: 0){
                    viewPager.setCurrentItem(nextItem, true)
                }

                }
            }


    }

class QuestionnaireResults {
    val results = mutableListOf<Int>()

    fun addResponses(response: List<Int>){
        val mostFrequent = response.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        // List에 들어온 1, 1, 2를 그룹으로 묶은 뒤, 각각의 개수를 셈, 거기서 Max의 key값을 넣음
        mostFrequent?.let { results.add(it)}
    }

} // 질문지에서 응답을 저장할 곳
