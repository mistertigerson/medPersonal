package com.test.medpersonal.presentation.fragments.chatFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.medpersonal.databinding.UserListItemBinding
import com.test.medpersonal.diffutil.MessageDiffUtil
import com.test.medpersonal.domain.models.MessageModel

class ChatAdapter : ListAdapter<MessageModel, ChatAdapter.MessageViewHolder>(MessageDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            UserListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    inner class MessageViewHolder(private val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MessageModel) {
            binding.tvName.text = item.name
            binding.tvMessage.text = item.message
        }

    }
}