package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/5
 * Hydrothermal Venture
 */
class Day5Part1 : SimplePuzzleBase<Day5Part1.Line, Int>() {

    override val day = 5
    override val part = 1

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
        val lines = input.filter { it.isHorizontal() || it.isVertical() }
        val points = lines.flatMap { listOf(it.start, it.end) }
        val maxX = points.map { it.x }.maxOrNull() ?: error("No lines!")
        val maxY = points.map { it.y }.maxOrNull() ?: error("No lines!")
        val grid = Array(maxY + 1) { Array(maxX + 1) { 0 } }

        var overlapCount = 0
        for (line in lines) {
            if (line.isVertical()) {
                val x = line.start.x
                val (start, end) = listOf(line.start.y, line.end.y).sorted()
                for (y in start .. end) {
                    val result = ++grid[y][x]
                    if (result == 2) {
                        overlapCount++
                    }
                }
            }
            else {
                val y = line.start.y
                val (start, end) = listOf(line.start.x, line.end.x).sorted()
                for (x in start .. end) {
                    val result = ++grid[y][x]
                    if (result == 2) {
                        overlapCount++
                    }
                }
            }
        }

        return overlapCount
    }

    private fun Line.isHorizontal() : Boolean {
        return start.y == end.y
    }

    private fun Line.isVertical() : Boolean {
        return start.x == end.x
    }

    private fun Array<Array<Int>>.toDebugString() : String {
        return joinToString(separator = "\n") { row ->
            row.joinToString(separator = "") { if (it == 0) "." else it.toString() }
        }
    }
}
