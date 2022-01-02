package com.dtoro.advent2021.puzzles

import java.lang.StringBuilder
import java.util.*

/**
 * https://adventofcode.com/2021/day/15
 * Chiton
 */
class Day15Part2 : PuzzleBase<Day15Part2.Grid, Day15Part2.Risk>() {

    companion object {
        const val MULTIPLIER = 5
        const val MAX_RISK = 9
    }

    override val day = 15
    override val part = 2

    data class Grid(val risks: List<List<Int>>)

    data class Point(val x: Int, val y: Int)

    data class Risk(
        val point: Point,
        val risk: Int,
        val prev: Risk?,
    ) : Comparable<Risk> {
        override operator fun compareTo(other: Risk): Int {
            return risk - other.risk
        }
    }

    override fun convertInput(input: List<String>): Grid {
        return Grid(risks = input.map { row ->
            row.map { item ->
                item.digitToInt()
            }
        })
    }

    override fun convertOutput(output: Risk): String {
        return output.risk.toString()
    }

    override fun run(input: Grid): Risk {
        val root = Risk(
            point = Point(x = 0, y = 0),
            risk = 0,
            prev = null,
        )

        val known = mutableSetOf<Point>()
        val queue = PriorityQueue(listOf(root))
        val goal = input.last()

        while (queue.isNotEmpty()) {
            val next = queue.poll() ?: error("Empty queue")
            val point = next.point
            if (known.add(point)) {
                if (point == goal) {
                    return next
                }
                queue.addAll(
                    next.point
                        .adjacent()
                        .filter { it !in known }
                        .mapNotNull { adj ->
                            input.get(adj)?.let { risk ->
                                Pair(adj, risk)
                            }
                        }.map { (adj, risk) ->
                            Risk(
                                point = adj,
                                risk = next.risk + risk,
                                prev = next,
                            )
                        }
                )
            }
        }

        error("Goal not found!")
    }

    private fun Grid.last(): Point {
        return Point(
            x = risks.size * MULTIPLIER - 1,
            y = risks.first().size * MULTIPLIER - 1,
        )
    }

    private fun Grid.get(point: Point): Int? {
        val maxX = risks.indices.last()
        val overX = point.x / (maxX + 1)
        if (point.x < 0 || overX >= MULTIPLIER) {
            return null
        }
        val modX = point.x % (maxX + 1)

        val maxY = risks.first().indices.last()
        val overY = point.y / (maxY + 1)
        if (point.y < 0 || overY >= MULTIPLIER) {
            return null
        }
        val modY = point.y % (maxY + 1)

        val risk = risks[modX][modY] + overX + overY
        return risk.modShift(min = 1, max = MAX_RISK)
    }

    private fun Int.modShift(min: Int, max: Int) : Int {
        return (this - min) % (max + 1 - min) + min
    }

    private fun Point.adjacent(): List<Point> {
        return (-1..1).map { i ->
            (-1..1).map { j ->
                Pair(i, j)
            }
        }
            .flatten()
            .filter { (i, j) ->
                (i == 0 || j == 0) && !(i == 0 && j == 0)
            }
            .map { (i, j) ->
                Point(
                    x = x + i,
                    y = y + j,
                )
            }
    }

    private fun Risk.path() : Set<Point> {
        val points = mutableSetOf<Point>()
        var current: Risk? = this
        while (current != null) {
            points.add(current.point)
            current = current.prev
        }
        return points
    }

    private fun Grid.toDebugString(goal: Risk?) : String {
        var x = 0
        var y = 0
        val sb = StringBuilder()

        val path = goal?.path() ?: emptySet()

        while (true) {
            var risk = this.get(Point(x, y))
            if (risk == null) {
                x++
                y = 0
                sb.appendLine()
                risk = this.get(Point(x, y))
                if (risk == null) {
                    break
                }
            }
            if (Point(x, y) in path) {
                sb.append(".")
            } else {
                sb.append(risk)
            }
            y++
        }

        return sb.toString()
    }
}
