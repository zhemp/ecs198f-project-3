package com.android.example.housingconnect

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_housing_feed.*
import retrofit2.*


class HousingFeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housing_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        // TODO: PHASE 3.1 - Connect adapter and layoutManager to the RecyclerView defined in xml
        val housingListAdapter = HousingListAdapter()
        val recyclerView = housing_feed_recyclerview
        recyclerView.adapter = housingListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



        // TODO: PHASE 3.1 - Add onClickListener to Post Button and navigate to signin page or
        //  the start of the form (FormLocationFragment)
        val post: View = post_button
        post.setOnClickListener {
            val ac = R.id.action_housingFeedFragment_to_formLocationFragment
            //val ac = R.id.action_housingFeedFragment_to_signInFragment
            it.findNavController().navigate(ac)
        }

        // TODO: PHASE 4 - Get an instance of the singleton housingService defined in the MainActivity

        val housingService = (requireActivity() as MainActivity).housingService

        // TODO: PHASE 4 - using the housingService to fetch all Housing Listing from the server
        //  make sure to update the recycler views adapter
        housingService.getAll().enqueue(object: retrofit2.Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: retrofit2.Response<List<Post>>){
                housingListAdapter.setData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("ListFrag", "On Failure")
            }
        })
    }
}
