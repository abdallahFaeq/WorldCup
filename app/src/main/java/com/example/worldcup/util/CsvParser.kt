package com.example.worldcup.util

import com.example.worldcup.data.domain.Match
import com.example.worldcup.util.Constant.ColumnIndex

class CsvParser {
    fun parse(line:String):Match{
        val tokens = line.split(",")
        return Match(
            year = tokens[ColumnIndex.year].toInt(),
            stadium = tokens[ColumnIndex.stadium],
            city = tokens[ColumnIndex.city],
            homeTeamName = tokens[ColumnIndex.homeTeamName],
            awayTeamName = tokens[ColumnIndex.awayTeamName],
            homeTeamGoal = tokens[ColumnIndex.homeTeamGoal].toInt(),
            awayTeamGoal = tokens[ColumnIndex.awayTeamGoal].toInt(),
        )
    }
}