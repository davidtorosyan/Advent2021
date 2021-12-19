package com.dtoro.advent2021.puzzles

import kotlin.math.sign

/**
 * https://adventofcode.com/2021/day/8
 * Seven Segment Search
 */
class Day08Part2Generic : SimplePuzzleBase<Day08Part2Generic.Entry, List<Int>>() {

    override val day = 8
    override val part = 2

    companion object {
        private val segments = mapOf(
            0 to "abcefg".toSignal(),
            1 to "cf".toSignal(),
            2 to "acdeg".toSignal(),
            3 to "acdfg".toSignal(),
            4 to "bcdf".toSignal(),
            5 to "abdfg".toSignal(),
            6 to "abdefg".toSignal(),
            7 to "acf".toSignal(),
            8 to "abcdefg".toSignal(),
            9 to "abcdfg".toSignal(),
        )

        private fun String.toSignal() : Signal {
            return Signal(active = toSet())
        }

        private val emptySignal = Signal(active = emptySet())

        private fun Signal.minus(other: Signal) : Int {
            return (this.active - other.active).size
        }
    }

    data class Signal(val active: Set<Char>)

    data class Entry(val signals: List<Signal>, val output: List<Signal>)

    data class Signature(val value: Int, val target: Int?, val difference: Int)

    override fun convertInput(input: String): Entry {
        val (signals, output) = input.split("|")

        fun String.toSignals() : List<Signal> {
            return this
                .split(" ")
                .filter { it.isNotEmpty() }
                .map { Signal(active = it.toSet()) }
        }

        return Entry(
            signals = signals.toSignals(),
            output = output.toSignals(),
        )
    }

    override fun convertOutput(output: List<Int>) = output.sum().toString()

    override fun run(input: List<Entry>) : List<Int> {
        val strategy = segments.findStrategy()
        return input.map { it.decode(strategy) }
    }

    private fun Entry.decode(strategy: List<Signature>) : Int {
        val mapping = signals.findMapping(strategy)
        return output
            .map { mapping[it] }
            .joinToString(separator = "")
            .toInt()
    }

    private fun Map<Int, Signal>.findStrategy() : List<Signature> {
        if (values.distinct().size != values.size) {
            error("Cannot find a strategy with duplicate signals")
        }

        val strategy = mutableListOf<Signature>()
        val known = mutableListOf<Int?>(null)
        val unknown = keys.toMutableList()

        fun Int?.signal() = this?.let { getValue(it) } ?: emptySignal

        while (unknown.isNotEmpty()) {
            val currentlyKnown = known.toList()
            currentlyKnown.forEach { k ->
                val knownSignal = k.signal()
                val found = unknown
                    .asSequence()
                    .map { u -> u to u.signal().minus(knownSignal) }
                    .groupBy({ (_, difference) -> difference }) { (value, _) -> value}
                    .filter { (_, values) -> values.size == 1 }
                    .map {(difference, values) ->
                        val value = values.single()
                        Signature(
                            value = value,
                            target = k,
                            difference = difference,
                        )
                    }
                    .sortedBy { it.value }
                    .toList()

                val foundValues = found.map { it.value }
                known.addAll(foundValues)
                unknown.removeAll(foundValues)
                strategy.addAll(found)
            }

            if (known.size == currentlyKnown.size) {
                error("No strategy found!")
            }
        }

        return strategy
    }

    private fun List<Signal>.findMapping(strategy: List<Signature>) : Map<Signal, Int> {
        if (segments.values != this.toSet()) {
            error("Mismatched segments and inputs!")
        }

        val discovered = mutableMapOf<Int?, Signal>(
            null to emptySignal
        )
        val unknown = toMutableList()
        strategy.forEach { signature ->
            val targetSignal = discovered.getValue(signature.target)
            val candidates = unknown.filter { it.minus(targetSignal) == signature.difference }
            val signal = candidates.single()
            discovered[signature.value] = signal
            unknown.remove(signal)
        }
        return discovered
            .mapNotNull { (value, signal) -> value?.let{ signal to value } }
            .toMap()
    }
}
