package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ParticipantsTests {
    @Test
    fun `참가자들을 입력받아 일급컬렉션을 생성한다`() {
        // given
        val james = Participant("james")
        val john = Participant("john")
        val anna = Participant("anna")

        // when
        val participants = Participants(james, john, anna)

        // then
        assertEquals(3, participants.size)
    }

    @Test
    fun `참가자의 이름들을 입력받아 일급컬렉션을 생성한다`() {
        val participants = Participants("james", "john", "anna")

        assertEquals(3, participants.size)
    }

    @Test
    fun `참가자는 최소한 두명 이상이어야 한다`() {
        assertThrows<IllegalArgumentException> { Participants("james") }
    }
}