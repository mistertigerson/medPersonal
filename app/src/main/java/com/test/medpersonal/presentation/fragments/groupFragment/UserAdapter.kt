package com.test.medpersonal.presentation.fragments.groupFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.medpersonal.R
import com.test.medpersonal.databinding.ItemProfileBinding
import com.test.medpersonal.domain.models.User
import com.test.medpersonal.extensions.loadImage

class UserAdapter(var context: Context, var userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemProfileBinding = ItemProfileBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.tvUsername.text = user.name
        holder.binding.ivProfile.loadImage(user.profileImage.toString())
    }

    override fun getItemCount(): Int = userList.size
}