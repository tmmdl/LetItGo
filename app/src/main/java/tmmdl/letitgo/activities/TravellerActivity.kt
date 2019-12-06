package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import tmmdl.letitgo.R

class TravellerActivity : AppCompatActivity() {

    private lateinit var toContactButton: Button
    private lateinit var toSeekerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traveller)

        toContactButton = findViewById(R.id.trvl_cnt_btn)
        toContactButton.setOnClickListener{
            toContact()
        }
        toSeekerButton = findViewById(R.id.trvl_seeker_btn)
        toSeekerButton.setOnClickListener{
            toList()
        }
    }

    private fun toContact(){
        val toContactIntent = Intent(this, ContactActivity::class.java)
        startActivityForResult(toContactIntent, 1)

    }

    private fun toList(){
        val toTravellersListIntent = Intent(this, TravellersListActivity::class.java)
        startActivityForResult(toTravellersListIntent, 1)
    }
}
