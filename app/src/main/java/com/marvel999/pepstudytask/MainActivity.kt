package com.marvel999.pepstudytask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.marvel999.pepstudytask.Repo.dataclass.Ability
import com.marvel999.pepstudytask.viewmodel.MainActivityViewModel
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    //Progressbar view
    private lateinit var applicationProgress: ProgressBar;
    private lateinit var skillProgress: ProgressBar;
    private lateinit var understandingProgress: ProgressBar;
    private lateinit var knowledgeProgress: ProgressBar;

    //Percentage view
    private lateinit var applicationPercentage: TextView;
    private lateinit var skillPercentage: TextView;
    private lateinit var understandingPercentage: TextView;
    private lateinit var knowledgePercentage: TextView;

    //viewModel object
    private lateinit var viewModel: MainActivityViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //view identification
        applicationProgress = findViewById(R.id.aplication_pb);
        skillProgress = findViewById(R.id.thinking_pb);
        understandingProgress = findViewById(R.id.understanding_pb);
        knowledgeProgress = findViewById(R.id.knowledge_pb);
        applicationPercentage = findViewById(R.id.Application_percentage_tv);
        skillPercentage = findViewById(R.id.skilLayout_percentage_tv);
        understandingPercentage = findViewById(R.id.underStanding_percentage_tv);
        knowledgePercentage = findViewById(R.id.knowledge_percentage_tv);
        //View model instance
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java);
        //get data from viewModel
        viewModel.getScienceData(applicationContext, "science.json");
        // observe Livedata
        viewModel.scienceData.observe({ lifecycle }) {
            //update view
            setdataOnView(it);
        }

    }

    //function updating view
    fun setdataOnView(data: List<Ability>) {
        data.forEach() {
            var percentage = calculatePercentage(
                it.totalMarksObtained,
                it.outOf
            );
            percentage = String.format("%.2f", percentage).toDouble()
            Log.e(it.name, percentage.toString());
            if (it.name.equals("Application"))
                setApplication(percentage)
            else if (it.name.equals("Skill"))
                setSkill(percentage);
            else if (it.name.equals("Understanding"))
                setUnderstanding(percentage);
            else
                setKnowledge(percentage);


        }
    }

    //calculatePercentage using given data
    private fun calculatePercentage(obtained: Double, max: Double): Double {
        Log.e(obtained.toString(), max.toString())
        val percentage = (obtained * 100 / max);
        Log.e("Percentage: ", percentage.toString())
        return percentage;
    }

    //setApplication text view and progressbar
    private fun setApplication(progress: Double) {
        applicationPercentage.text = "$progress%";
        applicationProgress.progress = progress.roundToInt();

    }

    //setSkill text view and progressbar
    private fun setSkill(progress: Double) {
        skillPercentage.text = "$progress%";
        skillProgress.progress = progress.roundToInt();

    }

    //setUnderstanding text view and progressbar
    private fun setUnderstanding(progress: Double) {
        understandingPercentage.text = "$progress%";
        understandingProgress.progress = progress.roundToInt();

    }

    //setKnowledge text view and progressbar
    private fun setKnowledge(progress: Double) {
        knowledgePercentage.text = "$progress%";
        knowledgeProgress.progress = progress.roundToInt();

    }


}