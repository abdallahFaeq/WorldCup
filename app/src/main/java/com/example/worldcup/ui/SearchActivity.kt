package com.example.worldcup.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.worldcup.R
import com.example.worldcup.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity<ActivitySearchBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivitySearchBinding
        get() = ActivitySearchBinding::inflate
    override val LOG_TAG: String
        get() = "activity_search"

    override fun addCallbacks() {
    }

    override fun setup() {
    }

}