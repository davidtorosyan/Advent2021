package com.dtoro.advent2021.puzzles

/**
 * https://adventofcode.com/2021/day/6
 * Lanternfish
 */
class Day06Part2 : PuzzleBase<Day06Part2.Fish, Day06Part2.Fish>() {

    override val day = 6
    override val part = 2

    companion object {
        private const val REPRO_DAYS = 7
        private const val ADDITIONAL_DAYS_FOR_NEW = 2
        private const val DEFAULT_SIMULATION_DAYS = 256
    }

    data class Fish(val countsPerDay: List<Long>, val daysLeft: Int)

    override fun convertInput(input: List<String>): Fish {
        val fishCounts = input.first()
        val simulationDays = input.drop(1).firstOrNull()?.toInt() ?: DEFAULT_SIMULATION_DAYS

        val countsPerDay = Array(REPRO_DAYS + ADDITIONAL_DAYS_FOR_NEW) { 0L }
        fishCounts.split(",").map { it.toInt() }.forEach {
            countsPerDay[it]++
        }
        return Fish(
            countsPerDay = countsPerDay.toList(),
            daysLeft = simulationDays,
        )
    }
    override fun convertOutput(output: Fish) : String {
        return output.countsPerDay.sum().toString()
    }

    override fun run(input: Fish) : Fish {
        var fish = input
        while (fish.daysLeft > 0) {
            fish = fish.simulateOneDay()
        }
        return fish
    }

    private fun Fish.simulateOneDay() : Fish {
        val readyToReproduceCount = countsPerDay.first()
        val newList = countsPerDay.drop(1).toMutableList()
        newList.add(readyToReproduceCount)
        newList[REPRO_DAYS - 1] += readyToReproduceCount
        return Fish(countsPerDay = newList, daysLeft = daysLeft - 1)
    }
}
