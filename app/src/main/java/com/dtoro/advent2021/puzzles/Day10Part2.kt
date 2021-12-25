package com.dtoro.advent2021.puzzles

import java.util.*

/**
 * https://adventofcode.com/2021/day/10
 * Syntax Scoring
 */
class Day10Part2 : SimplePuzzleBase<String, List<List<Day10Part2.Bracket>>>() {

    override val day = 10
    override val part = 2

    companion object {

        private const val multiplier = 5L

        private val brackets = listOf(
            Bracket('(', ')', 1),
            Bracket('[', ']', 2),
            Bracket('{', '}', 3),
            Bracket('<', '>', 4),
        )

        private val lookup = brackets
            .map { listOf(
                it.open to it,
                it.close to it,
            ) }
            .flatten()
            .toMap()
    }

    data class Bracket(
        val open: Char,
        val close: Char,
        val points: Long,
    )

    override fun convertInput(input: String) = input

    override fun convertOutput(output: List<List<Bracket>>) : String {
        return output
            .map { it.computeScore() }
            .median()
            .toString()
    }

    override fun run(input: List<String>) : List<List<Bracket>> {
        return input.mapNotNull { it.findClosingBrackets() }
    }

    private fun String.findClosingBrackets() : List<Bracket>? {
        val stack = ArrayDeque<Bracket>()
        for (char in this) {
            val bracket = lookup.getValue(char)
            if (char == bracket.open) {
                stack.push(bracket)
            } else {
                when (stack.pollFirst()) {
                    null -> return null // improperly closed
                    bracket -> Unit // correct
                    else -> return null // corrupt
                }
            }
        }
        if (stack.isEmpty()) {
            return null // correct
        }
        return stack.toList()
    }

    private fun List<Bracket>.computeScore() : Long {
        return this.fold(initial = 0L, operation = { acc, bracket ->
            acc * multiplier + bracket.points
        })
    }

    private fun <T : Comparable<T>> List<T>.median() : T {
        val sorted = this.sorted()
        return sorted[sorted.size / 2]
    }
}
