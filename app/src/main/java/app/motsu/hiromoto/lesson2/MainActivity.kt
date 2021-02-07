package app.motsu.hiromoto.lesson2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStore: SharedPreferences = getSharedPreferences("Datastore",Context.MODE_PRIVATE)

        saveButton.setOnClickListener {
            val stringText = editText.text.toString()
            saveText.text = stringText

            val editor = dataStore.edit()
            editor.putString("Input",stringText)

            editor.apply()
        }
        readButton.setOnClickListener {
            val str = dataStore.getString("Input", "NoData")
            readText.text = str
        }

        button.setOnClickListener {
            if(inputText.text != null){
                textView3.text = inputText.text.toString()
            }
        }
    }
}