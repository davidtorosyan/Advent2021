package com.dtoro.advent2021.puzzles

import java.util.*

/**
 * https://adventofcode.com/2021/day/7
 */
class Day7Part2 : PuzzleBase<List<Int>, Int>() {

    override val day = 7
    override val part = 2

    override fun convertInput(input: List<String>): List<Int> {
        return input.first().split(",").map { it.toInt() }
    }
    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Int>) : Int {
        val crabs = input
            .groupBy { it }
            .mapValues { (_, value) -> value.size }
            .toSortedMap()

        val ascendingTrail = createTrail(crabs, reverse = false)
        val descendingTrail = createTrail(crabs, reverse = true)

        return ascendingTrail
            .zip(descendingTrail) { a, b -> a + b }
            .minOrNull() ?: error("No items!")
    }

    private fun createTrail(crabs: SortedMap<Int, Int>, reverse: Boolean) : Array<out Int> {
        val range = if (reverse) {
            crabs.keys.last() downTo crabs.keys.first()
        } else {
            crabs.keys.first()..crabs.keys.last()
        }

        val previousIndex = if (reverse) 1 else -1

        val trail = Array(crabs.keys.last() + 1) { 0 }
        var crabsSeen = 0
        for (position in range) {
            trail[position] = trail.getOrElse(position + previousIndex) { 0 } + crabsSeen
            crabsSeen += crabs[position] ?: 0
        }

        for (position in range) {
            trail[position] += trail.getOrElse(position + previousIndex) { 0 }
        }

        return trail
    }
}
