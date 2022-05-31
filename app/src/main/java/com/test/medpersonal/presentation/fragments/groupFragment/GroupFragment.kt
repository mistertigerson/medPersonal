package com.test.medpersonal.presentation.fragments.groupFragment

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentGroupBinding
import com.test.medpersonal.domain.models.User


class GroupFragment : Fragment(R.layout.fragment_group) {

    private val binding: FragmentGroupBinding by viewBinding()
    private lateinit var database: DatabaseReference
    var users: ArrayList<User>? = null
    var usersAdapter: UserAdapter? = null
    var dialog: ProgressDialog? = null
    var user: User? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dialog = ProgressDialog(requireContext())
//        dialog!!.setMessage("load image")
//        dialog!!.setCancelable(false)
//        database = FirebaseDatabase.getInstance()
//        users = ArrayList<User>()
//        usersAdapter = UserAdapter(requireContext(), users!!)
//        val layoutManager = GridLayoutManager(requireContext(), 2)
//        binding.mRec.layoutManager = layoutManager
//        database!!.reference.child("users")
//            .child(FirebaseAuth.getInstance().uid!!)
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    user = snapshot.getValue(User::class.java)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                }
//
//            })
//        binding.mRec.adapter = usersAdapter
//        database!!.reference.child("users").addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                users!!.clear()
//                for (snapshot1 in snapshot.children) {
//                    val user: User? = snapshot1.getValue(User::class.java)
//                    if (!user!!.uid.equals(FirebaseAuth.getInstance().uid)) users!!.add(user)
//                }
//                usersAdapter!!.notifyDataSetChanged()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//            }
//
//        })



    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
//        val currentId = FirebaseAuth.getInstance().uid
//        database!!.reference.child("presence")
//            .child(currentId!!).setValue("Online")
    }



}