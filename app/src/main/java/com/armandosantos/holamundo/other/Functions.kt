package com.armandosantos.holamundo.other

import android.util.Log
import java.util.*

class Functions {
    private fun showCase1() {
        // Funciones, parametros y Unit

        fun function1() {}
        val result1 = function1()

        fun function2() {}
        val result2 = function2()

        // los parametros de las funciones necesitas especificar su tipo, siempre
        fun function3(param1: String, param2: String): String {
            return "$param1, $param2"
        }

        val result3 = function3("cosa1", "cosa2")

        fun function4(param: Int = 5) {}
        fun function5(param: Int?) {}


    }

    private fun showCase2() {
        // Funciones con funciones como parametros(callback) y llamadas por lambda

        fun printSum(num1: Int, num2: Int, printer: (result: Int) -> Unit) {
            printer(num1 + num2)
        }

        printSum(5, 5) { result ->
            Log.w("FUNCTIONS-2", "Lambda expresssion printing the sum result (10) => $result")
        }

        //Si eol callback recigbe solo un parametro, podemos omitir eses "result" -> it
        printSum(12, 12) {
            Log.w("FUNCTIONS-2", "Lambda expresssion printing the sum result (24) => $it")
        }

        fun printSum2(
            num1: Int,
            num2: Int,
            printer: (result: Int, param1: Int, param2: Int) -> Unit
        ) {
            printer(num1 + num2, num1, num2)
        }

        printSum2(7, 7) { result, param1, param2 ->
            Log.w("FUNCTIONS-2", "Lambda expresssion printing the sum result (14) => $result")
        }

        printSum2(7, 7) { result, _, _ ->
            Log.w("FUNCTIONS-2", "Lambda expresssion printing the sum result (14) => $result")
        }
    }

    private fun showCase3() {
        // Named arguments
        fun funtion1(
            firstName: String,
            lastName: String,
            age: Int,
            city: String,
            dateOfBirth: Date
        ) {

        }

        funtion1("", "", 21, "", Date())
        funtion1(
            age = 21,
            dateOfBirth = Date(),
            firstName = "Armando",
            lastName = "Santos",
            city = "Capitual"
        )
    }

    private fun showCase4() {
        // Single-Expression functions
        fun sum(param1: Int, param2: Int) = param1 + param2
    }

    private fun showCase5() {
        // Variable number of arguments (Varargs)
        fun sumAll(vararg numbers: Int) = numbers.sum()

        val result = sumAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        Log.w("FUNCTIONS-5", "vararg result is 55 => $result")
    }

    private fun showCase6() {
        // Extension Functions

        // Si es declarada dentro de este metodo solo tenemos acceso a el en este mismo contexto de funcion
        fun String.welcome(){
            Log.w("FUNCTIONS-6","welcome to kotlin and to extension Functions!")
        }

        "".welcome()
    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
    }
}

//Si es declarada aqui, se tendra acceso en toda la app
fun String.welcomeKotlin(){
    Log.w("FUNCTIONS-6","welcome to kotlin and to extension Functions Globally!")
}