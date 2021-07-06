package com.example.imageviewer.activites

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imageviewer.recycler.ImageListAdapter
import com.example.imageviewer.R
import com.example.imageviewer.model.ImageData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        public val IMG_CODE = 6
    }

    val list = ArrayList<ImageData>()
    val manager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

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
