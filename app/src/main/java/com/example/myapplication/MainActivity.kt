package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import java.math.RoundingMode
import kotlin.toString

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showBTN.setOnClickListener {
            val height = binding.heightet.text.toString().toDouble()
            val weight = binding.weightet.text.toString().toDouble()


            val bmi= weight / (height*height)

            binding.bmiTV.text = "YOur BMi: ${bmi.toBigDecimal().setScale(2,RoundingMode.CEILING)} "

            binding.speedometer.setSpeed(bmi.toInt(), 3000L){

                Toast.makeText(this@MainActivity, "${bmi.toInt()}", Toast.LENGTH_LONG).show()


            }

            if (bmi>30){

                binding.bmiType.text ="You Are Obesity"
                binding.bmiType.setTextColor(Color.BLUE)

            }else if(bmi>=25&& bmi<=30){
                binding.bmiType.text = "You Are Overweight"
                binding.bmiType.setTextColor(Color.RED)
            }else if (bmi>=18 && bmi<25){
                binding.bmiType.text = "You Are Helthy"
                binding.bmiType.setTextColor(Color.GREEN)
            }else{

                binding.bmiType.text = "You Are Underweight"
                binding.bmiType.setTextColor(Color.YELLOW)

            }


        }


    }
}