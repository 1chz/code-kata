package io.github.shirohoo.ghostleg.domain

class Participant(val name: Name, val point: Point = Point()) {
    constructor(name: String) : this(Name(name))

    val x = point.x

    val y = point.y

    fun move(dx: Int, dy: Int): Participant = Participant(name, point.move(dx, dy))
}
