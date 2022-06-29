package io.github.shirohoo.ghostleg.domain

import kotlin.random.Random

class LadderLine(width: Int) {
    private val ladderBlocks: List<LadderBlock>

    init {
        require(width >= 2) {
            "the ladder wide must be at least 2."
        }

        ladderBlocks = mutableListOf<LadderBlock>()
            .apply {
                createdFirst()
                createMiddle(width)
                createLast()
            }.toList()
    }

    private fun MutableList<LadderBlock>.createMiddle(width: Int) {
        if (width == 2) {
            return
        }
        repeat(width - 2) {
            add(last().createNext { Random.nextBoolean() })
        }
    }

    private fun MutableList<LadderBlock>.createdFirst() {
        add(LadderBlock.createFirst { Random.nextBoolean() })
    }

    private fun MutableList<LadderBlock>.createLast() {
        add(last().createLast())
    }

    val size by lazy { ladderBlocks.size }
}
