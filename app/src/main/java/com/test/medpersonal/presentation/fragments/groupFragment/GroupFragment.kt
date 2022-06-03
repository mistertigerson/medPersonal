package com.test.medpersonal.presentation.fragments.groupFragment

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentGroupBinding
import com.test.medpersonal.domain.models.HomeModel
import com.test.medpersonal.domain.models.UserModel


class GroupFragment : Fragment(R.layout.fragment_group) {

    private val binding: FragmentGroupBinding by viewBinding()
    private lateinit var database: DatabaseReference
    private var list: ArrayList<UserModel> = arrayListOf()
    private val adapter: UserAdapter by lazy {
        UserAdapter()
    }
    private lateinit var auth: FirebaseAuth
    private lateinit var model: UserModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        setupUi()
        setUpListener()

    }

    private fun setData() {
        val db = FirebaseFirestore.getInstance()
        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    model = UserModel(
                        image = document.data["image"].toString(),
                        )
                    Log.d("TAG", "${document.id} => ${document.data["title"].toString()}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }

    private fun setupUi() {
        binding.rvUser.apply {
            adapter = this@GroupFragment.adapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun setUpListener() {
        adapter.onItemClick = {
            findNavController().navigate(R.id.chatFragment)
        }
    }


}