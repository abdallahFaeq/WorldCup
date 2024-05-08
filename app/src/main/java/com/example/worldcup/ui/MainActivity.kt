package com.example.worldcup.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.worldcup.data.DataManager
import com.example.worldcup.data.domain.Match
import com.example.worldcup.databinding.ActivityMainBinding
import com.example.worldcup.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding = ActivityMainBinding::inflate
    override val LOG_TAG: String = "ACTIVITY_MAIN"

    override fun addCallbacks() {
        binding?.apply {
            nextIcon.setOnClickListener({
                bindMatch(DataManager.getNextMatch())
            })

            previusIcon.setOnClickListener({
                bindMatch(DataManager.getPreviousMatch())
            })
        }
    }


    override fun setup() {
        openFile()
    }

    fun openFile():List<Match>{
        val inputStream = assets.open("worldcup.csv")
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        bufferReader.forEachLine {
            val currentMatch = parser.parse(it)
            DataManager.addMatch(currentMatch)
        }
        bindMatch(DataManager.getCurrentMatch())
        log(DataManager.getCurrentMatch().toString())

        return DataManager.getMatchesList()
    }

    fun bindMatch(match:Match){
        binding?.apply {
            yearLabel.text = match.year.toString()
            staduimLabel.text = match.stadium
            homeTeamNameLabel.text = match.homeTeamName
            awayTeamNameLabel.text = match.awayTeamName
            homeTeamGoalLabel.text = match.homeTeamGoal.toString()
            awayTeamGoalLabel.text = match.awayTeamGoal.toString()
        }
    }

}