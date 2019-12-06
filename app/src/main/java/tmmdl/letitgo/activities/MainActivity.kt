package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import tmmdl.letitgo.R

class MainActivity : AppCompatActivity() {

    private lateinit var senderButton: Button
    private lateinit var travellerButton: Button
    private lateinit var toAzeButton: Button
    private lateinit var toGerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toGerButton = findViewById<Button>(R.id.main_to_ger)
        toGerButton.visibility = View.GONE
        toGerButton.isClickable = false

        toAzeButton = findViewById<Button>(R.id.main_to_aze)
        toAzeButton.visibility = View.GONE
        toAzeButton.isClickable = false

        senderButton = findViewById<Button>(R.id.to_sender)
        senderButton.setOnClickListener{
            senderButton.isClickable = false
            senderButton.visibility = View.GONE
            travellerButton.isClickable = false
            travellerButton.visibility = View.GONE
            toAzeButton.visibility = View.VISIBLE
            toAzeButton.isClickable = true
            toGerButton.visibility = View.VISIBLE
            toAzeButton.setOnClickListener {
                destination = getString(R.string.main_to_aze_btn)
                Log.i("@tmmdl", destination)
                goToSender()
            }
            toGerButton.setOnClickListener {
                destination = getString(R.string.main_to_ger_btn)
                goToSender()
            }
        }
        travellerButton = findViewById<Button>(R.id.to_traveller)
        travellerButton.setOnClickListener{
            travellerButton.isClickable = false
            travellerButton.visibility = View.GONE
            senderButton.isClickable = false
            senderButton.visibility = View.GONE
            toAzeButton.visibility = View.VISIBLE
            toAzeButton.isClickable = true
            toGerButton.visibility = View.VISIBLE
            toGerButton.isClickable = true
            toAzeButton.setOnClickListener {
                destination = getString(R.string.main_to_aze_btn)
                goToTraveller()
            }
            toGerButton.setOnClickListener {
                destination = getString(R.string.main_to_ger_btn)
                goToTraveller()
            }
        }
    }

    private fun goToSender(){

        val toSenderIntent = Intent(this, SenderActivity::class.java)
        startActivity(toSenderIntent)
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

    private fun goToTraveller(){
        val toTravellerIntent = Intent(this, TravellerActivity::class.java)
        startActivity(toTravellerIntent)
    }

    companion object{
        var name: String = ""
        var date: String = ""
        var destination: String = ""
        var comment: String = ""
        var contact: String = ""
        var mail: String = ""
        var seeker: Boolean = false
    }

}
