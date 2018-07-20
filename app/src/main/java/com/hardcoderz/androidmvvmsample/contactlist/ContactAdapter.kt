package com.hardcoderz.androidmvvmsample.contactlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hardcoderz.androidmvvmsample.databinding.ItemContactBinding
import com.hardcoderz.androidmvvmsample.models.Contact

class ContactAdapter(private val contactList: MutableList<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = contactList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    fun updateData(data: List<Contact>) {
        contactList.clear()
        contactList.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemContactBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.contact = contact
            binding.executePendingBindings()
        }
    }
}