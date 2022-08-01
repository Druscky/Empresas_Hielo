package com.promedia.querysql.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.promedia.querysql.Contacts
import com.promedia.querysql.R

class QueryAdapter(private val queryList: List<Contacts>) : RecyclerView.Adapter<QueryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QueryViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return QueryViewHolder(layoutInflater.inflate(R.layout.item_contacts, parent, false))
    }

    override fun onBindViewHolder(holder: QueryViewHolder, position: Int) {
        val item = queryList[position]
        holder.render(item)
    }


    override fun getItemCount(): Int = queryList.size
}

