package com.armandosantos.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.armandosantos.holamundo.other.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = 5
        println(a)

        variables().showCases()
        Nullable()
        Operators().showCases()
        ControlFlow()
        Classes().showCases()
        Functions().showCases()
        CompanionObject().showCases() 
    }
}
