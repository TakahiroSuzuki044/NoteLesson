package com.tachisatok.notelesson.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tachisatok.notelesson.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // todo 任意のテーマに変更できるように修正
        setTheme(R.style.AppThemeGreen)
    }
}