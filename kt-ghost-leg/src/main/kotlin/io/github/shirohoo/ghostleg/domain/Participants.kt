package io.github.shirohoo.ghostleg.domain

class Participants(vararg participants: Participant) {
    private val participants: Array<Participant> = arrayOf(*participants)

    val size = this.participants.size

    init {
        require(participants.size >= MIN_SIZE) {
            "the number of participants must be at least 2."
        }
    }

    constructor(vararg participants: String) : this(*participants.map(::Participant).toTypedArray())

    companion object {
        private const val MIN_SIZE = 2
    }
}