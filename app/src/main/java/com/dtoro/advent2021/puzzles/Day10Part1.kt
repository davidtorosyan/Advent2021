package com.dtoro.advent2021.puzzles

import java.util.*

/**
 * https://adventofcode.com/2021/day/10
 * Syntax Scoring
 */
class Day10Part1 : SimplePuzzleBase<String, List<Day10Part1.Bracket>>() {

    override val day = 10
    override val part = 1

    companion object {
        private val brackets = listOf(
            Bracket('(', ')', 3),
            Bracket('[', ']', 57),
            Bracket('{', '}', 1197),
            Bracket('<', '>', 25137),
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
        val points: Int,
    )

    override fun convertInput(input: String) = input

    override fun convertOutput(output: List<Bracket>) : String {
        return output
            .map { it.points }
            .sum()
            .toString()
    }

    override fun run(input: List<String>) : List<Bracket> {
        return input.mapNotNull { it.findIllegalBracket() }
    }

    private fun String.findIllegalBracket() : Bracket? {
        val stack = ArrayDeque<Bracket>()
        for (char in this) {
            val bracket = lookup.getValue(char)
            if (char == bracket.open) {
                stack.push(bracket)
            } else {
                when (stack.pollFirst()) {
                    null -> return null // improperly closed
                    bracket -> Unit // correct
                    else -> return bracket // corrupt
                }
            }
        }
        return null // either correct or incomplete
    }
}
