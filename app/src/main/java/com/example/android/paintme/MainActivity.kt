package com.example.android.paintme

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch

class MainActivity : AppCompatActivity() {

    lateinit var chngBgColor : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("Canvas",Context.MODE_PRIVATE)
        val  editor = sharedPreferences.edit()
        editor.putString("color","#FFFFFF")
        editor.apply()
        var myCanvasView : MyCanvasView = findViewById(R.id.myCanvas)

        myCanvasView.contentDescription = getString(R.string.canvasContentDescription)

        chngBgColor = findViewById(R.id.bgChange)
        chngBgColor.setOnClickListener{
            ColorPickerDialog
                .Builder(this)        				// Pass Activity Instance
                .setTitle("Pick Theme")           	// Default "Choose Color"
                .setColorShape(ColorShape.SQAURE)   // Default ColorShape.CIRCLE
                .setDefaultColor(R.color.teal_200)     // Pass Default Color
                .setColorListener { color, colorHex ->
                    // Handle Color Selection
                    Log.d("Color",colorHex)
                    myCanvasView.redDraw(colorHex)


                }
                .show()
        }



    }
}