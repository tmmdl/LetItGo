package tmmdl.letitgo.service

import android.util.Base64
import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    private val AUTH = "Basic " + Base64.encodeToString("root:admin1234".toByteArray(), Base64.NO_WRAP) //TODO learn it
    private const val BASE_URL = "http://10.0.2.2:8080" //defined in web service as 8080

    //create logger
    val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //create okhttp builder
    //TODO changeit
    private val okHttpBuilder = OkHttpClient.Builder().addInterceptor(logger)
        .addInterceptor{chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", AUTH)
                .build()
            chain.proceed(newRequest)
        }

    //create retrofit builder
    private val retrofitBuilder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpBuilder.build())


    //create retrofit instance
    private val retrofit = retrofitBuilder.build()

    //parameter of this function is the class that implements the UserService interface
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
        Log.i("@tmmdl-retrofit", "connected")
    }
}