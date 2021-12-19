package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/9
 * Smoke Basin
 */
class Day09Part1 : SimplePuzzleBase<List<Int>, List<Int>>() {

    override val day = 9
    override val part = 1

    override fun convertInput(input: String): List<Int> {
        return input.map { Character.getNumericValue(it) }
    }

    override fun convertOutput(output: List<Int>) : String {
        return output.map { it + 1 }.sum().toString()
    }

    override fun run(input: List<List<Int>>) : List<Int> {
        val lowPoints = mutableListOf<Int>()
        input.forEachIndexed { row, values ->
            values.forEachIndexed { col, value ->
                val adj = getAdjacent(input, row, col)
                if (adj.all { it > value }) {
                    lowPoints.add(value)
                }
            }
        }
        return lowPoints
    }

    private fun getAdjacent(grid: List<List<Int>>, row: Int, col: Int) : List<Int> {
        return listOfNotNull(
            grid.getOrNull(row - 1)?.getOrNull(col),
            grid.getOrNull(row + 1)?.getOrNull(col),
            grid.getOrNull(row)?.getOrNull(col - 1),
            grid.getOrNull(row)?.getOrNull(col + 1),
        )
    }
}
