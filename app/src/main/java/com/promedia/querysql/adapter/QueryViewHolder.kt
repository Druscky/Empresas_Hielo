package com.promedia.querysql.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.promedia.querysql.Contacts
import com.promedia.querysql.R
import com.promedia.querysql.databinding.ItemContactsBinding

class QueryViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val b = ItemContactsBinding.bind(view)
    fun render(contactsModel: Contacts) {
        b.cvID.text = contactsModel._id
        b.cvName.text = contactsModel.name
        b.cvSurname.text = contactsModel.surname
        b.cvPhone.text = contactsModel.phone
        b.cvEmail.text = contactsModel.email
    }
}
