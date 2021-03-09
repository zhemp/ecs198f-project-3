package com.android.example.housingconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HousingListAdapter: RecyclerView.Adapter<ItemViewHolder>() {

    private var posts = emptyList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.housing_list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = posts[position]
        holder.apply {
            // TODO: PHASE 3.1 - Re-define these values based on the the post object being displayed
            housingType.text = item.type
            location.text = item.location
            price.text = item.price.toString()
            numOfBeds.text = item.bed.toString()
            numOfBaths.text = item.bath.toString()
            covidTested.text = item.covidTested
            // TODO: PHASE 3.1 Use Glide to show an image from the database
            Glide.with(holder.itemView).load("https://RentelServer.zhemp.repl.co" + item.image).into(housingImage)
            // Glide.with(holder.itemView)
            //    .load("YOUR_URL_HERE" + item.image)
            //    .into(housingImage)
        }

        holder.housingItem.setOnClickListener{
            // TODO: PHASE 3.1 navigate to HousingDisplayFragment and send the Post obect
            val ac = HousingFeedFragmentDirections.actionHousingFeedFragmentToHousingDisplayFragment(item)
            it.findNavController().navigate(ac)
        }
    }

    override fun getItemCount() = posts.size

    fun setData(newPosts: List<Post>) {
        posts = newPosts
        this.notifyDataSetChanged()
    }
}

class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val housingItem: ConstraintLayout = view.findViewById(R.id.housingItem)
    val housingImage: ImageView = view.findViewById(R.id.housingImage)
    val housingType: TextView = view.findViewById(R.id.housingType)
    val location: TextView = view.findViewById(R.id.address)
    val price: TextView = view.findViewById(R.id.price)
    val numOfBeds: TextView = view.findViewById(R.id.numOfBeds)
    val numOfBaths: TextView = view.findViewById(R.id.numOfBaths)
    val covidTested: TextView = view.findViewById(R.id.covidTested)
}