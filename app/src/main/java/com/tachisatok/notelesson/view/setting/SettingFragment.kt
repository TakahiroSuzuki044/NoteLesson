package com.tachisatok.notelesson.view.setting

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.BuildConfig
import com.tachisatok.notelesson.R
import com.tachisatok.notelesson.util.ShareUtil
import com.tachisatok.notelesson.view.debug.DebugActivity
import kotlinx.android.synthetic.main.section_layout.view.*
import kotlinx.android.synthetic.main.setting_fragment.*

class SettingFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.setting_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setting_fragment_toolbar.title = getString(R.string.setting_title)
        setting_fragment_toolbar.setTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
    }

    /**
     * Viewの初期化処理
     */
    private fun initView() {
        // セクション
        val sectionOtherTextView = setting_section_other_layout.section_text_view
        sectionOtherTextView.setText(R.string.other)

        // 各レイアウト要素
        setView(setting_list_terms_layout, R.string.term)
        setView(setting_list_privacy_policy_layout, R.string.privacy_policy)
        setView(setting_list_licence_layout, R.string.licence)

        // デバッグ機能
        setView(setting_debug_layout, R.string.debug)

        if (BuildConfig.DEBUG) {
            setting_debug_layout.visibility = View.VISIBLE
        }
    }

    /**
     * 各レイアウトの設定をする
     *
     * @param v View
     * @param res 表示するテキストのリソースID
     */
    private fun setView(v: View, res: Int) {
        v.isClickable = true
        v.isFocusable = true
        v.setOnClickListener(this)
        val textView = v.findViewById<TextView>(R.id.section_list_text_view)
        textView.setText(res)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.setting_list_terms_layout -> {
                // ご利用規約

                startApp(ShareUtil.geTermOfServiceUri())
            }
            R.id.setting_list_privacy_policy_layout -> {
                // プライバシーポリシー

                startApp(ShareUtil.getPrivacyPolicyUri())
            }
            R.id.setting_list_licence_layout -> {
                // ライセンス

                fragmentManager?.beginTransaction()?.apply {
                    replace(R.id.content, LicenseFragment())
                    addToBackStack(null)
                    commit()
                }
            }
            R.id.setting_debug_layout -> {
                // デバッグ機能

                val debugActivityIntent = Intent(requireContext(), DebugActivity::class.java)
                startActivity(debugActivityIntent)
            }
        }
    }

    /**
     * アプリを起動する
     *
     * @param intent 起動用のIntent
     */
    private fun startApp(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            showNotFoundApp()
        }
    }

    /**
     * 起動できるアプリが存在しなかったことを表示する
     */
    private fun showNotFoundApp() {
        Toast.makeText(context, getString(R.string.not_found_app_text), Toast.LENGTH_SHORT).show()
    }
}