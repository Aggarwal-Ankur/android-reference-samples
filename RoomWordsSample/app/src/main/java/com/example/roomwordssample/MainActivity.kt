package com.example.roomwordssample

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.example.roomwordssample.viewmodel.WordViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import com.example.roomwordssample.vo.Word
import android.widget.Toast
import android.content.Intent

class MainActivity : AppCompatActivity() {

    val NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    lateinit var mWordViewModel : WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var adapter = WordListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        mWordViewModel.getAllWords().observe(this, Observer<List<Word>> { words -> adapter.setWords(words) })

        fab.setOnClickListener { view ->
            intent = Intent (this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY))
            mWordViewModel.insert(word)
        } else {
            Toast.makeText(
                    applicationContext,
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show()
        }
    }
}
