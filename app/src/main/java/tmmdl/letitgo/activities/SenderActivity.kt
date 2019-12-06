package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import tmmdl.letitgo.R

class SenderActivity : AppCompatActivity() {

    private lateinit var toDateButton: Button
    private lateinit var showAllButton: Button
    private lateinit var addAdvertButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sender)

        toDateButton = findViewById<Button>(R.id.at_this_time)
        toDateButton.setOnClickListener{
            goToDate()
        }

        showAllButton = findViewById<Button>(R.id.show_all)
        showAllButton.setOnClickListener {
            Log.i("@tmmdl", "senderactivity - showAllbutton")
            toTravellersList()
            Log.i("@tmmdl", "senderactivity - showAllbutton, after intent")
        }

        addAdvertButton = findViewById(R.id.add_advert)
        addAdvertButton.setOnClickListener{
            goToAdvert()
        }

    }

    private fun goToDate(){

        val toDateIntent = Intent(this, DateActivity::class.java)
        //startActivityForResult is used when you want to start a new activity and
        // get some result back from that new activity. The result will be received
        // only after the new activity finished it’s activity. For example, the main
        // activity starts the second activity by using the method startActivtyForResult,
        // the second activity started then sends back the result to the main activity,
        // the main activity gets the result from the onActivityResult method.
        startActivityForResult(toDateIntent,1) //TODO requestCode?
    }

    private fun toTravellersList(){

        val toTravellersListIntent = Intent(this, TravellersListActivity::class.java)
        startActivityForResult(toTravellersListIntent, 1)
    }

    private fun goToAdvert(){
        val toAdvertIntent = Intent(this, ContactActivity::class.java)
        startActivityForResult(toAdvertIntent, 1)
    }
}
