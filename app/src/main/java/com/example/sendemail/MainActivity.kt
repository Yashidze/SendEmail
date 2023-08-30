package com.example.sendemail

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity: Activity() {

    private lateinit var recipient: EditText
    private lateinit var message: EditText
    private lateinit var letterSubject: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)

        recipient = findViewById(R.id.recipient)
        message = findViewById(R.id.message)
        letterSubject = findViewById(R.id.letterSubject)
        sendButton = findViewById(R.id.sendButton)

          sendButton.setOnClickListener {
              val recipient = recipient.text.toString()
              val message = message.text.toString()
              val letterSubject = letterSubject.text.toString()

              val intent = Intent(Intent.ACTION_SENDTO).apply {
                  data = Uri.parse("mailto:")
                  putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
                  putExtra(Intent.EXTRA_SUBJECT, letterSubject)
                  putExtra(Intent.EXTRA_TEXT, message)
              }
              startActivity(intent)
          }
    }
}