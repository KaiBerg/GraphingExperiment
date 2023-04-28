package com.example.graphingtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.graphingtest.Data.Repo
import com.example.graphingtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportFragmentManager().beginTransaction().add(R.id.container, CatalogFragment()).commit();

        if(Repo.Measurements.isEmpty())
            Repo.setData(applicationContext)
    }
}