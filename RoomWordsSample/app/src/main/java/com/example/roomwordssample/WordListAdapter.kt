package com.example.roomwordssample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.example.roomwordssample.vo.Word
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View


class WordListAdapter (context: Context): RecyclerView.Adapter<WordListAdapter.WordViewHolder>(){
    private var mInflater: LayoutInflater
    private var mWords: List<Word>? = null // Cached copy of words

    init {
        mInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWords != null) {
            val (word) = mWords!![position]
            holder.wordItemView.text = word
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.text = "No Word"
        }
    }

    fun setWords(words: List<Word>?) {
        mWords = words
        notifyDataSetChanged()
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    override fun getItemCount(): Int {
        return mWords?.size ?: 0
    }

    inner class WordViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView

        init {
            wordItemView = itemView.findViewById(R.id.textView)
        }
    }
}