package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/12
 * Passage Pathing
 */
class Day12Part2 : SimplePuzzleBase<Day12Part2.Tunnel, List<Day12Part2.Path>>() {

    override val day = 12
    override val part = 2

    sealed class Cave : Comparable<Cave> {

        abstract val priority : Int

        override fun compareTo(other: Cave): Int {
            return priority - other.priority
        }

        object Start : Cave() {
            override val priority = 0

            override fun toString(): String {
                return "start"
            }
        }

        object End : Cave() {
            override val priority = 1

            override fun toString(): String {
                return "end"
            }
        }

        data class Big(val name: String) : Cave() {
            override val priority = 2

            override fun compareTo(other: Cave): Int {
                return when (val diff = super.compareTo(other)) {
                    0 -> name.compareTo((other as Big).name)
                    else -> diff
                }
            }
        }

        data class Small(val name: String) : Cave() {
            override val priority = 3

            override fun compareTo(other: Cave): Int {
                return when (val diff = super.compareTo(other)) {
                    0 -> name.compareTo((other as Small).name)
                    else -> diff
                }
            }
        }
    }

    data class Tunnel(
        val left: Cave,
        val right: Cave,
    )

    data class Path(val caves: List<Cave>)

    override fun convertInput(input: String) : Tunnel {
        val (first, second) = input.split("-")
        return Tunnel(
            left = first.toCave(),
            right = second.toCave(),
        )
    }

    override fun convertOutput(output: List<Path>) : String {
        return output
            .size
            .toString()
    }

    override fun run(input: List<Tunnel>) : List<Path> {
        val options = findOptions(input)
        val paths = mutableListOf<Path>()

        val path = mutableListOf<Cave>(Cave.Start)
        var prev: Cave? = null
        while (path.isNotEmpty()) {
            val current = path.last()
            prev = if (current is Cave.End) {
                paths.add(Path(caves = path.toList()))
                path.removeLast()
            } else {
                val choices = options.getOrElse(current, { emptyList() })
                val next = chooseNext(path, choices, prev)
                if (next == null) {
                    path.removeLast()
                } else {
                    path.add(next)
                    null
                }
            }
        }

        return paths
    }

    private fun chooseNext(path: List<Cave>, choices: List<Cave>, prev: Cave?) : Cave? {
        val hasDuplicate = hasDuplicateSmallCave(path)
        return choices.firstOrNull {
            when {
                it is Cave.Start -> false
                hasDuplicate && it is Cave.Small && it in path -> false
                prev == null -> true
                else -> it > prev
            }
        }
    }

    private fun hasDuplicateSmallCave(path: List<Cave>) : Boolean {
        return path
            .filterIsInstance<Cave.Small>()
            .groupBy { it }
            .any { it.value.size > 1 }
    }

    private fun findOptions(tunnels: List<Tunnel>) : Map<Cave, List<Cave>> {
        val leftToRight = tunnels.map { it.left to it.right }
        val rightToLeft = tunnels.map { it.right to it.left }
        val both = leftToRight + rightToLeft
        return both
            .groupBy({ it.first }) { it.second }
            .mapValues { it.value.sorted() }
    }

    private fun String.toCave() : Cave {
        val name = this
        return when {
            name == "start" -> Cave.Start
            name == "end" -> Cave.End
            name[0].isUpperCase() -> Cave.Big(name)
            else -> Cave.Small(name)
        }
    }
}
