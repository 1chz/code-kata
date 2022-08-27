package io.github.shirohoo.ghostleg.domain

class ArrivalPoints(vararg arrivalPoints: ArrivalPoint) {
    private val arrivalPoints: Array<ArrivalPoint> = arrayOf(*arrivalPoints)

    val size = this.arrivalPoints.size

    init {
        require(arrivalPoints.size >= MIN_SIZE) {
            "the number of arrival points must be at least 2."
        }
    }

    constructor(vararg arrivalPoints: String) : this(*arrivalPoints.map(::ArrivalPoint).toTypedArray())

    companion object {
        private const val MIN_SIZE = 2
    }
}