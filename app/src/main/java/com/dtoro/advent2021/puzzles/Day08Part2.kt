package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/8
 * Seven Segment Search
 */
class Day08Part2 : SimplePuzzleBase<Day08Part2.Entry, List<Int>>() {

    override val day = 8
    override val part = 2

    data class Signal(val active: Set<Char>)

    data class Entry(val signals: List<Signal>, val output: List<Signal>)

    enum class Segment(val value: Int, val length: Int) {
        ZERO(0, 6), // missing segment is missing in (1), (7), present in (4)
        ONE(1, 2), // unique
        TWO(2, 5), // not a subset of 9 or 6
        THREE(3, 5), // subset of 9
        FOUR(4, 4), // unique
        FIVE(5, 5), // subset of 6
        SIX(6, 6), // missing segment is present in (1), (4), (7)
        SEVEN(7, 3), // unique
        EIGHT(8, 7), // unique
        NINE(9, 6), // missing segment is missing in (1), (7), (4)
    }

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
        return input.map { it.decode() }
    }

    private fun Entry.decode() : Int {
        val mapping = signals.findMapping()
        return output
            .map { mapping[it] }
            .joinToString(separator = "")
            .toInt()
    }

    private fun List<Signal>.findMapping() : Map<Signal, Int> {
        val mapping = mutableMapOf<Signal, Int>()
        val lookup = mutableMapOf<Segment, Signal>()

        fun mark(segment: Segment, signal: Signal) {
            mapping[signal] = segment.value
            lookup[segment] = signal
        }

        fun Segment.signal() : Signal {
            return lookup.getValue(this)
        }

        val groups = groupBy { it.active.size }

        fun markByLength(segment: Segment) {
            mark(segment, groups.getValue(segment.length).first())
        }

        listOf(
            Segment.ONE,
            Segment.FOUR,
            Segment.SEVEN,
            Segment.EIGHT,
        ).forEach { markByLength(it) }

        for (signal in groups.getValue(6)) {
            val missingSegment = (Segment.EIGHT.signal().active - signal.active).first()
            val segment = when {
                listOf(Segment.ONE, Segment.FOUR, Segment.SEVEN).all {
                    it.signal().active.contains(missingSegment)
                } -> Segment.SIX
                listOf(Segment.ONE, Segment.FOUR, Segment.SEVEN).all {
                    !it.signal().active.contains(missingSegment)
                } -> Segment.NINE
                else -> Segment.ZERO
            }
            mark(segment, signal)
        }

        for (signal in groups.getValue(5)) {
            val segment = when {
                Segment.SIX.signal().active.containsAll(signal.active) -> Segment.FIVE
                Segment.NINE.signal().active.containsAll(signal.active) -> Segment.THREE
                else -> Segment.TWO
            }
            mark(segment, signal)
        }

        return mapping
    }
}
