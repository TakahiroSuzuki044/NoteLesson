package com.tachisatok.notelesson.view.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.tachisatok.notelesson.R
import kotlinx.android.synthetic.main.fragment_license.*

class LicenseFragment : Fragment() {

    private var mWebView: WebView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_license, container, false)

        mWebView = view.findViewById(R.id.fragment_license_web_view)
        mWebView!!.loadUrl("file:///android_asset/html/license.html")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        license_toolbar.title = getString(R.string.licence)
        license_toolbar.setTitleTextColor(ContextCompat.getColor(requireContext(), R.color.white))
    }

    override fun onDestroy() {
        super.onDestroy()
        mWebView!!.destroy()
    }
}