package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/7
 * The Treachery of Whales
 */
class Day7Part1 : PuzzleBase<List<Int>, Int>() {

    override val day = 7
    override val part = 1

    override fun convertInput(input: List<String>): List<Int> {
        return input.first().split(",").map { it.toInt() }
    }
    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Int>) : Int {
        val totalCrabs = input.size
        val crabs = input.groupBy { it }.mapValues { (_, value) -> value.size }.toSortedMap()
        val startingPosition = crabs.keys.first() - 1
        var fuel = crabs.map { (it.key - startingPosition) * it.value  }.sum()
        var minFuel = fuel
        var crabsSeen = 0
        for (position in crabs.keys.first()..crabs.keys.last()) {
            fuel += crabsSeen
            fuel -= totalCrabs - crabsSeen
            crabsSeen += crabs[position] ?: 0
            minFuel = minOf(minFuel, fuel)
        }
        return minFuel
    }
}
