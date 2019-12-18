package com.armandosantos.holamundo.other

import android.util.Log

class Classes {
    private fun showCase1() {
        //CONSTRUCTURES PRIMARIOS
        class Person1

        class Person2 constructor(var firtsName: String)//constructor PRIMARIO
        class Person3(var firtsName: String) //*constructor* puede ser omitido
        class Person4(val firtsNmae: String, val lastName: String, var age: Int) {
            init {
                age = 10
            }
        }

        class Person5(
            val firtsNmae: String = "Armando",
            val lastName: String = "Santos",
            var age: Int = 21
        )

        //Para crear instancias de objetos, no usamos la palabra "new"
        val p1 = Person1()
        val p2 = Person2("Armando")
        val p3 = Person3("Armando")
        val p4 = Person4("Armando", "Santos", 21)
        val p5_1 = Person5("Armando", "Santos", 21)
        val p5_2 = Person5(age = 22)
        val p5_3 = Person5(lastName = "Santos")
        val p5_4 = Person5(firtsNmae = "Armando")
    }

    private fun showCase2() {
        //CONSTRUCTORES SECUNDARIOS
        open class Person {
            constructor(firstName: String, lastName: String) {
                Log.w("CLASSES-2", "Welcome $firstName $lastName")
            }
        }

        class Person1 : Person {
            constructor(firstName: String) : super(firstName, "Santos")
            constructor(firstName: String, lastName: String) : super(
                firstName,
                lastName
            )
        }

        val p = Person1("Emmaneul", "Santos")
        //No tenemos accfeso a person.firtsName, ver showCase numero 5
    }

    private fun showCase3() {
        //Difrencia entre INIT y CONSTRUCTOR secundario

        class Person1 {
            //Init se va a ejecutart antes del contructor secundario y despues que el contructor primario
            init {
                Log.w("CLASSES-3", "Bienvenido desde init!")
            }

            constructor(firtsName: String, lastName: String) {
                Log.w("CLASSES-3", "Bienvenido desde contructor secundario!")
            }
        }

        class Person2(firtsName: String, lastName: String) {
            init {
                //Aqui si podemos acceder a las propiedades concervando INIT y constructor secundario
            }

            constructor() : this("Armando", "Santos")
        }

        val p1 = Person1("Armando", "Santos")
        val p2 = Person2("Emmaneul", "Santos")
        val p3 = Person2()
    }

    private fun showCase4() {
        // ¿VAL, VAR O NADA EN EL CONTRUCTOR?
        class Person1(firtsName: String) // no pudes acceder a firtsName cuando creer la instancia

        class Person2(var firtsName: String) // pudes acceder a firtsName cuando crees la instancia y puedes cambiar su valor
        class Person3(val firtsName: String) // pudes acceder a firtsName cuando crees la instancia. pero no puedes cambiar su valor

        val p1 = Person1("")
        val p2 = Person2("")
        val p3 = Person3("")

        //p1.firstName // Error
        p2.firtsName
        p3.firtsName
    }

    private fun showCase5() {
        //PROPIEDADES - GETTERS & SETTERS

        class Person1(var firstName: String)

        val p1 = Person1("Armadno")
        p1.firstName //Seria el equivalente a getFirstName()
        p1.firstName = "Emmanuel" // Seria el equivalente a setFirstName("Emmanuel" )

        class Person2 {
            //Field - representa a la propiedad, nunca usar this.propiedad
            var firstName: String
                get() = field.capitalize()
                set(value) {
                    field = value.capitalize()
                }

            constructor(firstName: String, lastName: String) {
                this.firstName = firstName

            }
        }
    }

    private fun showCase6() {
        //HERENCIA E INTERFACES

        open class Person1(var name: String)
        open class Person2(open var name: String)
        open class Person3(open var name: String)

        //Si heredamos de Person1, las propiedades no se pueden llamar de igual forma entre padre e hijo
        //class Person11(var name: String) : Person1(name)

        //Podemos mantener ambas con el mismo nombre, pero tenemos que añadir open y override
        class Person22(override var name: String) : Person2(name)

        // Todo junto
        class Person33(override var name: String, override var age: Int) : Person3(name), IPersona {
            override fun hello() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    private fun showCase7() {
        // OVERRIDE y SUPER
        abstract class Person(open var firstName: String, open var lastName: String) {
            abstract fun hello()

            fun welcomeKotlin() {
                Log.w("CLASSES-7", "Welcome to Kotlin!")
            }

            open fun welcomeDevelopers() {
                Log.w("CLASSES-7", "Welcome to Developers!")
            }
        }

        class Man(override var firstName: String, override var lastName: String) :
            Person(firstName, lastName) {
            override fun hello() {
                Log.w("CLASSES-7", "Hello, I am $firstName $lastName!")
            }

            override fun welcomeDevelopers() {
                super.welcomeDevelopers()
                super.welcomeKotlin()
                Log.w("CLASSES-7", "Yeah!")
            }
        }

        val man = Man("Armando", "Santos")
        man.hello()
        man.welcomeKotlin()
        man.welcomeDevelopers()
    }

    private fun showCase8() {
        // DATA CLASSES
        // Segun la documentacion oficial, para hacer uso correcto de Data Clases debe;
        // El constructor primario necesita tener al menos 1 parametro
        // Todos los parametros del constructor primario deben ser marcados como 'val' o 'var'
        // Data classes no pueden ser "abstract, open, sealed or inner"

        data class Person(var firstName: String, var lastName: String)

        val p = Person("Armando", "Santos")
        val p2 = p
        val personString = p.toString()
        val personCopy = p.copy()
        val clone = p.copy(firstName = "Armando")
        val (firstName, lastName) = p //Destructuring

        Log.w("CLASSES-8", "Data class toString() => $personString!")
        Log.w("CLASSES-8", "Data class copy() => $personCopy!")
        Log.w(
            "CLASSES-8",
            "p must be same reference than p2 => ${p === p2}!"
        ) //true, referential Equality
        Log.w(
            "CLASSES-8",
            "p must be different reference than personCopy => ${p !== personCopy}!"
        ) //true, referential Equality
        Log.w(
            "CLASSES-8",
            "p must have same prperty values than personCopy => ${p == personCopy}!"
        ) //true, Structual Equality
        Log.w(
            "CLASSES-8",
            "p must be different reference than clone => ${p !== clone}!"
        ) //true, Structual Equality
        Log.w(
            "CLASSES-8",
            "p must have different propertly values than clone => ${p != clone}!"
        ) //true, Structual Equality
        Log.w(
            "CLASSES-8",
            "firstName by destructuring must be 'Armando' => $firstName!"
        )
        Log.w(
            "CLASSES-8",
            "lastName by destructuring must be 'Armando' => $lastName!"
        )
    }

    private fun showCase9() {
        // ENUM CLASSES

        Log.w("CLASSES-9", "ENUM DayOfWeek.LUNES should be LUNES => ${DayOfWeek.LUNES.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.LUNES should be 0 => ${DayOfWeek.LUNES.ordinal}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.LUNES should be VIERNES => ${DayOfWeek.VIERNES.name}")
        Log.w("CLASSES-9", "ENUM DayOfWeek.LUNES should be 4 => ${DayOfWeek.VIERNES.ordinal}")
    }

    fun showCases() {
        showCase1()
        showCase2()
        showCase3()
        showCase4()
        showCase5()
        showCase6()
        showCase7()
        showCase8()
        showCase9()
    }
}

interface IPersona {
    var age: Int
    fun hello()
}

enum class DayOfWeek { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO }