package com.promedia.querysql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.promedia.querysql.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b= ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.bottomNavigationView2.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itAnadir -> {
                    findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.insert_fragment)
                    true
                }
                R.id.itModificar -> {
                    findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.modificar_fragment)
                    true
                }
                R.id.itBorrar -> {
                    findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.delete_fragment)
                    true
                }
                R.id.itConsultar -> {
                    findNavController(R.id.fragmentContainerView)
                        .navigate(R.id.query_fragment)
                    true
                } else -> false
            }
        }
    }
}
