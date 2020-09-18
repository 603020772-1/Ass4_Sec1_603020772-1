package com.myweb.asslab4ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radio_button_click: RadioButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.txt_show)
        radioGroup = findViewById(R.id.radioGroup)
        radio_button_click = findViewById(R.id.male)
        radio_button_click = findViewById(R.id.female)



        radio_button_click.setOnClickListener{
            var value = radioGroup.checkedRadioButtonId
            var radio_button_click = findViewById<RadioButton>(value)
            //textView.text = rb.text


        }
    }

    fun showBDPickerDialog(v: View) {
        val newDateFragment = showBDPickerDialog()
        newDateFragment.show(supportFragmentManager, "Date Picker")
    }

    fun showInformation(view: View) {
        txt_show.text = "Name: ${edt_name.text}\nPassword: ${edt_password.text}\nGender: ${radio_button_click.text}\nE-mail: ${edt_email.text}\nBirthday: ${txt_bd.text}"
    }

    fun resetInformation(v: View) {
        edt_name.text.clear()
        edt_password.text.clear()
        radioGroup.clearCheck()
        edt_email.text.clear()
        txt_bd.text ="mm/dd/yy"
        txt_show.text ="Show Information"
    }
}