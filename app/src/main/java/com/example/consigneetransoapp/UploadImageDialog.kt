package com.example.consigneetransoapp

import android.R.attr.data
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment


class UploadImageDialog : DialogFragment() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var uploadButton:Button
    private lateinit var submitButton:Button
    private lateinit var imageView:ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //dialog?.window?.setBackgroundDrawableResource(R.drawable.round_c)


//        uploadButton.setOnClickListener {
//            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            resultLauncher.launch(cameraIntent)
//        }


        return inflater.inflate(R.layout.upload_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uploadButton =  view.findViewById(R.id.uploadButton)
        imageView =  view.findViewById(R.id.image_view)
        submitButton =  view.findViewById(R.id.uploadImageSubmit)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val bitmap = result.data?.extras?.get("data")
                    imageView.isVisible = true
                    imageView.setImageBitmap(bitmap as Bitmap?)

                }
            }
        uploadButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            resultLauncher.launch(cameraIntent)
        }
        submitButton.setOnClickListener {
            dialog?.cancel()
        }
    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.45).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}