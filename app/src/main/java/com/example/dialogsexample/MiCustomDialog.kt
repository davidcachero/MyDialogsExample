package com.example.dialogsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MiCustomDialog : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        var viewDialog = inflater.inflate(R.layout.mi_custom_dialog, container, false)


        var bottomLogin2 = viewDialog.findViewById<Button>(R.id.buttonLogin)
        bottomLogin2.setOnClickListener{view->login(view)}
        return viewDialog
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.75).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        //dialog!!.window?.setLayout(height, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    fun login(view: View){
        var et_user = dialog!!.findViewById<EditText>(R.id.et_username)
        var et_password = dialog!!.findViewById<EditText>(R.id.et_password)
        var user = et_user.text.toString()
        var pass = et_password.text.toString()

        var mensaje = user + " " + pass

        var miToast = Toast.makeText(this.activity, mensaje, Toast.LENGTH_LONG)
        miToast.show()
    }

}