package com.promedia.querysql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.promedia.querysql.databinding.FragmentModificarFragmentBinding

class modificar_fragment : Fragment() {
    private var _b : FragmentModificarFragmentBinding? = null
    private val b get() = _b!!
    private lateinit var contactsDBHelper : mySQLiteHelper
    private val SaveContacts = arrayOf("")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b = FragmentModificarFragmentBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactsDBHelper = mySQLiteHelper(this.requireContext())

        b.btnModif.setOnClickListener {
            val dosPuntos = SaveContacts[0].indexOf(':')
            val id = SaveContacts[0].substring(0,dosPuntos)
            val affectedRows = contactsDBHelper.updateData(
                b.etIDMod.text.toString(),
            b.etNameMod.text.toString(),
            b.etSurMod.text.toString(),
            b.etPhoneMod.text.toString(),
            b.etEmailMod.text.toString())

            b.etNameMod.text.clear()
            b.etSurMod.text.clear()
            b.etPhoneMod.text.clear()
            b.etEmailMod.text.clear()


            if (affectedRows > 0) {
                Toast.makeText(this.context, "Has modificado $affectedRows registros", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.context, "No se han modificado registros", Toast.LENGTH_SHORT).show()
            }
        }

    }


}



