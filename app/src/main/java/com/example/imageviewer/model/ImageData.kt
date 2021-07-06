package com.example.imageviewer.model

import android.net.Uri
import java.io.Serializable

class ImageData(uriPhoto: Uri?): Serializable {
    var uriToString: String? = uriPhoto.toString()


    fun getUriPath(): Uri {
        return Uri.parse(uriToString)
    }


}