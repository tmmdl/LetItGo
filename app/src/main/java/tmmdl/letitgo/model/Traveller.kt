package tmmdl.letitgo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Traveller {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("destination")
    @Expose
    var destination: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
    @SerializedName("contact")
    @Expose
    var contact: String? = null
    @SerializedName("comment")
    @Expose
    var comment: String? = null

    constructor(name: String, destination: String, date: String, contact: String, comment: String){
        this.name = name
        this.destination = destination
        this.date = date
        this.contact = contact
        this.comment = comment
    }
}