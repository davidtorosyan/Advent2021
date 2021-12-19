package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/1
 * Sonar Sweep
 */
class Day01Part1 : SimplePuzzleBase<Int, Int>() {

    override val day = 1
    override val part = 1

    override fun convertInput(input: String) = input.toInt()
    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Int>) : Int {
        var count = 0
        for (i in 1 until input.size) {
            if (input[i] > input[i-1]) {
                count++
            }
        }
        return count
    }
}
