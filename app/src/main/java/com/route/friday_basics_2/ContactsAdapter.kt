package com.route.friday_basics_2

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.route.friday_basics_2.databinding.ItemContactBinding

class ContactsAdapter(
    val contacts: ArrayList<ContactDM>,
    val onClick: (index: Int, contact: ContactDM) -> Unit
) :
    Adapter<ContactsAdapter.ContactsViewHolder>() {

    override fun onCreateViewHolder(recyclerView: ViewGroup, viewType: Int): ContactsViewHolder {
//        val constrainLayout = LayoutInflater.from(recyclerView.context)
//            .inflate(R.layout.item_contact, recyclerView, false)
        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(recyclerView.context),
            recyclerView, false
        )
        val viewHolder = ContactsViewHolder(binding)
        Log.e("ContactsAdapter", "onCreateViewHolder")
        return viewHolder
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, index: Int) {
        Log.e("ContactsAdapter", "onBindViewHolder: position: ${index}")
        val contact = contacts[index]
        holder.binding.contactName.text = contact.name
        holder.binding.contactNumber.text = contact.number
        holder.binding.contactImage.setImageResource(contact.imageId)
        holder.itemView.setOnClickListener {
            onClick(index, contact)
        }
    }

    override fun getItemCount(): Int = contacts.size


    class ContactsViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)

//    interface OnContactClick {
//        fun onItemClick(index: Int,contactDM: ContactDM)
//    }
}