package com.marvel999.pepstudytask.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.marvel999.pepstudytask.Repo.GetScienceData
import com.marvel999.pepstudytask.Repo.ScienceRepo
import com.marvel999.pepstudytask.Repo.dataclass.Ability
import com.marvel999.pepstudytask.Repo.dataclass.ScienceData
import com.marvel999.pepstudytask.Repo.fatchdata.Utills

class MainActivityViewModel:ViewModel() {
   private var _scienceData = MutableLiveData<List<Ability>>();
   public val scienceData:LiveData<List<Ability>> =_scienceData;
    private lateinit var  getScienceRepo:ScienceRepo
    fun getScienceData(context: Context, fileName: String){
        getScienceRepo = GetScienceData();
        val jsonFileString = getScienceRepo.getScienceData(context, fileName)
        val gson = Gson()
        val listScienceType = object : TypeToken<ScienceData>() {}.type

        var scienceData: ScienceData = gson.fromJson(jsonFileString, listScienceType)
        _scienceData.postValue(scienceData.abilities);
    }
}