package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var num : TextView
    private var counter : Int = 0
    val rnd = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num = findViewById(R.id.num)
        num.text = counter.toString()
    }

    fun sum(view: View){
        counter++

        num.text = counter.toString()
    }
    fun sub(view: View){
        counter--

        num.text = counter.toString()
    }
    fun textAug(view: View){
        num.setTextSize(TypedValue.COMPLEX_UNIT_PX, num.textSize + 10)
    }
    fun textDec(view: View){
        num.setTextSize(TypedValue.COMPLEX_UNIT_PX, num.textSize - 10)
    }

    fun hide(view: View){
        num.isVisible = false
    }
    fun show(view: View){
        num.isVisible = true
    }

    fun tcolor(view: View){
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        num.setTextColor(color)
    }

    fun bgcolor(view: View){
        var bg: ConstraintLayout = findViewById(R.id.background)
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        bg.setBackgroundColor(color)

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {


        savedInstanceState.putString("number", counter.toString())

        // etc.
        super.onSaveInstanceState(savedInstanceState)
    }

//onRestoreInstanceState

    //onRestoreInstanceState
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        num.text = savedInstanceState.getString("number")
    }
}