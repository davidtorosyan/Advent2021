package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/13
 * Transparent Origami
 */
class Day13Part1 : PuzzleBase<Day13Part1.Manual, List<Day13Part1.Dot>>() {

    override val day = 13
    override val part = 1

    data class Dot(val x: Int, val y: Int)

    sealed class Fold {
        data class Left(val x: Int) : Fold()
        data class Up(val y: Int) : Fold()
    }

    data class Manual(val dots: List<Dot>, val folds: List<Fold>)

    override fun convertInput(input: List<String>): Manual {
        val (folds, dots) = input
            .filter { it.isNotEmpty() }
            .partition { it.startsWith("fold") }

        return Manual(
            dots = dots.map { it.toDot() },
            folds = folds.map { it.toFold() },
        )
    }

    override fun convertOutput(output: List<Dot>) : String {
        return output.size.toString()
    }

    override fun run(input: Manual) : List<Dot> {
        return input.dots.applyFold(input.folds.first())
    }

    private fun List<Dot>.applyFold(fold: Fold) : List<Dot> {
        return this.map { it.applyFold(fold) }.distinct()
    }

    private fun Dot.applyFold(fold: Fold) : Dot {
        return when(fold) {
            is Fold.Left -> if (x < fold.x) this else this.copy(x = 2*fold.x - x)
            is Fold.Up -> if (y < fold.y) this else this.copy(y = 2*fold.y - y)
        }
    }

    private fun String.toDot() : Dot {
        val (x, y) = this.split(",")
        return Dot(
            x = x.toInt(),
            y = y.toInt(),
        )
    }

    private fun String.toFold() : Fold {
        val end = this.split(" ").last()
        val (direction, value) = end.split("=")
        return when (direction) {
            "x" -> Fold.Left(x = value.toInt())
            "y" -> Fold.Up(y = value.toInt())
            else -> error("Unrecognized fold direction $direction")
        }
    }
}
