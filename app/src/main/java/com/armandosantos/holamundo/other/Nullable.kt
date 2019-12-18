package com.armandosantos.holamundo.other

class Nullable {
    private fun showCase1() {
        throw NullPointerException()
    }

    private fun showCase2(var1: String?) {
        var1.toString() //Devulve null en caso de que var1 sea null
        var1!!.toString() //Devuelve un NPE en caso de que var1 esa null
    }

    private fun showCase3() {

    }

    private lateinit var varialbe1: String
    private var variable2: String? = null

    private fun showCase4() {
        varialbe1.length //Devuelve un NPE porque variable1 no ha sido latenit y se ha marcado como tal.
        variable2?.length
    }

    fun showCases() {
        showCase1()
        showCase2("hi")
        showCase3()
        showCase4()
    }
}