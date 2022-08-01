package com.promedia.querysql

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.promedia.querysql.databinding.FragmentInsertFragmentBinding

class insertFragnment : Fragment() {
    private var _b: FragmentInsertFragmentBinding? = null
    private val b get() = _b!!
    private lateinit var contactsDBHelper : mySQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _b = FragmentInsertFragmentBinding.inflate(inflater, container, false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contactsDBHelper = mySQLiteHelper(this.requireContext())


        b.btnGuardar.setOnClickListener {
            if (b.etName.text.isNotBlank() &&
                b.etSurname.text.isNotBlank() &&
                b.etPhone.text.isNotBlank() &&
                b.etMail.text.isNotBlank()){

                contactsDBHelper.addData(
                    b.etName.text.toString(),
                    b.etSurname.text.toString(),
                    b.etPhone.text.toString(),
                    b.etMail.text.toString())
                b.etName.text.clear()
                b.etSurname.text.clear()
                b.etPhone.text.clear()
                b.etMail.text.clear()

                Toast.makeText(context, "¡Guardado!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(context, "No se ha podido guardar", Toast.LENGTH_SHORT).show()
            }
        }
    }
//    fun hideKeyBoard() {
//        val imm = getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
//        imm.hideSoftInputFromWindow(b.CLInsert.windowToken, 0)
//    }
}

