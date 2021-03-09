package com.android.example.housingconnect

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_form_location.*

class FormLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.2 - when a user clicks 'continue' navigate the user to the FormDetailsFragment
        //  and send the data the user has filled in so far. the recommended way is to send a Post object
        var temp_post = Post(0,"","",0,0,0,"","","","","","")

        continueBtn.setOnClickListener{
            val Location: String = location.editText?.text.toString() + " " + city.editText?.text.toString() + " " + state.editText?.text.toString()
            temp_post.location = Location
            val ac = FormLocationFragmentDirections.actionFormLocationFragmentToFormDetailsFragment(temp_post)
            it.findNavController().navigate(ac)
        }


    }
}