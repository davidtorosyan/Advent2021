package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/14
 * Extended Polymerization
 */
class Day14Part2 : PuzzleBase<Day14Part2.Template, Day14Part2.Polymer>() {

    companion object {
        private const val STEPS = 40
    }

    override val day = 14
    override val part = 2

    data class Base(val char: Char) {
        override fun toString() = char.toString()
    }

    data class BasePair(val first: Base, val second: Base) {
        override fun toString() = first.toString() + second.toString()
    }

    data class Polymer(val start: Base, val end: Base, val pairs: Map<BasePair, Long>)

    data class Template(val polymer: Polymer, val rules: Map<BasePair, Base>)

    override fun convertInput(input: List<String>): Template {
        return Template(
            polymer = input.first().toPolymer(),
            rules = input.drop(2).map { it.toRule() }.toMap()
        )
    }

    override fun convertOutput(output: Polymer) : String {
        val count = output.count()
        val min = count.values.minOrNull() ?: error("no counts!")
        val max = count.values.maxOrNull() ?: error("no counts!")
        val result = max - min
        return result.toString()
    }

    override fun run(input: Template) : Polymer {
        return (1 .. STEPS).fold(initial = input.polymer) { acc, _ ->
            acc.next(input.rules)
        }
    }

    private fun Polymer.count() : Map<Base, Long> {
        return pairs.map {
            listOf(
                it.key.first to it.value,
                it.key.second to it.value,
            )
        }
            .flatten()
            .groupBy({ it.first }) { it.second }
            .mapValues {
                val startOrEnd = it.key in listOf(start, end)
                val sum = it.value.sum() + if (startOrEnd) { 1 } else { 0 }
                sum / 2
            }
    }

    private fun String.toPolymer() : Polymer {
        val pairs = indices.drop(1).map { index ->
            BasePair(
                first = Base(char = this[index-1]),
                second = Base(char = this[index]),
            )
        }
            .groupBy { it }
            .mapValues { it.value.count().toLong() }
            .toMap()

        return Polymer(
            start = Base(char = this.first()),
            end = Base(char = this.last()),
            pairs = pairs,
        )
    }

    private fun String.toRule(): Pair<BasePair, Base> {
        val (pair, insert) = this.split(" -> ")
        return Pair(
            BasePair(
                first = Base(char = pair.first()),
                second = Base(char = pair.last()),
            ),
            Base(char = insert.single())
        )
    }

    private fun Polymer.next(rules: Map<BasePair, Base>) : Polymer {
        return this.copy(
            pairs = pairs.map { (pair, count) ->
                rules[pair]
                    ?.let { pair.applyRule(it) }
                    ?.let { (result1, result2) ->
                        listOf(
                            result1 to count,
                            result2 to count,
                        )
                    }
                    ?: listOf(pair to count)
                }
                .flatten()
                .groupBy({ it.first }) { it.second }
                .mapValues { it.value.sum() })
    }

    private fun BasePair.applyRule(base: Base) : Pair<BasePair, BasePair> {
        return Pair(
            this.copy(second = base),
            this.copy(first = base),
        )
    }
}
