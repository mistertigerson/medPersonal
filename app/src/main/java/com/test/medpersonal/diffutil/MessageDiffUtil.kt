package com.test.medpersonal.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.test.medpersonal.domain.models.HomeModel
import com.test.medpersonal.domain.models.MessageModel

class MessageDiffUtil: DiffUtil.ItemCallback<MessageModel>() {
    override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel) =
        oldItem.name == newItem.name


    override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel) =
        oldItem == newItem
}