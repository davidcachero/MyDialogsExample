package com.example.dialogsexample

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import com.example.dialogsexample.MiCustomDialog
import com.example.dialogsexample.R
import java.util.*

class MainActivity : AppCompatActivity() {
    var context: Context = this
    var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun toastLoad(view: View) {
        var miToast = Toast.makeText(this, "Mi primer Toast", Toast.LENGTH_LONG)
        miToast.show()
    }

    fun datePicker(view: View) {
        var miDatePickerListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                var mensaje = "La fecha es: " + dayOfMonth + "/" + (month + 1) + "/" + year
                var miToast = Toast.makeText(context, mensaje, Toast.LENGTH_LONG)
                //var miToast = Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG)
                miToast.show()
            }
        }

        var miDatePickerDialog = DatePickerDialog(
            this,
            miDatePickerListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DATE)
        )
        miDatePickerDialog.show()

    }

    fun timePicker(view: View) {
        //val miTimePickerListener= null
        var miTimePickerListener = object : TimePickerDialog.OnTimeSetListener {
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                var myHour = hourOfDay
                var myMinute = minute
                var mensaje = "La hora es: " + myHour + ":" + myMinute
                var miToast = Toast.makeText(context, mensaje, Toast.LENGTH_LONG)
                //var miToast = Toast.makeText(applicationContext, mensaje, Toast.LENGTH_LONG)
                miToast.show()
            }

        }
        var miTimePickerDialog = TimePickerDialog(
            this,
            miTimePickerListener,
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            true
        )
        miTimePickerDialog.show()

    }
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Seguro que quieres salir?")
        builder.setCancelable(false).setPositiveButton("Yes") { dialog, id -> this@MainActivity.finish()}
        builder.setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    fun AlertDialogLoad(view: View) {
        var miNeutralListener = DialogInterface.OnClickListener {dialogInterface : DialogInterface, i: Int -> Toast.makeText(applicationContext, "Es posible ", Toast.LENGTH_LONG).show()}
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert Dialog")
        builder.setMessage("Mensaje a mostrar")
        builder.setPositiveButton("Si"){dialog,_->Toast.makeText(applicationContext,"Si", Toast.LENGTH_LONG).show()}
        builder.setNegativeButton("No"){dialog, which-> Toast.makeText(applicationContext, "No", Toast.LENGTH_LONG).show()}
        builder.setNeutralButton("Puede", miNeutralListener)
        builder.show()


    }
    fun customDialogLoad(view: View){
        MiCustomDialog().show(supportFragmentManager, "MiCustomDialogTag")
    }


}
