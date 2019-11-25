package tmmdl.letitgo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tmmdl.letitgo.R
import tmmdl.letitgo.model.Traveller
import tmmdl.letitgo.service.ServiceBuilder
import tmmdl.letitgo.service.ServiceUtils

class TravellersListActivity : AppCompatActivity() {

    lateinit var listsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travellers_list)

        val activityName = callingActivity!!.className

        //call from retrofit
        val createClient = ServiceBuilder.buildService(ServiceUtils::class.java)
        var callRequest = createClient.read(MainActivity.destination)

        if (activityName == DateActivity::class.java.name) {
            callRequest = createClient.read(MainActivity.date, MainActivity.destination)
        }

        callRequest.enqueue(object : Callback<ArrayList<Traveller>> {
            override fun onResponse(call: Call<ArrayList<Traveller>>, response: Response<ArrayList<Traveller>>) {

                if (response.isSuccessful) {

                    listsRecyclerView = findViewById(R.id.lists_recyclerview)
                    listsRecyclerView.layoutManager =
                        LinearLayoutManager(this@TravellersListActivity) as RecyclerView.LayoutManager?
                    listsRecyclerView.adapter = RecyclerViewAdapter(applicationContext, response.body()!!)
                    { traveller: Traveller -> travellerClicked(traveller) }

                    Toast.makeText(applicationContext, "read: " + response.message(), Toast.LENGTH_LONG).show()
                } else {

                    Toast.makeText(applicationContext, "failed: ${response.message()}", Toast.LENGTH_LONG)
                    Log.i("@tmmdl", response.message())
                }
            }

            override fun onFailure(call: Call<ArrayList<Traveller>>, t: Throwable) {

                Toast.makeText(applicationContext, "exception ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun travellerClicked(traveller: Traveller) {

        val comment = getString(R.string.cnt_cmt)
        val goesTo = getString(R.string.cnt_destination)

        Log.i("@tmmdl", comment)

        val dialogMessage = "${traveller.contact} \n${comment}: ${traveller.comment} \n${goesTo}: ${traveller.destination}"
        val builder = AlertDialog.Builder(this)
        builder.setMessage(dialogMessage)
        builder.create().show()
    }
}
