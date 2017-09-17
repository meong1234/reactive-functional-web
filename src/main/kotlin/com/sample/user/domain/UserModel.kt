package com.sample.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@Document
data class UserModel(
    @Id val userId: String,

    val username: String,

    val password: String
)