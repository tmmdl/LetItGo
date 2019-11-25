package tmmdl.letitgo.activities

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tmmdl.letitgo.model.Traveller
import tmmdl.letitgo.R

class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val name = itemView?.findViewById<TextView>(R.id.view_name)
    val date = itemView?.findViewById<TextView>(R.id.view_date)

    fun bind(traveller: Traveller, clickListener: (Traveller) -> Unit){

        name.text = traveller.name
        date.text = traveller.date
        itemView.setOnClickListener {
            clickListener(traveller)
        }
    }
}