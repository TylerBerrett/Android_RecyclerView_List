package com.example.imageviewer.recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.imageviewer.R
import com.example.imageviewer.activites.DetailsActivity
import com.example.imageviewer.model.ImageData
import kotlinx.android.synthetic.main.image_item_layout.view.*

class ImageListAdapter(val data: ArrayList<ImageData>) : RecyclerView.Adapter<ImageListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageURI(data[position].getUriPath())
        holder.uriPath.text = data[position].uriToString

        holder.all.setOnClickListener {
            val intent = Intent(it.context, DetailsActivity::class.java)
            intent.putExtra("key", data[position])
            startActivity(it.context, intent, null)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val img = itemView.uri_img
        val uriPath = itemView.uri_path
        val all = itemView.all_together
    }

}