package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/2
 */
class Day2Part2 : PuzzleBase<Day2Part2.Command, Day2Part2.Location>() {

    override val day = 2
    override val part = 2

    enum class Direction {
        forward,
        down,
        up;
    }

    data class Command(val direction: Direction, val amount: Int)

    data class Location(val position : Int, val depth : Int, val aim: Int)

    override fun convertInput(input: String): Command {
        val (direction, amount) = input.split(" ", limit = 2)
        return Command(
            direction = Direction.valueOf(direction),
            amount = amount.toInt(),
        )
    }

    override fun convertOutput(output: Location): String {
        return output.run { position * depth }.toString()
    }

    override fun run(input: List<Command>) : Location {
        var location = Location(0, 0, 0)
        for (command in input) {
            location = location.applyCommand(command)
        }
        return location
    }

    private fun Location.applyCommand(command: Command) : Location {
        return when (command.direction) {
            Direction.forward -> copy(
                position = position + command.amount,
                depth = depth + aim * command.amount,
            )
            Direction.down -> copy(aim = aim + command.amount)
            Direction.up -> copy(aim = aim - command.amount)
        }
    }
}
