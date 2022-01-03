package com.dtoro.advent2021.puzzles

import kotlin.math.*

/**
 * https://adventofcode.com/2021/day/17
 * Trick Shot
 */
class Day17Part2 : PuzzleBase<Day17Part2.TargetArea, Int>() {

    override val day = 17
    override val part = 2

    data class TargetRange(
        val min: Int,
        val max: Int,
    ) {
        val range = (min .. max)
    }

    data class TargetArea(
        val x: TargetRange,
        val y: TargetRange,
    )

    data class Velocity(
        val x: Int,
        val y: Int,
    )

    data class Position(
        val x: Int,
        val y: Int,
    )

    class Ball(initialVelocity: Velocity) {
        private var position = Position(x = 0, y = 0)
        private var velocity = initialVelocity

        fun step() {
            position = position.move(velocity)
            velocity = velocity.next()
        }

        fun within(target: TargetArea): Boolean {
            return position.x in target.x.range && position.y in target.y.range
        }

        fun outOfBounds(target: TargetArea): Boolean {
            return position.x > target.x.max ||
                    position.y < target.y.min ||
                    (position.x < target.x.min && velocity.x == 0)
        }

        private fun Position.move(velocity: Velocity): Position {
            return Position(
                x = x + velocity.x,
                y = y + velocity.y,
            )
        }

        private fun Velocity.next() : Velocity {
            return Velocity(
                x = max(0, x - 1),
                y = y - 1,
            )
        }
    }

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

        return (0..input.x.max).map { x ->
            (input.y.min .. abs(input.y.min)-1).map { y ->
                Velocity(x, y)
            }
        }
            .flatten()
            .count { fire(velocity = it, target = input) }
    }

    private fun fire(velocity: Velocity, target: TargetArea): Boolean {
        val ball = Ball(velocity)
        while (!ball.outOfBounds(target)) {
            if (ball.within(target)) {
                return true
            }
            ball.step()
        }
        return false
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
