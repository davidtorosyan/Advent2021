package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/8
 * Seven Segment Search
 */
class Day08Part1 : SimplePuzzleBase<Day08Part1.Entry, Int>() {

    override val day = 8
    override val part = 1

    data class Entry(val signals: List<String>, val output: List<String>)

    enum class Segment(val length: Int) {
        ZERO(6),
        ONE(2),
        TWO(5),
        THREE(5),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(3),
        EIGHT(7),
        NINE(6),
    }

    override fun convertInput(input: String): Entry {
        val (signals, output) = input.split("|")
        return Entry(
            signals = signals.split(" ").filter { it.isNotEmpty() },
            output = output.split(" ").filter { it.isNotEmpty() },
        )
    }

    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Entry>) : Int {
        return input
            .map { it.output }
            .flatten()
            .count {
                it.length in setOf(
                    Segment.ONE.length,
                    Segment.FOUR.length,
                    Segment.SEVEN.length,
                    Segment.EIGHT.length,
                )
            }
    }
}
