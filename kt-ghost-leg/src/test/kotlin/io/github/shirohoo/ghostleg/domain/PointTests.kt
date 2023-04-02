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

    @Test
    fun `동쪽을 입력받으면 x좌표를 1 증가 시킨다`() {
        // given
        var point = Point()

        // when
        point = point.move(Direction.EAST)

        // then
        assertEquals(1, point.x)
    }

    @Test
    fun `서쪽을 입력받으면 x좌표를 1 감소 시킨다`() {
        // given
        var point = Point()

        // when
        point = point.move(Direction.WEST)

        // then
        assertEquals(-1, point.x)
    }

    @Test
    fun `남쪽을 입력받으면 x좌표는 변하지 않는다`() {
        // given
        var point = Point()

        // when
        point = point.move(Direction.SOUTH)

        // then
        assertEquals(0, point.x)
    }
}
