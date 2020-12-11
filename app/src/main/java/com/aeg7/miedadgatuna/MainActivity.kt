package com.aeg7.miedadgatuna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aeg7.miedadgatuna.databinding.ActivityMainBinding
import javax.microedition.khronos.egl.EGLDisplay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ageEdit:EditText=binding.Cuestion
        val resultText:TextView=binding.Resultado
        val button: Button =binding.Boton

        binding.Resultado.text=getString(R.string.waiting)

        Log.v("MainActivity", "Activity Created verbose")
        Log.d("MainActivity", "Activity Created debug")
        Log.i("MainActivity", "Activity Created info")
        Log.w("MainActivity", "Activity Created warning")
        Log.e("MainActivity", "Activity Created error")

        binding.Boton.setOnClickListener{
            val ageString:String=binding.Cuestion.text.toString()
            if (ageString.isNotEmpty()){
                val ageInt:Int=ageString.toInt()
                var result:Int=ageInt

                result= when (ageInt){
                    1 -> {
                        10
                    }
                    2 -> {
                        24
                    } else -> (4*ageInt)+24
                }
                binding.Resultado.text= getString(R.string.catage, result)
                        Toast.makeText(this,getString(R.string.resultintodb), Toast.LENGTH_LONG).show()
            } else{
                Log.d("MainActivity", "Age string is empty")
                Toast.makeText(this, getString(R.string.toastage), Toast.LENGTH_SHORT).show()
            }
        }
    }
}