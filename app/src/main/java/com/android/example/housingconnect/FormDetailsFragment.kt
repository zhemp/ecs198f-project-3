package com.android.example.housingconnect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_form_details.*

class FormDetailsFragment : Fragment() {

    val args: FormDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PHASE 3.2 - when a user clicks 'continue' navigate the user to the FormDescriptionFragment
        //  and send the data the user has filled in so far. the recommended way is to send a Post object
        val in_post = args.postin

        continueBtn.setOnClickListener {
            in_post.type = housingType.editText?.text.toString()
            in_post.bed = bedrooms.editText?.text.toString().toInt()
            in_post.bath = bathrooms.editText?.text.toString().toInt()
            in_post.price = rent.editText?.text.toString().toInt()
            in_post.moveIn = movein.editText?.text.toString()
            val ac = FormDetailsFragmentDirections.actionFormDetailsFragmentToFormDescriptionFragment(in_post)
            it.findNavController().navigate(ac)
        }
    }
}