package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.*
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
        assertEquals(participant.name, name)
        assertEquals(participant.point, point)
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
        assertEquals(1, participant.point.x)
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
        assertEquals(-1, participant.point.x)
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
        assertEquals(1, participant.point.y)
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
        assertEquals(-1, participant.point.y)
    }
}