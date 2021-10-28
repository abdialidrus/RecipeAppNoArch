package id.co.abdialidrus.recipeappnoarch.activity.recipe_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.co.abdialidrus.recipeappnoarch.Constants
import id.co.abdialidrus.recipeappnoarch.MainApplication
import id.co.abdialidrus.recipeappnoarch.R
import id.co.abdialidrus.recipeappnoarch.api.response.recipe_list.GetRecipeListResponse
import id.co.abdialidrus.recipeappnoarch.api.response.recipe_list.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var recipeList: MutableList<Result> = mutableListOf()
    lateinit var adapter: RecipeListAdapter
    lateinit var pbLoading: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pbLoading = findViewById(R.id.pb_loading)

        setupRecyclerView()
        getRecipeList()
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_recipes)
        adapter = RecipeListAdapter(recipeList)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun getRecipeList() {
        pbLoading.visibility = View.VISIBLE
        val app: MainApplication = application as MainApplication
        val recipeAppApi = app.recipeAppApi
        val apiCall = recipeAppApi.getRecipeList(
            Constants.AUTH_TOKEN,
            1,
            ""
        )
        apiCall.enqueue(object : Callback<GetRecipeListResponse> {
            override fun onResponse(
                call: Call<GetRecipeListResponse>,
                response: Response<GetRecipeListResponse>
            ) {
                pbLoading.visibility = View.GONE
                recipeList.clear()
                recipeList.addAll(response.body()!!.results)
                adapter.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<GetRecipeListResponse>, t: Throwable) {
                pbLoading.visibility = View.GONE
            }

        })
    }
}