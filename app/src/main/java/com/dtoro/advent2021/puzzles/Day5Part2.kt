package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/5
 */
class Day5Part2 : SimplePuzzleBase<Day5Part2.Line, Int>() {

    override val day = 5
    override val part = 2

    data class Point(val x: Int, val y: Int)
    data class Line(val start: Point, val end: Point)

    override fun convertInput(input: String): Line {
        val (start, end) = input.split(" -> ")
        return Line(
            start = convertPoint(start),
            end = convertPoint(end),
        )
    }

    private fun convertPoint(input: String) : Point {
        val (x, y) = input.split(",").map { it.toInt() }
        return Point(x, y)
    }

    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: List<Line>) : Int {
        val points = input.flatMap { listOf(it.start, it.end) }
        val maxX = points.map { it.x }.maxOrNull() ?: error("No lines!")
        val maxY = points.map { it.y }.maxOrNull() ?: error("No lines!")
        val grid = Array(maxY + 1) { Array(maxX + 1) { 0 } }

        var overlapCount = 0

        fun markPoint(point: Point) {
            val result = ++grid[point.y][point.x]
            if (result == 2) {
                overlapCount++
            }
        }

        for (line in input) {
            var current = line.start
            while (current != line.end) {
                markPoint(current)
                current = current.toward(line.end)
            }
            markPoint(current)
        }

        return overlapCount
    }

    private fun Array<Array<Int>>.toDebugString() : String {
        return joinToString(separator = "\n") { row ->
            row.joinToString(separator = "") { if (it == 0) "." else it.toString() }
        }
    }

    private fun Point.toward(target: Point) : Point {
        return Point(
            x = x.toward(target.x),
            y = y.toward(target.y),
        )
    }

    private fun Int.toward(target: Int): Int {
        return when {
            this < target -> this + 1
            this > target -> this - 1
            else -> this
        }
    }
}
