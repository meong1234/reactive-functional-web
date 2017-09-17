package com.sample.port.web.api

import org.springframework.stereotype.Controller
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@Controller
class HelloHandler() {

    fun helloWorld(req: ServerRequest) = ok().body(BodyInserters.fromObject("Hello World"))
}