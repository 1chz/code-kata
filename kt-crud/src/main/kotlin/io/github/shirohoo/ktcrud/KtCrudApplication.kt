package io.github.shirohoo.ktcrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtCrudApplication

fun main(args: Array<String>) {
    runApplication<KtCrudApplication>(*args)
}
