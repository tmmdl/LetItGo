package tmmdl.letitgo.activities

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tmmdl.letitgo.model.Traveller
import tmmdl.letitgo.R

class RecyclerViewAdapter(var applicationContext: Context, var list: ArrayList<Traveller>,
                          val clickListener: (Traveller) -> Unit): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.i("@tmmdl", "RecyclerViewAdapter, oncreateviewholder")
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    //TODO add if statement             val l = LocalDate.parse(MainActivity.date, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    //            Log.i("@tmmdl", "formated date ${l.toString()}")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        if(holder != null){
            holder.name.text = list[position].name
            holder.date.text = list[position].date


            /* holder.date.setOnClickListener {
                 Toast.makeText(applicationContext, holder.name.text, Toast.LENGTH_LONG).show()
             }*/

            holder.bind(list[position], clickListener)

            /*Log.i("@tmmdl", "after testviewholder - adapterview")*/
        }
    }
}