package com.test.medpersonal.presentation.fragments.dataFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.test.medpersonal.R
import com.test.medpersonal.databinding.FragmentDataBinding
import com.test.medpersonal.domain.models.HomeModel


class DataFragment : Fragment(R.layout.fragment_data) {
    private val binding: FragmentDataBinding by viewBinding()
    private lateinit var model: HomeModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveData.setOnClickListener {
            addData()
        }
    }

    private fun addData() {
        model = HomeModel(
            binding.etAddImage.text.toString(),
            binding.etAddTittle.text.toString(),
            binding.etAddText.text.toString()
        )
        val db = FirebaseFirestore.getInstance()
        db.collection("news")
            .add(model)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    findNavController().navigateUp()
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "failure", Toast.LENGTH_SHORT).show()
                }
            }
    }

}