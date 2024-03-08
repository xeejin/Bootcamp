package com.limheejin.calculator


//class Calculator {

    fun main() {

        println("=============계산기=============")
        println("안녕하세요! 사칙연산 계산기입니다.")
        println("계산을 원하시는 정수 두 개를 입력해주세요. ")
        var num1 = Integer.parseInt(readLine())
        var num2 = Integer.parseInt(readLine())

        println("원하시는 연산자 기호를 입력해주세요 (+, -, *, / )")
        val operator = readLine()
        val result =
            when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> throw Exception("잘못된 연산자입니다. 계산기를 다시 켜주세요.")
            }

        println("${num1} ${operator} ${num2} = ${result} 입니다.")
        println("다시 진행하시겠습니까? 네: 1 / 아니오, 끝내겠습니다: -1 ")

        var isExit = readLine()!!.toInt()
        when (isExit){
            1 -> main()
            -1 -> throw Exception("계산을 종료하겠습니다. 이용해주셔서 감사합니다.")
            else -> throw Exception("잘못된 연산자입니다. 계산기를 다시 켜주세요.")
        }



    }
//}

