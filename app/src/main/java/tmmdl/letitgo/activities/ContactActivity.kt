package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import tmmdl.letitgo.R

class ContactActivity : AppCompatActivity() {

    private lateinit var contactButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        val activityName = callingActivity!!.className

        if (activityName == SenderActivity::class.java.name){
            MainActivity.seeker = true
        }

        contactButton = findViewById(R.id.contact_button)
        contactButton.setOnClickListener {
            var contactName = findViewById<EditText>(R.id.contact_name_field)
            var contactPhone = findViewById<EditText>(R.id.contact_phone_field)
            var contactMail = findViewById<EditText>(R.id.contact_mail_field)
            MainActivity.name = contactName.text.toString()
            MainActivity.contact = "${getString(R.string.cnt_phone_field)}: ${contactPhone.text} \n${getString(R.string.cnt_mail_field)}: ${contactMail.text}"
            Log.i("@tmmdl", MainActivity.contact)

            toComment()
        }
    }

    private fun toComment(){

        val toCommentIntent = Intent(this, CommentActivity::class.java)
        startActivity(toCommentIntent)
    }
}
