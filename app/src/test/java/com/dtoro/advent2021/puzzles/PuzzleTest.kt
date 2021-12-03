package com.dtoro.advent2021.puzzles

import org.junit.Assert
import org.junit.Test

class PuzzleTest {

    @Test
    fun `Day1Part1 sample`() {
        Assert.assertEquals(
            "7", Day1Part1().run(
                listOf(
                    "199",
                    "200",
                    "208",
                    "210",
                    "200",
                    "207",
                    "240",
                    "269",
                    "260",
                    "263",
                )
            )
        )
    }

    @Test
    fun `Day1Part1 puzzle`() {
        Day1Part1().test()
    }

    @Test
    fun `Day1Part2 sample`() {
        Assert.assertEquals(
            "5", Day1Part2().run(
                listOf(
                    "607",
                    "618",
                    "618",
                    "617",
                    "647",
                    "716",
                    "769",
                    "792",
                )
            )
        )
    }

    @Test
    fun `Day1Part2 puzzle`() {
        Day1Part2().test()
    }

    @Test
    fun `Day2Part1 sample`() {
        Assert.assertEquals(
            "150", Day2Part1().run(
                listOf(
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2",
                )
            )
        )
    }

    @Test
    fun `Day2Part1 puzzle`() {
        Day2Part1().test()
    }

    @Test
    fun `Day2Part2 sample`() {
        Assert.assertEquals(
            "900", Day2Part2().run(
                listOf(
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2",
                )
            )
        )
    }

    @Test
    fun `Day2Part2 puzzle`() {
        Day2Part2().test()
    }

    private fun <T,K> PuzzleBase<T,K>.test() {
        println("$this: ${run()}")
    }
}
