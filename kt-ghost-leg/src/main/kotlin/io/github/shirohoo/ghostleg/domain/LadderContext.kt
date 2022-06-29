package io.github.shirohoo.ghostleg.domain

class LadderContext(val width: Int, val height: Int) {
    init {
        require(width < MIN_WIDTH) {
            "the ladder wide must be at least ${MIN_WIDTH}."
        }

        require(height < MIN_HEIGHT) {
            "the ladder height must be at least ${MIN_HEIGHT}."
        }
    }

    companion object {
        private const val MIN_WIDTH = 2
        private const val MIN_HEIGHT = 2
    }
}
