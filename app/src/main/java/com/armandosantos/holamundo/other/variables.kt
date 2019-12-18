package com.armandosantos.holamundo.other

import android.util.Log

/*
En Kotlin todo es un objeto
No hay tipos basico y no existe void, Si algo no devuelve nada esta devolviendo Unit Objetct.
Las variables pueden ser mutables o inmutables, usaremos inmutables siempre que sea posible, (var vs val)
Los tipos son definidos despues del nombre de la variable, con dos puntos y espacio (var nombre: tipo)
 */

class variables {
    private var variable0 = 1
    private var variable1 = 1.toByte()
    private var variable2 = -123
    private var variable3 = 123456789123
    private var variable4 = 1.1.toFloat()
    private var variable5 = 1.9
    private var variable6 = 'a'
    private var variable7 = "a"
    private var variable8 = true
    private var variable9 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    private var variable10 = arrayOfNulls<Int>(10)
    private val variable11 = "Esta variable es read-only/inmutable/constante"

    //Show Case para Byte
    private fun showCase1() {
        Log.w(
            "VARIABLE-0",
            "es variable0 un Integer? -------> " + (variable0 is Int) + " Porque no un Byte?"
        )

        Log.w(
            "VARIABLE-0",
            "es variable0 un Integer? -------> " + (variable1 is Byte) + " Porque no un Byte?"
        )
    }

    //Show Case para Int
    private fun showCase2() {
        Log.w("Variable-2", "Es un valor Integer")
        variable2 = Int.MAX_VALUE
    }

    //Show Case para Long
    private fun showCase3() {
        Log.w("Variable-3", "Es un valor Long? -----> " + (variable3 is Long))
    }

    //Show Case para Float
    private fun showCase4() {
        Log.w("Variable-4", "Es un valor Float? -----> " + (variable4 is Float))
    }

    //Show Case para Double
    private fun showCase5() {
        Log.w("Variable-5", "Es un valor Double? -----> " + (variable5 is Double))
    }

    //Show Case para Char
    private fun showCase6() {
        Log.w("Variable-6", "Es un valor Char? -----> " + (variable6 is Char))
    }

    //Show Case para String
    private fun showCase7() {
        Log.w("Variable-7", "Es un valor String? -----> " + (variable7 is String))

        //String literals
        variable7 = "¡Hola mundo:\n¡Adios mundo!" // Java´s style
        variable7 = """ 
                        ¡Hola Mundo!
                        ¡Adios Mundo!
                    """ //Kotlin's style

        //String Templates
        var points = 9
        var maxPoint = 10
        variable7 = "Hola tengo " + points + " puntos sobre " + maxPoint //Java's Style
        variable7 = "Hola tengo $points puntos sobre $maxPoint " //Kotlin's style
        variable7 = "Hola tengo ${points * 10}  puntos sobre ${maxPoint * 10}" //Kotlin's style
    }

    //Show Case para Boolean
    private fun showCase8() {
        Log.w("Variable-8", "Es un valor Boolean? -----> " + (variable8 is Boolean))
    }

    //Show Case para Array Enteros
    private fun showCase9() {
        Log.w("Variable-9", "Es un valor Array<Int>? -----> " + (variable9 is Array<Int>))
    }

    //Show Case para Array<Int?>
    private fun showCase10() {
        Log.w("Variable-10", "Es un valor Array<Int>? -----> " + (variable10 is Array<Int?>))

        variable10 = arrayOfNulls(3)
        variable10 = arrayOf(1, 2, 3, 4, 5, 6)
        variable10[0]?.toFloat() //Save calls -- en caso de ser null, devulve null
        variable10[0]?.toFloat() ?: "Error" // Elvis operator -- En caso de ser null, debulete "Error"
        variable10[0]!!.toFloat() //the !! Operator -- Cuando estamos segurs que no sea nulo al 100%, si no fuera lanza un Null pointer exeption
    }

    fun showCases(){
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
        showCase10()
    }
}