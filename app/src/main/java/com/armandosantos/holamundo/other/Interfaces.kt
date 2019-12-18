package com.armandosantos.holamundo.other

import android.util.Log

class Interfaces {
    private var anonymouseObjectImplementingInterfaces: Any? = null

    private fun showCase1() {
        anonymouseObjectImplementingInterfaces = object : Interface1 {
            override fun abstractMethod() {
                //Poner codigo es totalmente opcional
            }
        }
        //Necesitamos castear ya que en la declaracin lo hace3mos como ANY y no pude infereir el tipo correctamente
        (anonymouseObjectImplementingInterfaces as Interface1).methodWithImplemetationByDefault()
        (anonymouseObjectImplementingInterfaces as Interface1).abstractMethod()
    }

    private fun showCase2() {
        val aoii = object : Interface2 {
            override val propertyAbstract: Int
                get() = 10
        }

        aoii.propertyAbstract
        aoii.propertyWithImplementation
        aoii.hello()
    }

    fun showCases() {
        showCase1()
        showCase2()
    }
}

interface Interface1 {
    fun abstractMethod()
    fun methodWithImplemetationByDefault() {

    }
}

interface Interface2 {
    val propertyAbstract: Int
    var propertyWithImplementation: String
        get() = "ByDefault"
        set(value) {
            this.propertyWithImplementation = value
        }

    fun hello() {
        Log.w("Interfaz-2", "Is it working $propertyWithImplementation?, YaY! $propertyAbstract :)")
    }
}