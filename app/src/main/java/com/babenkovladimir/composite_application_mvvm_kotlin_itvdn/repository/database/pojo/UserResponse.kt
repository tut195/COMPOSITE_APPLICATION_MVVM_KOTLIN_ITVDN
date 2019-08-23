package com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.pojo

import com.babenkovladimir.composite_application_mvvm_kotlin_itvdn.repository.database.entity.UserEntity
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("records")
    var records: List<UserEntity>? = null
}