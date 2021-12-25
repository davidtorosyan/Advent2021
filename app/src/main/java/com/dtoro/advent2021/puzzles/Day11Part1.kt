package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/11
 * Dumbo Octopus
 */
class Day11Part1 : PuzzleBase<Day11Part1.Grid, Int>() {

    companion object {
        private const val STEPS = 100
        private const val MAX_ENERGY = 9
    }

    override val day = 11
    override val part = 1

    data class Grid(val grid : List<List<Octopus>>)

    class Octopus(
        val row: Int,
        val col: Int,
        var energy: Int,
    ) {
        private val id = Pair(row, col)

        override fun equals(other: Any?): Boolean = id == (other as? Octopus)?.id
        override fun hashCode() = id.hashCode()
        override fun toString() = energy.toString()

        fun increment() : Int {
            return ++energy
        }

        fun reset() {
            energy = 0
        }
    }

    override fun convertInput(input: List<String>): Grid {
        return Grid(input.mapIndexed { row, line ->
            line.mapIndexed { col, energy ->
                Octopus(
                    row = row,
                    col = col,
                    energy = energy.digitToInt(),
                )
            }
        })
    }

    override fun convertOutput(output: Int) = output.toString()

    override fun run(input: Grid) : Int {
        var flashes = 0
        for (step in 0 until STEPS) {
            flashes += input.simulateStep()
        }
        return flashes
    }

    private fun Grid.simulateStep() : Int {
        val ready = ArrayDeque<Octopus>()
        val flashed = mutableSetOf<Octopus>()

        grid.flatten().forEach {
            if (it.increment() == MAX_ENERGY + 1) {
                ready.addLast(it)
            }
        }

        while (ready.isNotEmpty()) {
            val flashing = ready.removeFirst()
            this.adjacent(flashing).forEach {
                if (it.increment() == MAX_ENERGY + 1) {
                    ready.addLast(it)
                }
            }
            flashed.add(flashing)
        }

        flashed.forEach {
            it.reset()
        }

        return flashed.size
    }

    private fun Grid.adjacent(to: Octopus) : List<Octopus> {
        return (-1..1).map { i ->
            (-1..1).map { j ->
                if (i == 0 && j == 0) {
                    null
                } else {
                    this.grid
                        .getOrNull(to.row + i)
                        ?.getOrNull(to.col + j)
                }
            }
        }
            .flatten()
            .filterNotNull()
    }

    private fun Grid.toDebugString() : String {
        return this.grid.joinToString(separator = "\n") {
            it.joinToString(separator = "")
        }
    }
}
