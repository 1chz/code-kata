package io.github.shirohoo.ghostleg.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DirectionTests {
    @Test
    fun `가장 왼쪽에서 참을 입력받으면 다음 방향은 동쪽이다`() {
        val direction: Direction = Direction.first { true }

        assertTrue(direction.isEast)
    }

    @Test
    fun `가장 왼쪽에서 거짓을 입력받으면 다음 방향은 남쪽이다`() {
        val direction: Direction = Direction.first { false }

        assertTrue(direction.isSouth)
    }

    @Test
    fun `현재 방향이 동쪽이면 입력에 관계 없이 다음 방향은 항상 서쪽이다`() {
        // given
        val first: Direction = Direction.first { true }

        // when
        val next: Direction = first.next { true }

        // then
        assertTrue(next.isWest)
    }

    @Test
    fun `현재 방향이 남쪽이고 참을 입력 받으면 다음 방향은 동쪽이다`() {
        // given
        val first: Direction = Direction.first { false }

        // when
        val next: Direction = first.next { true }

        // then
        assertTrue(next.isEast)
    }

    @Test
    fun `현재 방향이 남쪽이고 거짓을 입력 받으면 다음 방향은 남쪽이다`() {
        // given
        val first: Direction = Direction.first { false }

        // when
        val next: Direction = first.next { false }

        // then
        assertTrue(next.isSouth)
    }

    @Test
    fun `현재 방향은 남쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 남쪽이다`() {
        // given
        val first: Direction = Direction.first { false }
        val next: Direction = first.next { false }

        // when
        val last: Direction = next.last()

        // then
        assertTrue(last.isSouth)
    }

    @Test
    fun `현재 방향은 동쪽이고 다음이 사다리의 가장 오른쪽이라면 다음 방향은 항상 서쪽이다`() {
        // given
        val first: Direction = Direction.first { false }
        val next: Direction = first.next { true }

        // when
        val last: Direction = next.last()

        // then
        assertTrue(last.isWest)
    }
}