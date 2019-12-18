package com.armandosantos.holamundo.other

import android.util.Log

class Operators {
    private fun showCase1() {
        var a = 5
        var b = 5

        Log.w("OPERATORS-1", "Referential equality. Es 'a' igual a 'b'? ${a === b}")  //true
        Log.w("OPERATORS-1", "Structural equality. Es 'a' igual a 'b'? ${a == b}")  //true
    }

    private fun showCase2() {
        val pn1 = PersonNormal()
        val pn2 = PersonNormal()


        Log.w(
            "OPERATORS-2",
            "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1 === pn2}"
        )  //false
        Log.w(
            "OPERATORS-2",
            "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}"
        )  //false porque no sobreescribe equals
    }

    private fun showCase3() {
        val pn1 = PersonEqualOverride()
        val pn2 = PersonEqualOverride()

        Log.w(
            "OPERATORS-3",
            "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1 === pn2}"
        )  //false
        Log.w("OPERATORS-3", "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}")  //true
    }


    private fun showCase4() {
        val pn1 = PersonDataClass()
        val pn2 = PersonDataClass()

        Log.w(
            "OPERATORS-4",
            "Referential equality. Es 'pn1' igual a 'pn2'? ${pn1 === pn2}"
        )  //false
        Log.w("OPERATORS-4", "Structural equality. Es 'pn1' igual a 'pn2'? ${pn1 == pn2}")  //true
    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
    }


    class PersonNormal {
        val name = "Alejandro"
    }

    class PersonEqualOverride {
        var name = "Alejando"
        override fun equals(other: Any?): Boolean {
            if (other === null) return false
            if (other is PersonEqualOverride) {
                return other.name === this.name
            }
            return false
        }
    }

    data class PersonDataClass(val name: String = "Armando", val age: Int = 21)
}