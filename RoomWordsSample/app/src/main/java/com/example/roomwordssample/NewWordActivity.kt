package com.example.roomwordssample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_new_word.*

class NewWordActivity : AppCompatActivity() {
    companion object {
        @JvmField val EXTRA_REPLY = "com.example.android.roomwordssample.REPLY";
    }

    private lateinit var mEditWordView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        mEditWordView = edit_word

        button_save.setOnClickListener{view ->
            var replyIntent = Intent()
            if(TextUtils.isEmpty(mEditWordView.text)){
                setResult(RESULT_CANCELED, replyIntent)
            }else{
                var word = mEditWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }

            finish()
        }
    }
}
