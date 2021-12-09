package com.dtoro.advent2021.puzzles

import org.junit.Assert
import org.junit.Test

class PuzzleTest {

    @Test
    fun `Day1Part1 sample`() {
        Assert.assertEquals(
            "7", Day1Part1().runForInput(
                listOf(
                    "199",
                    "200",
                    "208",
                    "210",
                    "200",
                    "207",
                    "240",
                    "269",
                    "260",
                    "263",
                )
            )
        )
    }

    @Test
    fun `Day1Part1 puzzle`() {
        Day1Part1().test()
    }

    @Test
    fun `Day1Part2 sample`() {
        Assert.assertEquals(
            "5", Day1Part2().runForInput(
                listOf(
                    "607",
                    "618",
                    "618",
                    "617",
                    "647",
                    "716",
                    "769",
                    "792",
                )
            )
        )
    }

    @Test
    fun `Day1Part2 puzzle`() {
        Day1Part2().test()
    }

    @Test
    fun `Day2Part1 sample`() {
        Assert.assertEquals(
            "150", Day2Part1().runForInput(
                listOf(
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2",
                )
            )
        )
    }

    @Test
    fun `Day2Part1 puzzle`() {
        Day2Part1().test()
    }

    @Test
    fun `Day2Part2 sample`() {
        Assert.assertEquals(
            "900", Day2Part2().runForInput(
                listOf(
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2",
                )
            )
        )
    }

    @Test
    fun `Day2Part2 puzzle`() {
        Day2Part2().test()
    }

    @Test
    fun `Day3Part1 sample`() {
        Assert.assertEquals(
            "198", Day3Part1().runForInput(
                listOf(
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010",
                )
            )
        )
    }

    @Test
    fun `Day3Part1 puzzle`() {
        Day3Part1().test()
    }

    @Test
    fun `Day3Part2 sample`() {
        Assert.assertEquals(
            "230", Day3Part2().runForInput(
                listOf(
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010",
                )
            )
        )
    }

    @Test
    fun `Day3Part2 puzzle`() {
        Day3Part2().test()
    }

    @Test
    fun `Day4Part1 sample`() {
        Assert.assertEquals(
            "4512", Day4Part1().runForInput(
                """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7""".lines()
            )
        )
    }

    @Test
    fun `Day4Part1 puzzle`() {
        Day4Part1().test()
    }

    @Test
    fun `Day4Part2 sample`() {
        Assert.assertEquals(
            "1924", Day4Part2().runForInput(
                """7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7""".lines()
            )
        )
    }

    @Test
    fun `Day4Part2 puzzle`() {
        Day4Part2().test()
    }

    @Test
    fun `Day5Part1 sample`() {
        Assert.assertEquals(
            "5", Day5Part1().runForInput(
                """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2""".lines()
            )
        )
    }

    @Test
    fun `Day5Part1 puzzle`() {
        Day5Part1().test()
    }

    @Test
    fun `Day5Part2 sample`() {
        Assert.assertEquals(
            "12", Day5Part2().runForInput(
                """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2""".lines()
            )
        )
    }

    @Test
    fun `Day5Part2 puzzle`() {
        Day5Part2().test()
    }

    @Test
    fun `Day6Part1 sample`() {
        Assert.assertEquals(
            "5934", Day6Part1().runForInput(
                """3,4,3,1,2""".lines()
            )
        )
    }

    @Test
    fun `Day6Part1 puzzle`() {
        Day6Part1().test()
    }

    @Test
    fun `Day6Part2 sample`() {
        Assert.assertEquals(
            "26984457539", Day6Part2().runForInput(
                """3,4,3,1,2""".lines()
            )
        )
    }

    @Test
    fun `Day6Part2 puzzle`() {
        Day6Part2().test()
    }

    @Test
    fun `Day7Part1 sample`() {
        Assert.assertEquals(
            "37", Day7Part1().runForInput(
                """16,1,2,0,4,2,7,1,2,14""".lines()
            )
        )
    }

    @Test
    fun `Day7Part1 puzzle`() {
        Day7Part1().test()
    }

    @Test
    fun `Day7Part2 sample`() {
        Assert.assertEquals(
            "168", Day7Part2().runForInput(
                """16,1,2,0,4,2,7,1,2,14""".lines()
            )
        )
    }

    @Test
    fun `Day7Part2 puzzle`() {
        Day7Part2().test()
    }

    @Test
    fun `Day8Part1 sample`() {
        Assert.assertEquals(
            "26", Day8Part1().runForInput(
                """be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce""".lines()
            )
        )
    }

    @Test
    fun `Day8Part1 puzzle`() {
        Day8Part1().test()
    }

    @Test
    fun `Day8Part2 sample`() {
        Assert.assertEquals(
            "61229", Day8Part2().runForInput(
                """be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce""".lines()
            )
        )
    }

    @Test
    fun `Day8Part2 puzzle`() {
        Day8Part2().test()
    }

    @Test
    fun `Day8Part2Generic sample`() {
        Assert.assertEquals(
            "61229", Day8Part2Generic().runForInput(
                """be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce""".lines()
            )
        )
    }

    @Test
    fun `Day8Part2Generic puzzle`() {
        Day8Part2Generic().test()
    }

    private fun <T,K> PuzzleBase<T,K>.test() {
        println("$this: ${run()}")
    }
}
