package io.github.shirohoo.ghostleg.domain

enum class Direction {
    WEST, EAST, SOUTH;

    val isWest get() = this == WEST
    val isEast get() = this == EAST
    val isSouth get() = this == SOUTH

    fun next(function: () -> Boolean): Direction = if (isEast) WEST else first(function)

    fun last(): Direction = if (isEast) WEST else SOUTH

    companion object {
        fun first(function: () -> Boolean): Direction = if (function.invoke()) EAST else SOUTH
    }
}
