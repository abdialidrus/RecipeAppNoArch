package id.co.abdialidrus.recipeappnoarch.api

import id.co.abdialidrus.recipeappnoarch.api.response.recipe_list.GetRecipeListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RecipeAppApi {

    @GET("api/recipe/search")
    fun getRecipeList(
        @Header("Authorization") authToken: String,
        @Query("page") page: Int,
        @Query("query") query: String
    ): Call<GetRecipeListResponse>

}