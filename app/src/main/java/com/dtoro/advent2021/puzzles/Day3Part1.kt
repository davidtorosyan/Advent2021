package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/3
 */
class Day3Part1 : PuzzleBase<String, Day3Part1.Power>() {

    override val day = 3
    override val part = 1

    data class Power(val gamma : Int, val epsilon: Int)

    override fun convertInput(input: String): String = input

    override fun convertOutput(output: Power): String {
        return output.run { gamma * epsilon }.toString()
    }

    override fun run(input: List<String>) : Power {
        val mostCommonCount = Array(input.first().length) { 0 }
        for (binary in input) {
            for (i in binary.indices) {
                mostCommonCount[i] += when (binary[i]) {
                    '0' -> -1
                    else -> 1
                }
            }
        }
        val gamma = mostCommonCount.map { when {
            it < 0 -> 0
            else -> 1
        }}
        val epsilon = gamma.map { 1 - it }
        return Power(
            gamma = gamma.binaryToInt(),
            epsilon = epsilon.binaryToInt(),
        )
    }

    private fun List<Int>.binaryToInt() : Int {
        var result = 0
        for (bit in this) {
            result = result shl 1
            result += bit
        }
        return result
    }
}
