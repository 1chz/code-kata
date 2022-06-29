package io.github.shirohoo.ghostleg.domain

class LadderCell(val direction: Direction) {
    private val isEast get() = direction == Direction.EAST

    fun next(function: () -> Boolean): LadderCell =
        if (isEast) LadderCell(Direction.WEST)
        else first(function)

    fun last(): LadderCell =
        if (isEast) LadderCell(Direction.WEST)
        else LadderCell(Direction.SOUTH)

    companion object {
        fun first(function: () -> Boolean): LadderCell =
            if (function.invoke()) LadderCell(Direction.EAST)
            else LadderCell(Direction.SOUTH)
    }
}