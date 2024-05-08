package com.example.worldcup.data

import com.example.worldcup.data.domain.Match

object DataManager {
    private var matchesList  = mutableListOf<Match>()
    private var matchIndex = 0

    fun addMatch(match: Match){
        matchesList.add(match)
    }
    fun getMatchesList() : MutableList<Match>{
        return matchesList
    }
    fun getCurrentMatch():Match{
        return matchesList[matchIndex]
    }
    fun getPreviousMatch():Match{
        if (matchIndex>0){
            return matchesList[--matchIndex]
        }
        return matchesList[matchIndex]
    }
    fun getNextMatch():Match{
        if (matchIndex< matchesList.size-1){
            return matchesList[++matchIndex]
        }
        return matchesList[matchIndex]
    }

}