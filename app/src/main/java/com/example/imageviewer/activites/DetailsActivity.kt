package com.example.imageviewer.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imageviewer.R
import com.example.imageviewer.model.ImageData
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val location = intent.getSerializableExtra("key") as ImageData
        val imgUri = location.getUriPath()
        text_main.setText("Uri: ${location.uriToString}")
        img_main.setImageURI(imgUri)


    }
}
