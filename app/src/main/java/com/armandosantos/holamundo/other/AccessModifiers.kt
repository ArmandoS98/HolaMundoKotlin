package com.armandosantos.holamundo.other

open class AccessModifiers {
    //private       --- solo visible dentro de la clase
    //protected     --- solo visible dentro de la clase y de sus subClases(herencia)
    //public        --- visible desde dentro de la clase, de sus subClases y desde fuera

    val prop1 = "Public by default"
    private val prop2 = "Marked as private"
    protected val prop3 = "Marked as protected"

    private fun showCases() {
        val test = AccessModifiers()
        test.prop1
        this.prop1
    }
}

class AccessModiffiersChild : AccessModifiers() {
    private fun showCases() {
        prop1
        this.prop1
        // prop2 por ser private no puede ser accesible
        prop3
    }
}

class AnotherClass{
    private fun showCase(){
        val test = AccessModifiers()
        test.prop1
    }
}