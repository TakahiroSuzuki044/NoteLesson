package com.tachisatok.notelesson.view.game

import android.os.Handler
import java.util.*

class GameTimer(
    private val callback: Callback,
    private val countDownTime: Int
) {

    private var timer = Timer()

    private var count = countDownTime

    /**
     * 計測中フラグ
     */
    private var isMeasuring: Boolean = false

    /**
     * 計測をスタートする
     */
    fun start() {
        if (isMeasuring) {
            return
        }
        isMeasuring = true
        timer = Timer()

        val handler = Handler()
        val task = object : TimerTask() {
            override fun run() {
                count--

                // 一秒ごとに通知する
                handler.post {
                    callback.onTime(count)
                }
            }
        }

        // 1秒後から1秒ずつ実行されるように設定する
        timer.scheduleAtFixedRate(task, 1000, 1000)
    }

    /**
     * タイマーをキャンセルする
     */
    fun cancel() {
        timer.cancel()
        isMeasuring = false
    }

    interface Callback {

        /**
         * 1秒ごとに通知を受け取るコールバック
         *
         * @param second 経過した秒数
         */
        fun onTime(second: Int)
    }
}