package com.armandosantos.holamundo.other

import android.util.Log

class ControlFlow {
    private fun showCase1() {
        //If
        val num1 = 5
        val num2 = 10

        if (num1 > num2)
            Log.w("CONTROL-FLOW-1", "NUM1 es mayor que NUM2")

        if (num2 > num1)
            Log.w("CONTROL-FLOW-1", "NUM2 es mayor que NUM1")
    }

    private fun showCase2() {
        //If Else
        val num1 = 5
        val num2 = 10

        if (num1 > num2)
            Log.w("CONTROL-FLOW-2", "NUM1 es mayor que NUM2")
        else
            Log.w("CONTROL-FLOW-2", "NUM2 es mayor que NUM1")

        // Como expresion
        var result = if (num1 > num2) num1 else num2

    }

    private fun showCase3() {
        //When, lo que seria switch en Java
        val x = 1

        // Con argumetnos
        when (x) {
            1 -> Log.w("CONTROL-FLOW-3", "x == 1")
            2 -> Log.w("CONTROL-FLOW-3", "x == 2")
            else -> Log.w("CONTROL-FLOW-3", "x es otro numero")
        }

        // Con rango
        when (x) {
            0, 1 -> Log.w("CONTROL-FLOW-3", "x == 0 o x == 1")
        }

        //Sin argumento
        when {
            (x % 2 == 0) -> Log.w("CONTROL-FLOW-3", "numero es par")
            (x % 2 == 1) -> Log.w("CONTROL-FLOW-3", "numero es impar")
        }

        //Sin agumento y devolciendo un valor
        val esPar = when {
            (x % 2 == 0) -> true
            else -> false
        }

    }

    private fun showCase4() {
        //Bucle For
        val numbers = arrayOf(1, 2, 3, 4, 5)

        for (number in numbers) Log.w("CONTROL-FLOW-4", number.toString())

        //Especificando el tipo
        for (number: Int in numbers) {
            Log.w("CONTROL-FLOW-4", number.toString())
        }

        //Con Indices
        for ((index, number) in numbers.withIndex()) {
            Log.w("CONTROL-FLOW-4", "$index: $number")
        }
    }

    private fun showCase5() {
        // while & do while
        var x = 10
        while (x > 0) {
            Log.w("CONTROL-FLOW-5", x--.toString())
        }

        do {
            Log.w("CONTROL-FLOW-5", "Primera y unica instancia")
        } while (x > 0)
    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
    }
}