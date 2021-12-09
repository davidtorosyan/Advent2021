package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/9
 * Smoke Basin
 */
class Day9Part2 : SimplePuzzleBase<List<Int>, List<Day9Part2.Basin>>() {

    override val day = 9
    override val part = 2

    companion object {
        private const val MAX_VALUE = 9
    }

    data class Basin(val points: Set<Point>)
    data class Point(val row: Int, val col: Int)

    override fun convertInput(input: String): List<Int> {
        return input.map { Character.getNumericValue(it) }
    }

    override fun convertOutput(output: List<Basin>) : String {
        return output
            .map { it.points.size }
            .sortedDescending()
            .take(3)
            .fold(1) { x, y -> x * y}
            .toString()
    }

    override fun run(input: List<List<Int>>) : List<Basin> {
        return findLowPoints(input)
            .map { findBasin(input, it) }
    }

    private fun findLowPoints(grid: List<List<Int>>) : Set<Point> {
        val lowPoints = mutableSetOf<Point>()
        grid.forEachIndexed { row, values ->
            values.forEachIndexed { col, value ->
                val point = Point(row, col)
                val adj = point.getAdjacent(grid)
                if (adj.all { it.value(grid) > value }) {
                    lowPoints.add(Point(
                        row = row,
                        col = col,
                    ))
                }
            }
        }
        return lowPoints
    }

    private fun Point.getAdjacent(grid: List<List<Int>>) : List<Point> {
        return listOf(
            Point(row = row-1, col),
            Point(row = row+1, col),
            Point(row = row, col-1),
            Point(row = row, col+1),
        ).filter {
            it.inGrid(grid)
        }
    }

    private fun Point.value(grid: List<List<Int>>) : Int {
        return grid[row][col]
    }

    private fun Point.inGrid(grid: List<List<Int>>) : Boolean {
        return row >= 0 && row < grid.size && col >= 0 && col < grid.first().size
    }

    private fun findBasin(grid: List<List<Int>>, lowPoint: Point) : Basin {
        val basin = mutableSetOf(lowPoint)
        val visited = mutableSetOf<Point>()

        fun unvisited() = basin - visited

        while (unvisited().isNotEmpty()) {
            val point = unvisited().first()

            basin.addAll(point.getAdjacent(grid).filter {
                it.value(grid) > point.value(grid) && it.value(grid) < MAX_VALUE
            })

            visited.add(point)
        }

        return Basin(points = basin)
    }
}
