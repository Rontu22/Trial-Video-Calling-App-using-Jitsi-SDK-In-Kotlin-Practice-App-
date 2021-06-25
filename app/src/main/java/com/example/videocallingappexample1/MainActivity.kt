package com.example.videocallingappexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import org.jitsi.meet.sdk.JitsiMeetActivity
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        try {
            var options = JitsiMeetConferenceOptions.Builder()
                .setServerURL(URL(""))
                .setWelcomePageEnabled(false)
                .build()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }


    }

    fun onJoinButtonClick(view: View) {
        val editTextJoinMeeting = findViewById<EditText>(R.id.conferenceName)
        val roomName = editTextJoinMeeting.text.toString()

        if(roomName.length > 0)
        {
            val options = JitsiMeetConferenceOptions.Builder()
                .setRoom(roomName)
                .build()

            JitsiMeetActivity.launch(this,options)
        }
    }
}