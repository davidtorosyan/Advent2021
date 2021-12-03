package com.dtoro.advent2021.puzzles

import com.dtoro.advent2021.util.InputFetcher

abstract class PuzzleBase<TInput, TOutput> {

    abstract val day : Int
    abstract val part : Int

    fun run() : String {
        return runForInput(InputFetcher.fetchInputForDay(day))
    }

    fun runForInput(input: List<String>) : String {
        val convertedInput = input.map { convertInput(it) }
        val result = run(convertedInput)
        return convertOutput(result)
    }

    abstract fun convertInput(input: String) : TInput

    abstract fun convertOutput(output: TOutput) : String

    abstract fun run(input: List<TInput>) : TOutput

    override fun toString(): String {
        return "Day $day, part $part"
    }
}
