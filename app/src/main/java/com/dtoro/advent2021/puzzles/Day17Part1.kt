package com.dtoro.advent2021.puzzles

import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.sqrt

/**
 * https://adventofcode.com/2021/day/17
 * Trick Shot
 */
class Day17Part1 : PuzzleBase<Day17Part1.TargetArea, Int>() {

    override val day = 17
    override val part = 1

    data class TargetRange(
        val min: Int,
        val max: Int,
    )

    data class TargetArea(
        val x: TargetRange,
        val y: TargetRange,
    )

    override fun convertInput(input: List<String>): TargetArea {
        return input.first().toTargetArea()
    }

    override fun convertOutput(output: Int): String {
        return output.toString()
    }

    override fun run(input: TargetArea): Int {
        if (input.y.min >= 0) {
            error("Don't know how to compute for min.y >= 0")
        }

        val upVelocity = abs(input.y.min) - 1
        val verticalSteps = upVelocity * 2 + 1
        val horizontalSteps = invertCompoundSum(input.x.min)

        if (verticalSteps < horizontalSteps) {
            error("Don't know how to compute when x is closer than y")
        }

        return compoundSum(upVelocity)
    }

    private fun compoundSum(steps: Int) : Int {
        return steps * (steps + 1) / 2
    }

    private fun invertCompoundSum(target: Int) : Int {
        return ((sqrt(8.0 * target) - 1) / 2).roundToInt()
    }

    private fun String.toTargetArea() : TargetArea {
        val (x, y) = split(", ")
        return TargetArea(
            x = x.toTargetRange(),
            y = y.toTargetRange(),
        )
    }

    private fun String.toTargetRange() : TargetRange {
        val (_, range) = split("=")
        val (min, max) = range.split("..")
        return TargetRange(
            min = min.toInt(),
            max = max.toInt(),
        )
    }
}
