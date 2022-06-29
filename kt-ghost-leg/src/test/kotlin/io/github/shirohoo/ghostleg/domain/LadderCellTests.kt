package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LadderCellTests {
    @Test
    fun `가장 왼쪽에서 참을 입력받으면 다음 방향은 동쪽이다`() {
        val cell: LadderCell = LadderCell.first { true }

        assertEquals(Direction.EAST, cell.direction)
    }

    @Test
    fun `가장 왼쪽에서 거짓을 입력받으면 다음 방향은 남쪽이다`() {
        val cell: LadderCell = LadderCell.first { false }

        assertEquals(Direction.SOUTH, cell.direction)
    }

    @Test
    fun `현재 방향이 동쪽이면 입력에 관계 없이 다음 방향은 항상 서쪽이다`() {
        // given
        val first: LadderCell = LadderCell.first { true }

        // when
        val next: LadderCell = first.next { true }

        // then
        assertEquals(Direction.WEST, next.direction)
    }

    @Test
    fun `현재 방향이 남쪽이고 참을 입력 받으면 다음 방향은 동쪽이다`() {
        // given
        val first: LadderCell = LadderCell.first { false }

        // when
        val next: LadderCell = first.next { true }

        // then
        assertEquals(Direction.EAST, next.direction)
    }

    @Test
    fun `현재 방향이 남쪽이고 거짓을 입력 받으면 다음 방향은 남쪽이다`() {
        // given
        val first: LadderCell = LadderCell.first { false }

        // when
        val next: LadderCell = first.next { false }

        // then
        assertEquals(Direction.SOUTH, next.direction)
    }

    @Test
    fun `현재 방향은 남쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 남쪽이다`() {
        // given
        val first: LadderCell = LadderCell.first { false }
        val next: LadderCell = first.next { false }

        // when
        val last: LadderCell = next.last()

        // then
        assertEquals(Direction.SOUTH, last.direction)
    }

    @Test
    fun `현재 방향은 동쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 서쪽이다`() {
        // given
        val first: LadderCell = LadderCell.first { false }
        val next: LadderCell = first.next { true }

        // when
        val last: LadderCell = next.last()

        // then
        assertEquals(Direction.WEST, last.direction)
    }
}