package com.sample

import com.sample.extentions.run
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
@SpringBootApplication
@EnableConfigurationProperties
class SampleApplication {
}

fun main(args: Array<String>) {
    run(SampleApplication::class, *args)
}