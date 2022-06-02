package com.test.medpersonal.presentation.fragments.homeFragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentHomeBinding
import com.test.medpersonal.domain.models.HomeModel


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by viewBinding()
    private val homeAdapter: HomeAdapter by lazy {
        HomeAdapter()
    }
    private var list: ArrayList<HomeModel> = ArrayList()
    private lateinit var model : HomeModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchBar()
        setupUI()

    }

    private fun setupSearchBar() {
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                updateSearch()
            }

        })
    }

    private fun updateSearch() {
        val s = binding.searchBar.text

    }

    private fun setupUI() {
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("news").document("OtR5bvQUAPIAcgZg4xVc")
        docRef.get().addOnSuccessListener { documentSnapshot ->
            val city = documentSnapshot.toObject<HomeModel>()
            if (city != null) {
                list.add(city)
            }

        }
        homeAdapter.submitList(list)
        binding.recyclerSearch.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}