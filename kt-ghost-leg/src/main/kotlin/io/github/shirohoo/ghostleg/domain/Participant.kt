package io.github.shirohoo.ghostleg.domain

data class Participant(val name: Name, val point: Point = Point()) {
    val x = point.x

    val y = point.y

    constructor(name: String) : this(Name(name))

    fun move(dx: Int, dy: Int): Participant = Participant(name, point.move(dx, dy))

    fun move(direction: Direction): Participant = Participant(name, point.move(direction))
}