package dev.ogabek.browser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class BrowserActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var btn_back: ImageButton
    private lateinit var btn_next: ImageButton
    private lateinit var btn_reflesh: ImageButton
    private lateinit var btn_search: ImageButton
    private lateinit var webSearch: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        webView = findViewById(R.id.webView)
        btn_back = findViewById(R.id.btn_back)
        btn_next = findViewById(R.id.btn_next)
        btn_reflesh = findViewById(R.id.btn_reflesh)
        btn_search = findViewById(R.id.btn_search)
        webSearch = findViewById(R.id.webSearch)

        initViews()

    }

    private fun initViews() {
        setWebView()
        btn_back.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            }
        }
        btn_next.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            }
        }
        btn_reflesh.setOnClickListener {
            webView.reload()
        }
        btn_search.setOnClickListener {
            val text = webSearch.text.split(" ")
            var textString = ""
            for (i in text) {
                textString += i
            }
            textString = textString.substring(0, textString.length)
            val search = "https://www.google.com/search?q=$textString&rlz=1C5CHFA_enUZ975UZ975&sxsrf=AOaemvJaftYj_J4UY6e9h_TAoLksSpO6Gg%3A1640320995287&ei=40_FYYj0EKnprgTs0b-YAQ&ved=0ahUKEwjI8fbxz_v0AhWptIsKHezoDxMQ4dUDCA4&uact=5&oq=salom+cinema&gs_lcp=Cgdnd3Mtd2l6EAMyCwguEIAEEMcBEK8BMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjIGCAAQFhAeMgYIABAWEB4yBggAEBYQHjICCCY6BwgAEEcQsAM6BwgAELADEEM6CgguEMgDELADEEM6EAguEMcBEKMCEMgDELADEEM6EAguEMcBENEDEMgDELADEEM6BQgAEIAEOgcILhCABBAKOgcIABCABBAKOgUILhCABDoKCAAQgAQQhwIQFDoNCC4QgAQQxwEQ0QMQCjoECAAQCjoKCC4QxwEQrwEQCkoECEEYAEoECEYYAVCLCljXHmCpIGgBcAJ4AIAB5AGIAYcKkgEFMC40LjOYAQCgAQHIARTAAQE&sclient=gws-wiz"
            webView.loadUrl(search)
        }
    }

    private fun setWebView() {
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://google.com")
    }

}