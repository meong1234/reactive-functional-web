package com.sample.extentions

import org.springframework.boot.SpringApplication
import kotlin.reflect.KClass

/**
 * [Documentation]
 *
 * @author andi pangeran
 */
fun run(type: KClass<*>, vararg args: String) = SpringApplication.run(type.java, *args)