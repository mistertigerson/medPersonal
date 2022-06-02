package com.test.medpersonal.presentation.fragments.profileFragment

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentProfileBinding
import com.test.medpersonal.extensions.loadImage
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val binding: FragmentProfileBinding by viewBinding()
    private lateinit var auth: FirebaseAuth
    lateinit var bMap: Bitmap
    lateinit var icon : BitmapDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
//        lifecycleScope.launch {
//            bMap = Picasso.get().load(auth.currentUser?.photoUrl).get()
//            icon = BitmapDrawable(resources, bMap)
//
//        }

//        binding.ivAvatar.setImageDrawable(icon)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = FirebaseAuth.getInstance().currentUser
        binding.btnSignOut.setOnClickListener {
            auth.signOut()
            findNavController().navigate(R.id.authFragment)
        }
        binding.tvUsername.text = user?.displayName

        binding.btnAddData.setOnClickListener {
            findNavController().navigate(R.id.dataFragment)
        }

    }

    private suspend fun initUser() {

    }
}