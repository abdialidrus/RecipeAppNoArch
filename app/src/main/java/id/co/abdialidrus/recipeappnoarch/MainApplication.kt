package id.co.abdialidrus.recipeappnoarch

import android.app.Application
import com.google.gson.GsonBuilder
import id.co.abdialidrus.recipeappnoarch.api.RecipeAppApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainApplication: Application() {

    lateinit var recipeAppApi: RecipeAppApi
    lateinit var retrofitInstance: Retrofit

    override fun onCreate() {
        super.onCreate()

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(
            HttpLoggingInterceptor.Level.BODY
        )

        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor)
            .readTimeout(300, TimeUnit.SECONDS)
            .writeTimeout(300, TimeUnit.SECONDS)
            .connectTimeout(300, TimeUnit.SECONDS)
            .build()

        retrofitInstance = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .excludeFieldsWithoutExposeAnnotation().create()
                )
            )
            .client(client)
            .build();

        recipeAppApi = retrofitInstance.create(RecipeAppApi::class.java)
    }

}