package com.dtoro.advent2021.puzzles

abstract class SimplePuzzleBase<TInput, TOutput> : PuzzleBase<List<TInput>, TOutput>() {

    override fun convertInput(input: List<String>): List<TInput> {
        return input.map { convertInput(it) }
    }

    abstract fun convertInput(input: String) : TInput
}
