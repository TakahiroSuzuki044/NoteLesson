package com.tachisatok.notelesson.view.base

import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R

abstract class BaseActivityForBackStack : BaseActivity() {

    private val TAG = BaseActivityForBackStack::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val manager = supportFragmentManager
        // Activityが破棄後に再生成されたとき、昔のフラグメントがBackStackに存在する場合はそれを表示するのでなにもしない
        // BackStackに何もない場合はフラグメントを生成する
        if (manager.backStackEntryCount == 0) {
            setFragment(getStackFragment(), true, null)
        }
    }

    /**
     * Fragmentを置き換える
     *
     * @param fragment 置き換えるFragment
     */
    private fun setFragment(fragment: Fragment, isStack: Boolean, tag: String?) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content, fragment, tag)
        if (isStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    /**
     * 表示するFragmentを返却する
     *
     * @return Fragment
     */
    protected abstract fun getStackFragment(): Fragment

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val manager = supportFragmentManager

            if (manager.backStackEntryCount <= 1) {
                // 現在のFragment数が1でバックキー押下の場合は、Fragment自体が消えるのでFinish.

                finish()
                return true
            } else {
                // スタックが複数存在している場合は一つポップする

                manager.popBackStack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {

                // バックキー処置と同じ挙動にする
                onKeyDown(KeyEvent.KEYCODE_BACK, null)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}