package io.github.shirohoo.ghostleg.domain

import kotlin.random.Random

class LadderLine(context: LadderContext) {
    val size by lazy { ladderBlocks.size }

    private val ladderBlocks: List<LadderBlock>

    init {
        ladderBlocks = buildList {
            createFirst()
            createMiddle(context)
            createLast()
        }
    }

    private fun MutableList<LadderBlock>.createFirst() = add(LadderBlock.createFirst { Random.nextBoolean() })

    private fun MutableList<LadderBlock>.createMiddle(context: LadderContext) {
        // Since the input width is verified in LadderContext, it is always 2 or more.
        if (context.width == MIN_WIDTH) return

        repeat(context.width - EXCLUDE_HEAD_AND_TAIL) {
            add(last().createNext { Random.nextBoolean() })
        }
    }

    private fun MutableList<LadderBlock>.createLast() = add(last().createLast())

    companion object {
        private const val MIN_WIDTH = 2
        private const val EXCLUDE_HEAD_AND_TAIL = 2
    }
}
