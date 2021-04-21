package com.marvel999.pepstudytask

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.marvel999.pepstudytask.Repo.GetScienceData
import com.marvel999.pepstudytask.viewmodel.MainActivityViewModel

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.marvel999.pepstudytask", appContext.packageName)
    }

    // getting data from json file
    @Test
    fun getdata(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext;
        assertNotNull(GetScienceData().getScienceData(appContext,"science.json"));
    }


}