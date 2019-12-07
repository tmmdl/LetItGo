package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            Log.i("@tmmdl", "traveller activity - go to date")
            goToDate()

        }
        toSeekerButton = findViewById(R.id.trvl_seeker_btn)
        toSeekerButton.setOnClickListener{
            toList()
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

    private fun toList(){
        val toTravellersListIntent = Intent(this, TravellersListActivity::class.java)
        startActivityForResult(toTravellersListIntent, 1)
    }
}
