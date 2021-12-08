package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/1
 * Sonar Sweep
 */
class Day1Part2 : SimplePuzzleBase<Int, Int>() {

    override val day = 1
    override val part = 2

    override fun convertInput(input: String) = input.toInt()
    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Int>) : Int {
        val windowed = toWindow(input, 3)
        return countIncreases(windowed)
    }

    private fun toWindow(list: List<Int>, windowSize: Int) : List<Int> {
        val result = mutableListOf<Int>()
        for (i in 2 until list.size) {
            result.add(list[i-2] + list[i-1] + list[i])
        }
        return result
    }

    private fun countIncreases(list: List<Int>) : Int {
        var count = 0
        for (i in 1 until list.size) {
            if (list[i] > list[i-1]) {
                count++
            }
        }
        return count
    }
}
