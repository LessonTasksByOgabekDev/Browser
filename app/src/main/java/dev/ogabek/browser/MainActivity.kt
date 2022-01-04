package dev.ogabek.browser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    fun initViews() {
        val openBrowser = findViewById<Button>(R.id.open_browser_btn)
        openBrowser.setOnClickListener {
            openBrowserActivity()
        }
    }

    fun openBrowserActivity() {
        startActivity(Intent(this, BrowserActivity::class.java))
    }

}