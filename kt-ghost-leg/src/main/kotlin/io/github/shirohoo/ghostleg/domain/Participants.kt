package io.github.shirohoo.ghostleg.domain

class Participants(vararg participants: Participant) {
    constructor(vararg participants: String) : this(*participants.map(::Participant).toTypedArray())

    private val participants: Array<Participant> = arrayOf(*participants)

    val size = this.participants.size
}
