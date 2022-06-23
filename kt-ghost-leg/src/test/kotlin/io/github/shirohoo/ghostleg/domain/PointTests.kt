package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PointTests {
    @Test
    fun `좌표의 기본 값은 0, 0이어야 한다`() {
        assertEquals(Point(x = 0, y = 0), Point())
        assertEquals(Point(x = 1, y = 0), Point(x = 1))
        assertEquals(Point(x = 0, y = 1), Point(y = 1))
    }

    @Test
    fun `x좌표를 증가시킬 수 있다`() {
        val point = Point()
        assertEquals(Point(x = 1), point.move(1, 0))
    }

    @Test
    fun `x좌표를 감소시킬 수 있다`() {
        val point = Point()
        assertEquals(Point(x = -1), point.move(-1, 0))
    }

    @Test
    fun `y좌표를 증가시킬 수 있다`() {
        val point = Point()
        assertEquals(Point(y = 1), point.move(0, 1))
    }

    @Test
    fun `y좌표를 감소시킬 수 있다`() {
        val point = Point()
        assertEquals(Point(y = -1), point.move(0, -1))
    }
}