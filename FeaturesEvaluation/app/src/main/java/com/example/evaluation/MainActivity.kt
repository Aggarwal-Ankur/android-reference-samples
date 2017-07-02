package com.example.evaluation

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.evaluation.java.DefaultMethodActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
       /* val tv = findViewById(R.id.sample_text) as TextView
        tv.text = stringFromJNI()*/
    }

    /**
     * Use semicolon at the end??
     */
    fun launchDefaultMethodActivity(v: View){
        val intent = Intent(this, DefaultMethodActivity::class.java)
        startActivity(intent);
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
