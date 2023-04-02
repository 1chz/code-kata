package io.github.shirohoo.ghostleg.domain

data class ArrivalPoint(val name: String) {
    init {
        require(name.isNotBlank()) {
            "The 'name' must not be blank."
        }
    }
}
