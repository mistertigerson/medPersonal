package com.test.medpersonal.presentation.fragments.chatFragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentChatBinding
import com.test.medpersonal.domain.models.HomeModel
import com.test.medpersonal.domain.models.User2
import com.test.medpersonal.presentation.fragments.registrationFragment.RegistrationFragment.Companion.NAME


class ChatFragment : Fragment(R.layout.fragment_chat) {

    private val binding: FragmentChatBinding by viewBinding()
    private lateinit var adapter: UserAdapter
    lateinit var auth: FirebaseAuth
    lateinit var model : User2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<User2>()
        val dataB = FirebaseFirestore.getInstance()
        dataB.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    dataB.collection("message").document()
                    list.add(document.data)
                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
        binding.btnSend.setOnClickListener {
            addData()
            initRv()
            binding.etText.text.clear()
        }
    }

    private fun addData() {
        model = User2("",
            binding.etText.text.toString()
        )
        val db = FirebaseFirestore.getInstance()
        db.collection("message")
            .add(model)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
//                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "failure", Toast.LENGTH_SHORT).show()
                }
            }
//
//        val user = FirebaseAuth.getInstance().currentUser
//        val database = Firebase.database
//        val myRef = database.getReference("message")
//
//        onChangeListener(myRef)
    }


    private fun onChangeListener(dRef: DatabaseReference) {

        dRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = ArrayList<User2>()

                for (s in snapshot.children) {
                    val user = s.getValue(User2::class.java)
                    if (user != null) {
                        list.add(user)
                    }
                }
                adapter.submitList(list)
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

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

    private fun initRv() = with(binding) {
        adapter = UserAdapter()
        rvMessage.layoutManager = LinearLayoutManager(requireContext())
        rvMessage.adapter = adapter
    }

}