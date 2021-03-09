package com.android.example.housingconnect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_housing_display.*


class HousingDisplayFragment : Fragment() {

    val args:HousingDisplayFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_housing_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post = args.postToDisplay

        // TODO: PHASE 3.3 - Use Glide to display the image stored in the Post
        Glide.with(requireContext()).load("https://RentelServer.zhemp.repl.co" + post.image).into(view_image)

        // TODO: PHASE 3.3 - Dynamically update information showing in the xml using the Post object data fields

        loca.text = post.location
        price.text = post.price.toString()
        type.text = post.type
        beds.text = post.bed.toString()
        bath.text = post.bath.toString()
        movein.text = post.moveIn
        covid.text = post.covidTested
        desc.text = post.desc

        // TODO: PHASE 3.3 - Create an onclick listener on a button to send an email.
        //  this stage will require sending an implicit intent to an email application.
        //  recall that you can find common intents on the android documentation

        val mail: String = "mailto: " + post.email
        email_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse(mail)
            intent.putExtra(Intent.EXTRA_EMAIL, "test")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello")
            startActivity(intent)
        }

    }
}