package com.limheejin.calculator


class Calculator {

    fun main() {

        println("안녕하세요! 계산기입니다. ")
        var num1 = readLine()!!.toInt()
        var num2 = readLine()!!.toInt()

        // sum이라는 이름의 메소드를 호출!
        sum(num1, num2)
    }

    fun sum(num1: Int, num2: Int) {
        var result = num1 + num2
        println("num1과 num2의 덧셈결과는 ${result}입니다.")
    }
}