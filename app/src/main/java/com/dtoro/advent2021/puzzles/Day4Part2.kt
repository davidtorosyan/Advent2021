package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/4
 * Giant Squid
 */
class Day4Part2 : PuzzleBase<Day4Part2.Bingo, Day4Part2.Winner>() {

    override val day = 4
    override val part = 2

    companion object {
        private const val boardSize = 5
    }

    data class Bingo(val numbers: List<Int>, val boards: List<Board>)

    data class Board(
        val grid: List<List<Space>>,
        val index: Map<Int, Space>,
        val transposed: List<List<Space>>,
    ) {
        companion object {
            fun fromGrid(input: List<List<Int>>) : Board {
                val index = mutableMapOf<Int, Space>()
                val grid = input.map { line ->
                    line.map { num ->
                        Space(num).also {
                            index[num] = it
                        }
                    }
                }
                return Board(
                    grid = grid,
                    index = index,
                    transposed = transpose(grid),
                )
            }

            private fun <T> transpose(grid: List<List<T>>) : List<List<T>> {
                val output = mutableListOf<List<T>>()
                for (index in grid.first().indices) {
                    output.add(grid.map { row -> row[index] })
                }
                return output
            }
        }
    }

    data class Space(val number: Int, var marked: Boolean = false)

    data class Winner(val board: Board, val lastNumber: Int)

    override fun convertInput(input: List<String>): Bingo {
        val numbers = input
            .first()
            .split(',')
            .map { it.toInt() }
        val boards = input
            .drop(1)
            .chunked(boardSize + 1)
            .map { grid ->
                Board.fromGrid(grid
                    .drop(1)
                    .map { line ->
                        line
                            .split("\\s+".toRegex())
                            .filter { it.isNotBlank() }
                            .map { it.toInt() }
                    })
            }
        return Bingo(numbers = numbers, boards = boards)
    }

    override fun convertOutput(output: Winner): String {
        val sum = output
            .board
            .grid
            .flatten()
            .filter { !it.marked }
            .map { it.number }
            .sum()
        return (sum * output.lastNumber).toString()
    }

    override fun run(input: Bingo) : Winner {
        val candidates = input.boards.toMutableList()
        for (number in input.numbers) {
            for (board in candidates.toList()) {
                board.applyNumber(number)
                if (board.isWinner()) {
                    if (candidates.size == 1) {
                        return Winner(board = board, lastNumber = number)
                    }
                    else {
                        candidates.remove(board)
                    }
                }
            }
        }
        error("No winner found!")
    }

    private fun Board.applyNumber(number : Int) {
        index[number]?.marked = true
    }

    private fun Board.isWinner() : Boolean {
        return grid.anyMarked() ||
            transposed.anyMarked()
    }

    private fun List<List<Space>>.anyMarked() : Boolean {
        return any { it.all { space -> space.marked } }
    }
}
