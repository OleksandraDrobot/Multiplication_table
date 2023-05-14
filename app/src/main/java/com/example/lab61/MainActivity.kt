package com.example.lab61

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.lab61.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun help(button: Button, number: Int){
            button.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.flFragmentHolder, TableFragment.newInstance(number, "fd"))
                    addToBackStack(null)
                    commit()
                }
            }
        }

        val view = binding.root
        val context = view.context
        for (i in 1..10) {
            val id1 = context.resources.getIdentifier("button$i", "id", context.packageName)
            val button = view.findViewById<TextView>(id1)
            help(button as Button, i)
        }
    }
}