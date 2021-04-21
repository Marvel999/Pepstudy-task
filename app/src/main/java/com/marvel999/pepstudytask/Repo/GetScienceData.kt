package com.marvel999.pepstudytask.Repo

import android.content.Context
import com.marvel999.pepstudytask.Repo.fatchdata.Utills

class GetScienceData:ScienceRepo {
    override fun getScienceData(context: Context, fileName: String): String? {
        return Utills.getJsonDataFromAsset(context,fileName);
    }
}