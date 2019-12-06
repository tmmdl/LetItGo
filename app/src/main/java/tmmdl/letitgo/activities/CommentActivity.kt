package tmmdl.letitgo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tmmdl.letitgo.R
import tmmdl.letitgo.model.Traveller
import tmmdl.letitgo.service.ServiceBuilder
import tmmdl.letitgo.service.ServiceUtils
import java.util.*
import kotlin.concurrent.schedule

class CommentActivity : AppCompatActivity() {

    private lateinit var commentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        commentButton = findViewById<Button>(R.id.comment_button)
        commentButton.setOnClickListener {
            var commentField = findViewById<EditText>(R.id.comment_field)
            MainActivity.comment = commentField.text.toString()
            var traveller = Traveller(
                MainActivity.name,
                MainActivity.destination,
                MainActivity.date,
                MainActivity.contact,
                MainActivity.comment,
                MainActivity.mail,
                MainActivity.seeker
            )

            val createClient = ServiceBuilder.buildService(ServiceUtils::class.java)
            val callRequest = createClient.create(traveller)
            callRequest.enqueue(object : Callback<Traveller> {
                override fun onResponse(call: Call<Traveller>, response: Response<Traveller>) {
                    if (response.isSuccessful) {
                        Toast.makeText(applicationContext, "read: " + response.message(), Toast.LENGTH_LONG).show()
                        Log.i("@tmmdl", "if: ${response.isSuccessful}")
                    } else {
                        Log.i("@tmmdl", "else: ${response.isSuccessful}")
                    }
                }
                override fun onFailure(call: Call<Traveller>, t: Throwable) {
                    Toast.makeText(applicationContext, "exception", Toast.LENGTH_LONG).show()
                }
            })
            //showInfo() //TODO causes an exception. replace with popup window
            Timer().schedule(2000){
                toMain()
            }
        }
    }

    //TODO REDO
    private fun showInfo() {

        val dialogMessage = getString(R.string.message)
        val msg = MainActivity.name + " " + MainActivity.destination + " " + MainActivity.date + " " + MainActivity.contact
        val builder = AlertDialog.Builder(this)
        builder.setMessage(dialogMessage)
        builder.create().show()
        Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG )
    }

    private fun toMain(){

        val toMainIntent = Intent(this, MainActivity::class.java)
        toMainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(toMainIntent)
    }
}
