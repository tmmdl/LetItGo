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
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("mail")
    @Expose
    var mail: String? = null
    @SerializedName("comment")
    @Expose
    var comment: String? = null
    @SerializedName("seeker")
    @Expose
    var seeker: Boolean? = null

    constructor(name: String, destination: String, date: String, phone: String, comment: String, mail: String, seeker: Boolean){
        this.name = name
        this.destination = destination
        this.date = date
        this.phone = phone
        this.mail = mail
        this.comment = comment
        this.seeker = seeker
    }
}