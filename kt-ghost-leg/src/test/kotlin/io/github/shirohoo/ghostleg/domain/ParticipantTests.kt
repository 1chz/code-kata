package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ParticipantTests {
    @Test
    fun `참가자는 이름과 위치정보를 가진다`() {
        // given
        val name = Name("james")
        val point = Point()

        // when
        val participant = Participant(name, point)

        // then
        assertEquals(name, participant.name)
        assertEquals(point, participant.point)
    }

    @Test
    fun `x좌표를 증가시킬 수 있다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(1, 0)

        // then
        assertEquals(1, participant.x)
    }

    @Test
    fun `x좌표를 감소시킬 수 있다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(-1, 0)

        // then
        assertEquals(-1, participant.x)
    }

    @Test
    fun `y좌표를 증가시킬 수 있다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(0, 1)

        // then
        assertEquals(1, participant.y)
    }

    @Test
    fun `y좌표를 감소시킬 수 있다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(0, -1)

        // then
        assertEquals(-1, participant.y)
    }

    @Test
    fun `동쪽을 입력받으면 x좌표를 1 증가 시킨다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(Direction.EAST)

        // then
        assertEquals(1, participant.x)
    }

    @Test
    fun `서쪽을 입력받으면 x좌표를 1 감소 시킨다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(Direction.WEST)

        // then
        assertEquals(-1, participant.x)
    }

    @Test
    fun `남쪽을 입력받으면 x좌표는 변하지 않는다`() {
        // given
        val name = Name("james")
        val point = Point()
        var participant = Participant(name, point)

        // when
        participant = participant.move(Direction.SOUTH)

        // then
        assertEquals(0, participant.x)
    }
}