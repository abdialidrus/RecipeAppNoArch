package id.co.abdialidrus.recipeappnoarch.api.response.recipe_list


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class GetRecipeListResponse(
    @SerializedName("count")
    @Expose
    val count: Int,
    @SerializedName("next")
    @Expose
    val next: String,
    @SerializedName("previous")
    @Expose
    val previous: String,
    @SerializedName("results")
    @Expose
    val results: List<Result>
)