package com.marvel999.pepstudytask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marvel999.pepstudytask.Repo.dataclass.ScienceData
import com.marvel999.pepstudytask.Repo.fatchdata.Utills
import com.marvel999.pepstudytask.viewmodel.MainActivityViewModel
import java.io.IOException
import java.util.List.of
import java.util.stream.Stream.of

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:MainActivityViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java);
        viewModel.getScienceData(applicationContext,"science.json");
        viewModel.scienceData.observe({lifecycle}){
            Log.e("data", it.toString())
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show();
        }

    }


}