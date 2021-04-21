package com.marvel999.pepstudytask.Repo

import android.content.Context

interface ScienceRepo {
    fun getScienceData(context: Context, fileName: String):String?

}