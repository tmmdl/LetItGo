package tmmdl.letitgo.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import tmmdl.letitgo.model.Traveller

interface ServiceUtils {

    @POST("travellers")
    fun create(@Body traveller: Traveller): Call<Traveller> //do we need return value

    @GET("travellers")
    fun read(@Query("date")date: String, @Query("destination")destination: String): Call<ArrayList<Traveller>>

    @GET("travellers")
    fun read(@Query("destination")destination: String): Call<ArrayList<Traveller>>
}