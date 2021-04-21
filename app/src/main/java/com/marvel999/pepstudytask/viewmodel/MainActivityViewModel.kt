package com.marvel999.pepstudytask.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marvel999.pepstudytask.Repo.dataclass.Ability
import com.marvel999.pepstudytask.Repo.dataclass.ScienceData
import com.marvel999.pepstudytask.Repo.fatchdata.Utills

class MainActivityViewModel:ViewModel() {
    var _scienceData = MutableLiveData<List<Ability>>();
    val scienceData:LiveData<List<Ability>> =_scienceData;

    fun getScienceData(context: Context, fileName: String){
        val jsonFileString = Utills.getJsonDataFromAsset(context, fileName)
//        Log.i("data", jsonFileString.toString())
        val gson = Gson()
        val listScienceType = object : TypeToken<ScienceData>() {}.type

        var scienceData: ScienceData = gson.fromJson(jsonFileString, listScienceType)
        _scienceData.postValue(scienceData.abilities);
    }
}