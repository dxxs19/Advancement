package com.wei.advancement

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.wei.advancement.widget.SideBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SideBar.OnChooseLetterChangedListener {
    var sideBar : SideBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()
        sideBar = findViewById(R.id.sidebar)
        sideBar?.setOnTouchingLetterChangedListener(this)
    }

    override fun onChooseLetter(s: String?) {
        sample_text.text = s
    }

    override fun onNoChooseLetter() {

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
