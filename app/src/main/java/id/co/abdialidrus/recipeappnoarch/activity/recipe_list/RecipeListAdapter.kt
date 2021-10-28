package id.co.abdialidrus.recipeappnoarch.activity.recipe_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.co.abdialidrus.recipeappnoarch.R
import id.co.abdialidrus.recipeappnoarch.api.response.recipe_list.Result

class RecipeListAdapter(
    val recipes: List<Result>
): RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder>() {

    class RecipeListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivRecipe = itemView.findViewById<ImageView>(R.id.iv_recipe)
        val tvRecipeName = itemView.findViewById<TextView>(R.id.tv_recipe_name)
        val tvRecipeRate = itemView.findViewById<TextView>(R.id.tv_recipe_rate)

        fun setData(data: Result){
            Glide.with(itemView).load(data.featuredImage).into(ivRecipe)
            tvRecipeName.text = data.title
            tvRecipeRate.text = "${data.rating}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        val layoutView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_recipe, parent, false)
        return RecipeListViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        holder.setData(recipes[position])
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}