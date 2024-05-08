package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding?> : AppCompatActivity(){
    abstract val bindingInflater : (LayoutInflater) -> VB
    private var _binding:ViewBinding ?= null
    protected val binding
    get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = bindingInflater(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        Toast.makeText(this,"base activity",Toast.LENGTH_SHORT).show()

        setup()
        addCallbacks()
    }
    abstract val LOG_TAG :String

    abstract fun addCallbacks()
    abstract fun setup()
    fun log(value:String){
        Log.i(LOG_TAG, value)
    }
}