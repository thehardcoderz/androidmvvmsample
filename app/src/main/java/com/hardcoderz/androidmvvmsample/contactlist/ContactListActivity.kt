package com.hardcoderz.androidmvvmsample.contactlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.hardcoderz.androidmvvmsample.R
import com.hardcoderz.androidmvvmsample.addcontact.AddContactActivity
import com.hardcoderz.androidmvvmsample.models.Contact
import kotlinx.android.synthetic.main.activity_contact_list.*

class ContactListActivity : AppCompatActivity() {

    private lateinit var viewModel: ContactListViewModel
    private lateinit var contactAdapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)
        viewModel = ViewModelProviders.of(this).get(ContactListViewModel::class.java)
        setupList()
        subscribeUi()
    }

    private fun setupList() {
        contactAdapter = ContactAdapter(mutableListOf())
        contactList.layoutManager = LinearLayoutManager(this)
        contactList.adapter = contactAdapter
    }

    private fun subscribeUi() {
        viewModel.getContactList().observe(this, Observer<List<Contact>> { contacts ->
            if (contacts != null) {
                emptyDataLabel.visibility = if (contacts.isEmpty()) View.VISIBLE else View.GONE
                contactAdapter.updateData(contacts)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null && item.itemId == R.id.action_add) {
            startActivity(Intent(this, AddContactActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
