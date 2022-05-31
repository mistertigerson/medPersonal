package com.test.medpersonal.presentation.fragments.chatFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.medpersonal.databinding.UserListItemBinding
import com.test.medpersonal.domain.models.User2

class UserAdapter : ListAdapter<User2, UserAdapter.ItemHolder>(ItemComparator()) {

    class ItemHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User2) = with(binding) {
            tvMessage.text = user.message
            tvName.text = user.name
        }

        companion object {
            fun create(parent: ViewGroup): ItemHolder {
                return ItemHolder(
                    UserListItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class ItemComparator(): DiffUtil.ItemCallback<User2>(){
        override fun areItemsTheSame(oldItem: User2, newItem: User2): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User2, newItem: User2): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(getItem(position))
    }
}