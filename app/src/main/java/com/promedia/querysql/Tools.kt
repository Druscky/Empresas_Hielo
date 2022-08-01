package com.promedia.querysql

import android.app.Activity
import android.widget.Toast

    const val DATABASE = "AddressBook.db"

    fun Activity.toast(text:String, length:Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, text, length).show()
    }

    fun Contacts() = mutableListOf<String>()