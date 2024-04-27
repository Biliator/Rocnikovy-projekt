package com.example.hudebni_prehravac.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hudebni_prehravac.R
import java.util.ArrayList

class AlbumAdapter(private val context: Context, private val data: ArrayList<String>): RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {
    private var mListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ViewHolder(inflater.inflate(R.layout.album_item, parent, false), mListener!!)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(itemView: View, private val listener: OnItemClickListener): RecyclerView.ViewHolder(itemView) {
        private val layout: ConstraintLayout = itemView.findViewById(R.id.album_layout)
        private val txtTitle: TextView = itemView.findViewById(R.id.txt_album_name)

        fun bind(album: String) {
            txtTitle.text = album

            layout.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    listener.playAlbum(album)
            }
        }
    }

    interface OnItemClickListener {
        fun playAlbum(album: String)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }
}