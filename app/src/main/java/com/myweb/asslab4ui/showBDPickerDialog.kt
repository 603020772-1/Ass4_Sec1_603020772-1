package com.myweb.asslab4ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.text.DateFormat
import java.util.*

class showBDPickerDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {

    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar = Calendar.getInstance()

        var year = calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.WEEK_OF_MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            activity!!,
            2,
        this,
            year,
            month,
            day
        )
    }

    override fun onDateSet(p0: DatePicker, year: Int, month: Int, day: Int) {
        var tv : TextView? = activity?.findViewById(R.id.txt_bd)
        tv!!.text = formatDate(year,month,day)
    }

    override fun onCancel(dialog: DialogInterface) {
        Toast.makeText(activity, "Please select Birthday.", Toast.LENGTH_LONG).show()
        super.onCancel(dialog)
    }

    private fun formatDate(year: Int, month: Int, day: Int):String {
        var calendar:Calendar = Calendar.getInstance();
        calendar.set(year, month, day)
        var chsenDate = calendar.time
        var df = DateFormat.getDateInstance(DateFormat.MEDIUM)

        return df.format(chsenDate)
    }
}