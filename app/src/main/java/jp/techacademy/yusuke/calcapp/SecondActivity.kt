package jp.techacademy.yusuke.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getFloatExtra("VALUE1", 0F)
        val value2 = intent.getFloatExtra("VALUE2", 0F)
        val keyword = intent.getStringExtra("KEYWORD")
        Log.d("DEBUG_APP", "VALUE1  =${value1}")
        Log.d("DEBUG_APP", "VALUE2  =${value2}")
        Log.d("DEBUG_APP", "KEYWORD =${keyword}")

        when (keyword) {
            "+" -> textView.text = "${value1 + value2}"
            "-" -> textView.text = "${value1 - value2}"
            "*" -> textView.text = "${value1 * value2}"
            "/" -> textView.text = "${value1 / value2}"
        }
    }
}