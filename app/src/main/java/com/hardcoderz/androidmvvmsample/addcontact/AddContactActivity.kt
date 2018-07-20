package com.hardcoderz.androidmvvmsample.addcontact

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.hardcoderz.androidmvvmsample.R
import com.hardcoderz.androidmvvmsample.models.Contact
import kotlinx.android.synthetic.main.activity_add_contact.*

class AddContactActivity : AppCompatActivity() {

    private lateinit var viewModel: AddContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        viewModel = ViewModelProviders.of(this).get(AddContactViewModel::class.java)
        subscribeUi()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.save, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null && item.itemId == R.id.action_save) {
            saveContact()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun saveContact() {
        val contact = Contact()
        contact.name = nameField.text.toString()
        contact.number = mobileNoField.text.toString()
        contact.email = emailField.text.toString()

        viewModel.addContact(contact)
    }

    private fun subscribeUi() {
        viewModel.isAdded.observe(this, Observer<Boolean> { isAdded ->
            if (isAdded != null && isAdded) finish()
        })
    }
}
