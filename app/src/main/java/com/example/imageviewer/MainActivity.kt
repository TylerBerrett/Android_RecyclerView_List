package com.example.imageviewer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.image_item_layout.*

class MainActivity : AppCompatActivity() {

    companion object{
        public val IMG_CODE = 6
    }

    val list = ArrayList<ImageData>()
    val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    /*fun createTextView(text: String?, index: Int): TextView {
        val displayText = TextView(this)
        displayText.text = text
        displayText.textSize = 32f
        displayText.textAlignment = View.TEXT_ALIGNMENT_CENTER
        displayText.setOnClickListener{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("key", list[index])
            startActivity(intent)
        }

        return displayText

    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            if(intent.resolveActivity(packageManager) != null){
                startActivityForResult(intent, IMG_CODE)
            }

        }

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = manager
        recycler_view.adapter = (ImageListAdapter(list))


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == IMG_CODE && resultCode == Activity.RESULT_OK){
            val image = data?.data
            list.add(ImageData(image))
            recycler_view.adapter?.notifyItemInserted(list.size - 1)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}
