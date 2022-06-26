package io.github.shirohoo.ghostleg.domain

class Participant(val name: Name, val point: Point) {
    fun move(dx: Int, dy: Int): Participant = Participant(name, point.move(dx, dy))
}
