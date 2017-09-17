package com.sample.user.web

import com.sample.user.domain.UserRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import java.net.URI

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@Component
class UserApiHandler(private val userRepository: UserRepository) {

    fun findAll(req: ServerRequest) = ok().body(fromObject(userRepository.findAll()))

    fun findOne(req: ServerRequest) = ok().body(fromObject(userRepository.findOne(req.pathVariable("userid"))))

    fun findByUsername(req: ServerRequest) = ok().body(fromObject(userRepository.findByUsername(req.pathVariable("username"))))

    fun create(req: ServerRequest): Mono<ServerResponse> {

        return userRepository
            .save(req.bodyToMono())
            .flatMap {
                created(URI.create("/api/user/${it.userId}"))
                    .body(it.toMono())
            }
    }
}