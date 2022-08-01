package com.promedia.querysql

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.promedia.querysql.databinding.FragmentDeleteFragmentBinding

class delete_fragment : Fragment() {
    private var _b : FragmentDeleteFragmentBinding? = null
    private val b get() = _b!!
    private lateinit var contactsDBHelper : mySQLiteHelper
    private val DeleteContact = arrayOf("")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b = FragmentDeleteFragmentBinding.inflate(inflater, container, false)
        return b.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactsDBHelper = mySQLiteHelper(this.requireContext())

        //TODO
        GetSpinner(b.spinnerDel, DeleteContact,sqliteToArray())

        b.btnAceptarBorrar.setOnClickListener {
            val endIndex = DeleteContact[0].toString().indexOf(':')
            contactsDBHelper.deleteData(DeleteContact[0].toString().substring(0, endIndex))

            //TODO Lista

        }
    }

    fun sqliteToArray():Array<String> {
        val sqliteData = arrayListOf<String>()
        // Abro la base de datos en modo LECTURA
        val db : SQLiteDatabase = contactsDBHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM ${mySQLiteHelper.TABLE_NAME}", null)

        if (cursor.moveToFirst()) {
            do {
                sqliteData.add(
                    cursor.getInt(0).toString() + ": " +
                    cursor.getString(1) + " " +
                    cursor.getString(2))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return sqliteData.toTypedArray()
    }

}