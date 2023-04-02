package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LadderBlockTests {
    @Test
    fun `가장 왼쪽에서 참을 입력받으면 다음 방향은 동쪽이다`() {
        val firstBlock: LadderBlock = LadderBlock.createFirst { true }

        assertEquals(Direction.EAST, firstBlock.direction)
    }

    @Test
    fun `가장 왼쪽에서 거짓을 입력받으면 다음 방향은 남쪽이다`() {
        val firstBlock: LadderBlock = LadderBlock.createFirst { false }

        assertEquals(Direction.SOUTH, firstBlock.direction)
    }

    @Test
    fun `현재 방향이 동쪽이면 입력에 관계 없이 다음 방향은 항상 서쪽이다`() {
        // given
        val firstBlock: LadderBlock = LadderBlock.createFirst { true }

        // when
        val nextBlock: LadderBlock = firstBlock.createNext { true }

        // then
        assertEquals(Direction.WEST, nextBlock.direction)
    }

    @Test
    fun `현재 방향이 남쪽이고 참을 입력 받으면 다음 방향은 동쪽이다`() {
        // given
        val firstBlock: LadderBlock = LadderBlock.createFirst { false }

        // when
        val nextBlock: LadderBlock = firstBlock.createNext { true }

        // then
        assertEquals(Direction.EAST, nextBlock.direction)
    }

    @Test
    fun `현재 방향이 남쪽이고 거짓을 입력 받으면 다음 방향은 남쪽이다`() {
        // given
        val firstBlock: LadderBlock = LadderBlock.createFirst { false }

        // when
        val nextBlock: LadderBlock = firstBlock.createNext { false }

        // then
        assertEquals(Direction.SOUTH, nextBlock.direction)
    }

    @Test
    fun `현재 방향은 남쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 남쪽이다`() {
        // given
        val firstBlock: LadderBlock = LadderBlock.createFirst { false }
        val nextBlock: LadderBlock = firstBlock.createNext { false }

        // when
        val lastBlock: LadderBlock = nextBlock.createLast()

        // then
        assertEquals(Direction.SOUTH, lastBlock.direction)
    }

    @Test
    fun `현재 방향은 동쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 서쪽이다`() {
        // given
        val firstBlock: LadderBlock = LadderBlock.createFirst { false }
        val nextBlock: LadderBlock = firstBlock.createNext { true }

        // when
        val lastBlock: LadderBlock = nextBlock.createLast()

        // then
        assertEquals(Direction.WEST, lastBlock.direction)
    }
}
