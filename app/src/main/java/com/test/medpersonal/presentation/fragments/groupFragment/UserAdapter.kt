package com.test.medpersonal.presentation.fragments.groupFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.medpersonal.databinding.ItemProfileBinding
import com.test.medpersonal.diffutil.UserDiffUtil
import com.test.medpersonal.domain.models.UserModel
import com.test.medpersonal.extensions.loadImage

class UserAdapter : ListAdapter<UserModel, UserAdapter.UserViewHolder>(UserDiffUtil()) {

    var onItemClick: ((UserModel) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemProfileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class UserViewHolder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: UserModel?) {
            binding.ivProfile.loadImage(model?.image.toString())
            binding.tvUsername.text = model?.name

            binding.root.setOnClickListener{
                onItemClick?.invoke(getItem(absoluteAdapterPosition))
            }
        }
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

}