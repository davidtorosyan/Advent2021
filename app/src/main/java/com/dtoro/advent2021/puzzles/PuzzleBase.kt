package com.dtoro.advent2021.puzzles

import com.dtoro.advent2021.util.InputFetcher

abstract class PuzzleBase<TInput, TOutput> {

    abstract val day : Int
    abstract val part : Int

    fun run() : String {
        return runForInput(InputFetcher.fetchInputForDay(day))
    }

    fun runForInput(input: List<String>) : String {
        val convertedInput = convertInput(input)
        val result = run(convertedInput)
        return convertOutput(result)
    }

    abstract fun convertInput(input: List<String>) : TInput

    abstract fun convertOutput(output: TOutput) : String

    abstract fun run(input: TInput) : TOutput

    override fun toString(): String {
        return "Day ${day.padLeft()}, part $part"
    }

    private fun Int.padLeft(): String {
        return this.toString().padStart(length = 2, padChar = '0')
    }
}
