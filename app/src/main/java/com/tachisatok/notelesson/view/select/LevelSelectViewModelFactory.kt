package com.tachisatok.notelesson.view.select

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LevelSelectViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == LevelSelectViewModel::class.java) return LevelSelectViewModel(context) as T

        throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
    }
}