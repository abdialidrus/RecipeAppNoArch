package id.co.abdialidrus.recipeappnoarch.api.response.recipe_list


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Result(
    @SerializedName("pk")
    @Expose
    val pk: Int,
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("publisher")
    @Expose
    val publisher: String,
    @SerializedName("featured_image")
    @Expose
    val featuredImage: String,
    @SerializedName("rating")
    @Expose
    val rating: Int,
    @SerializedName("source_url")
    @Expose
    val sourceUrl: String,
    @SerializedName("description")
    @Expose
    val description: String,
    @SerializedName("cooking_instructions")
    @Expose
    val cookingInstructions: Any,
    @SerializedName("ingredients")
    @Expose
    val ingredients: List<String>,
    @SerializedName("date_added")
    @Expose
    val dateAdded: String,
    @SerializedName("date_updated")
    @Expose
    val dateUpdated: String,
    @SerializedName("long_date_added")
    @Expose
    val longDateAdded: Int,
    @SerializedName("long_date_updated")
    @Expose
    val longDateUpdated: Int
)