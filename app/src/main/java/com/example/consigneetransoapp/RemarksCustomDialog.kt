package com.example.consigneetransoapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class RemarksCustomDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //dialog?.window?.setBackgroundDrawableResource(R.drawable.round_c)
        return inflater.inflate(R.layout.remarks_dialog,container,false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels*0.85).toInt()
        val height = (resources.displayMetrics.heightPixels*0.45).toInt()
        dialog!!.window?.setLayout(width,ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}