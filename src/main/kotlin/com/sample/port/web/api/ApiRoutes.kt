package com.sample.port.web.api

import com.sample.user.web.UserApiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@Configuration
class ApiRoutes(private val helloHandler: HelloHandler,
    private val userApiHandler: UserApiHandler) {

    @Bean
    fun apiRouter() = router {

        (accept(APPLICATION_JSON) and "/api").nest {
            //hello
            "/hello".nest {
                GET("/", helloHandler::helloWorld)
            }

            //users
            "/user".nest {
                GET("/", userApiHandler::findAll)
                POST("/", userApiHandler::create)
                GET("/{userid}", userApiHandler::findOne)
            }
        }
    }
}