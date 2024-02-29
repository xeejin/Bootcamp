package com.limheejin.mybmi_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val height = intent.getIntExtra("height", 0) //인텐트 보낸 걸 받아옴
        val weight = intent.getIntExtra("weight", 0)

        //BMI 계산
        var value = weight / (height/100.0).pow(2.0) //제곱, import kotlin.math.pow
        value = round(value * 10)/10 //소수점 첫째자리까지만 표시. 둘째자리까지 표시하고 싶으면 100 100

        var resultText = ""
        var resImage = 0
        var resColor = 0

        if(value < 18.5){
            resultText = "저체중"
            resImage = R.drawable.img_lv1
            resColor = Color.YELLOW
        } else if(value >= 18.5 && value < 23.0){
            resultText = "정상 체중"
            resImage = R.drawable.img_lv2
            resColor = Color.GREEN
        } else if(value >= 23.0 && value < 25.0){
            resultText = "과체중"
            resImage = R.drawable.img_lv3
            resColor = Color.BLACK
        } else if(value >= 25.0 && value < 30.0){
            resultText = "경도 비만"
            resImage = R.drawable.img_lv4
            resColor = Color.CYAN
        } else if(value >= 30.0 && value < 35.0){
            resultText = "중정도 비만"
            resImage = R.drawable.img_lv5
            resColor = Color.MAGENTA
        } else {
            resultText = "고도 비만"
            resImage = R.drawable.img_lv6
            resColor = Color.RED
        }


        val tv_resValue = findViewById<TextView>(R.id.tv_resValue)
        val tv_resText = findViewById<TextView>(R.id.tv_resText)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val btn_back = findViewById<Button>(R.id.btn_back)

        tv_resValue.text = value.toString() //text라 바로 안들어가서 .toString()을 해주어야 함
        tv_resText.text = resultText
        iv_image.setImageResource(resImage)
        tv_resText.setTextColor(resColor)

        btn_back.setOnClickListener {
            finish() // 바로 종료하는 것
        }

    }
}