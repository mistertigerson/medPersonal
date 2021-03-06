package com.test.medpersonal.presentation.fragments.chatFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentChatBinding
import com.test.medpersonal.domain.models.UserModel


class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val binding: FragmentChatBinding by viewBinding()
    private val adapter : ChatAdapter by lazy {
        ChatAdapter()
    }
    private var list : ArrayList<UserModel> = arrayListOf()
    lateinit var auth: FirebaseAuth
    lateinit var model : UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initRv()
//        val user = FirebaseAuth.getInstance().currentUser
//        Log.e("TAG", "onViewCreated: ${user?.uid}" )
//
//        val database = Firebase.database
//        val myRef = database.getReference("message")
//        binding.btnSend.setOnClickListener {
//            myRef.child(myRef.push().key ?: "nullable")
//                .setValue(UserModel( binding.etText.text.toString()))
//            Log.e("TAG", "onViewCreated: ${user?.displayName.toString()}")
//            binding.etText.text.clear()
//        }
//        onChangeListener(myRef)
    }
//
//    private fun onChangeListener(dRef: DatabaseReference) {
//        dRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                for (s in snapshot.children) {
//                    val user = s.getValue(UserModel::class.java)
//                    if (user != null) {
//                        list.add(user)
//                    }
//                }
//                adapter.submitList(list)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//            }
//
//        })
//    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity(),
                OnCompleteListener<AuthResult?> { task ->
                    if (!task.isSuccessful) {
                        Toast.makeText(
                            requireContext(), "Authentication failed.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        acct.displayName.toString()
                        println(acct.photoUrl)
                    }
                })
    }

    private fun initRv(){
        binding.rvMessage.apply {
            adapter = this@ChatFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}