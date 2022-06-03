package com.test.medpersonal.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.test.medpersonal.domain.models.UserModel

class UserDiffUtil : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel) = oldItem == newItem

}