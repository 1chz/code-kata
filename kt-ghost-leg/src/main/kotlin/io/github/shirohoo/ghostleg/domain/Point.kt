package io.github.shirohoo.ghostleg.domain

data class Point(val x: Int = 0, val y: Int = 0) {
    /**
     * Translates this point, at location `(x,y)`,
     * by `dx` along the `x` axis and `dy`
     * along the `y` axis so that it now represents the point
     * `(x+dx,y+dy)`.
     *
     * @param dx the distance to move this point
     * along the X axis
     * @param dy the distance to move this point
     * along the Y axis
     */
    fun move(dx: Int, dy: Int): Point = Point(x + dx, y + dy)

    fun move(direction: Direction): Point = when (direction) {
        Direction.EAST -> Point(x + 1, y)
        Direction.WEST -> Point(x - 1, y)
        Direction.SOUTH -> Point(x, y)
    }
}