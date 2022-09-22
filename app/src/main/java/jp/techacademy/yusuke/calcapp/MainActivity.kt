package jp.techacademy.yusuke.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val VALUE1 = editText1.text.toString().toFloat()
        val VALUE2 = editText2.text.toString().toFloat()

        when(v?.id){
            R.id.button1 -> intent.putExtra("VALUE3", VALUE1+VALUE2)
            R.id.button2 -> intent.putExtra("VALUE3", VALUE1-VALUE2)
            R.id.button3 -> intent.putExtra("VALUE3", VALUE1*VALUE2)
            R.id.button4 -> intent.putExtra("VALUE3", VALUE1/VALUE2)
        }

        val intent = Intent(this, SecondActivity::class.java)


        Log.d("DEBUG_APP","VALUE1=${VALUE1}")
        Log.d("DEBUG_APP","VALUE2=${VALUE2}")

        startActivity(intent)
    }
}