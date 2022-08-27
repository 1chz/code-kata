package io.github.shirohoo.ghostleg.domain

class Ladder(lines: LadderLines) {
    init {
        require(lines.size >= MIN_LINES) {
            "There must be at least $MIN_LINES ladder lines."
        }
    }

    companion object {
        private const val MIN_LINES = 2
    }
}