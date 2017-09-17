package com.sample.user.domain

import org.springframework.data.mongodb.core.*
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@Repository
class UserRepository(private val template: ReactiveMongoTemplate) {

    fun count() = template.count<UserModel>()

    fun findAll() = template.findAll<UserModel>()

    fun findOne(userId: String) = template.findById<UserModel>(userId)

    fun findByUsername(username: String) = template.find<UserModel>(Query(where("username").isEqualTo(username)))

    fun save(user: UserModel) = template.save(user)

    fun save(user: Mono<UserModel>) = template.save(user)
}