package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/3
 * Binary Diagnostic
 */
class Day03Part2 : SimplePuzzleBase<String, Day03Part2.LifeSupport>() {

    override val day = 3
    override val part = 1

    data class LifeSupport(val oxygen : Int, val carbon: Int)

    override fun convertInput(input: String): String = input

    override fun convertOutput(output: LifeSupport): String {
        return output.run { oxygen * carbon }.toString()
    }

    override fun run(input: List<String>) : LifeSupport {
        val oxygen = getMeasurement(input, this::filterMostCommon)
        val carbon = getMeasurement(input, this::filterLeastCommon)
        return LifeSupport(
            oxygen = oxygen.binaryToInt(),
            carbon = carbon.binaryToInt(),
        )
    }

    private fun getMeasurement(input: List<String>, binaryFilter: (List<String>, Int) -> List<String>) : String {
        var candidates = input
        var index = 0
        while (candidates.size > 1) {
            candidates = binaryFilter(candidates, index)
            index++
        }
        return candidates.first()
    }

    private fun filterMostCommon(input: List<String>, index: Int) : List<String> {
        val mostCommon = mostCommon(input, index)
        return input.filter { it[index] == mostCommon }
    }

    private fun filterLeastCommon(input: List<String>, index: Int) : List<String> {
        val mostCommon = mostCommon(input, index)
        return input.filter { it[index] != mostCommon }
    }

    private fun mostCommon(input: List<String>, index: Int) : Char {
        val mostCommonCount = input
            .map { when(it[index]) {
                '0' -> -1
                else -> 1
            }}
            .sum()
        return when {
            mostCommonCount < 0 -> '0'
            else -> '1'
        }
    }

    private fun String.binaryToInt() : Int {
        var result = 0
        for (bit in this) {
            result = result shl 1
            result += bit - '0'
        }
        return result
    }
}
