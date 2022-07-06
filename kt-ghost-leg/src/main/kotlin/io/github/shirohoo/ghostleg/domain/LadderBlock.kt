package io.github.shirohoo.ghostleg.domain

class LadderBlock private constructor(val direction: Direction) {
    private val isEast
        get() = direction == Direction.EAST

    fun createNext(function: () -> Boolean): LadderBlock =
        if (isEast) LadderBlock(Direction.WEST)
        else createFirst(function)

    fun createLast(): LadderBlock =
        if (isEast) LadderBlock(Direction.WEST)
        else LadderBlock(Direction.SOUTH)

    companion object {
        fun createFirst(function: () -> Boolean): LadderBlock =
            if (function.invoke()) LadderBlock(Direction.EAST)
            else LadderBlock(Direction.SOUTH)
    }
}