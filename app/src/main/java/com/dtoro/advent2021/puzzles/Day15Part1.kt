package com.dtoro.advent2021.puzzles

import java.util.*

/**
 * https://adventofcode.com/2021/day/15
 * Chiton
 */
class Day15Part1 : PuzzleBase<Day15Part1.Grid, Day15Part1.Risk>() {

    override val day = 15
    override val part = 1

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
            x = risks.indices.last(),
            y = risks.first().indices.last(),
        )
    }

    private fun Grid.get(point: Point): Int? {
        return risks.getOrNull(point.x)?.getOrNull(point.y)
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
}
