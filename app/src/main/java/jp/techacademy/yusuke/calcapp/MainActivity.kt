package jp.techacademy.yusuke.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AlertDialog
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

    override fun onClick(v: View) {

        val intent = Intent(this, SecondActivity::class.java)

        if(v.id == R.id.button1){
            intent.putExtra("KEYWORD", "+")
        } else if(v.id == R.id.button2){
            intent.putExtra("KEYWORD", "-")
        } else if(v.id == R.id.button3){
            intent.putExtra("KEYWORD", "*")
        } else if(v.id == R.id.button4){
            intent.putExtra("KEYWORD", "/")
        }

        if(editText1.text.toString().isNotEmpty() && editText2.text.toString().isNotEmpty()){
            intent.putExtra("VALUE1", editText1.text.toString().toFloat())
            intent.putExtra("VALUE2", editText2.text.toString().toFloat())
            startActivity(intent)
        } else{
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Warning!")
        alertDialogBuilder.setMessage("数値が入力されていません")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("戻る"){dialog, which ->
            Log.d("UI_PARTS", "戻る")
        }

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}