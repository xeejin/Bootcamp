package com.limheejin.calculator


class Calculator {

    fun main() {

        println("=============계산기=============")
        println("안녕하세요! 사칙연산 계산기입니다.")
        println("계산을 원하시는 정수 두 개를 입력해주세요.")
        var num1 = Integer.parseInt(readLine())
        var num2 = Integer.parseInt(readLine())

        println("원하시는 연산자를 선택해주세요 (+, -, *, /, %")
        val operator: String? = readLine()
        val result =
            when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> throw Exception("잘못된 연산자입니다. 계산기를 다시 켜주세요.")
            }

        println("${num1} ${operator} ${num2} = ${result} 입니다.")

    }
}