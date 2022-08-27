package io.github.shirohoo.ghostleg.domain

class LadderLines(context: LadderContext) {
    val size: Int by lazy { ladderLines.size }

    private val ladderLines: List<LadderLine>

    init {
        ladderLines = (1..context.height)
            .map { LadderLine(context) }
            .toList()
    }
}