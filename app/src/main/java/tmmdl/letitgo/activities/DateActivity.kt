package tmmdl.letitgo.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.annotation.RequiresApi
import tmmdl.letitgo.R

class DateActivity : AppCompatActivity() {

    private lateinit var showListButton: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        val activityName: String = callingActivity!!.className
        val calendarView = findViewById<CalendarView>(R.id.calendarView)
        calendarView.setOnDateChangeListener{view, year, month, dayOfMonth ->
            MainActivity.date = ""+ dayOfMonth + "/" + (month + 1) + "/" + year
            Toast.makeText(this, MainActivity.date, Toast.LENGTH_LONG).show()
        }

        showListButton = findViewById<Button>(R.id.ok_button)
        if (activityName == SenderActivity::class.java.name) {
            showListButton.setOnClickListener{
                Log.i("@tmmdl", "recyclerview")
                toTravellersList()
            }
        }
        if(activityName == MainActivity::class.java.name){
            showListButton.setOnClickListener {
                Log.i("@tmmdl", "if statement")
                setContacts()
            }
        }
    }
    private fun toTravellersList(){
        val toTravellersListIntent = Intent(this, TravellersListActivity::class.java)
        startActivityForResult(toTravellersListIntent, 1)
    }

    private fun setContacts(){
        val toContactIntent = Intent(this, ContactActivity::class.java)
        startActivity(toContactIntent)
    }
}
