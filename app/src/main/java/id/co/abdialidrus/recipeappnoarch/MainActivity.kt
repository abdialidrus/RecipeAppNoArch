package id.co.abdialidrus.recipeappnoarch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.abdialidrus.recipeappnoarch.api.response.recipe_list.GetRecipeListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRecipeList()
    }

    private fun getRecipeList(){
        val app: MainApplication = application as MainApplication
        val recipeAppApi = app.recipeAppApi
        val apiCall = recipeAppApi.getRecipeList(
            Constants.AUTH_TOKEN,
            1,
            ""
        )
        apiCall.enqueue(object : Callback<GetRecipeListResponse>{
            override fun onResponse(
                call: Call<GetRecipeListResponse>,
                response: Response<GetRecipeListResponse>
            ) {

            }

            override fun onFailure(call: Call<GetRecipeListResponse>, t: Throwable) {

            }

        })
    }
}