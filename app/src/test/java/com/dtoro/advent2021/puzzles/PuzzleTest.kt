package com.dtoro.advent2021.puzzles

import org.junit.Assert
import org.junit.Test

class PuzzleTest {

    @Test
    fun `Day01Part1 sample`() {
        Assert.assertEquals(
            "7", Day01Part1().runForInput(
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
    fun `Day01Part1 puzzle`() {
        Day01Part1().test()
    }

    @Test
    fun `Day01Part2 sample`() {
        Assert.assertEquals(
            "5", Day01Part2().runForInput(
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
    fun `Day01Part2 puzzle`() {
        Day01Part2().test()
    }

    @Test
    fun `Day02Part1 sample`() {
        Assert.assertEquals(
            "150", Day02Part1().runForInput(
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
    fun `Day02Part1 puzzle`() {
        Day02Part1().test()
    }

    @Test
    fun `Day02Part2 sample`() {
        Assert.assertEquals(
            "900", Day02Part2().runForInput(
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
    fun `Day02Part2 puzzle`() {
        Day02Part2().test()
    }

    @Test
    fun `Day03Part1 sample`() {
        Assert.assertEquals(
            "198", Day03Part1().runForInput(
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
    fun `Day03Part1 puzzle`() {
        Day03Part1().test()
    }

    @Test
    fun `Day03Part2 sample`() {
        Assert.assertEquals(
            "230", Day03Part2().runForInput(
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
    fun `Day03Part2 puzzle`() {
        Day03Part2().test()
    }

    @Test
    fun `Day04Part1 sample`() {
        Assert.assertEquals(
            "4512", Day04Part1().runForInput(
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
    fun `Day04Part1 puzzle`() {
        Day04Part1().test()
    }

    @Test
    fun `Day04Part2 sample`() {
        Assert.assertEquals(
            "1924", Day04Part2().runForInput(
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
    fun `Day04Part2 puzzle`() {
        Day04Part2().test()
    }

    @Test
    fun `Day05Part1 sample`() {
        Assert.assertEquals(
            "5", Day05Part1().runForInput(
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
    fun `Day05Part1 puzzle`() {
        Day05Part1().test()
    }

    @Test
    fun `Day05Part2 sample`() {
        Assert.assertEquals(
            "12", Day05Part2().runForInput(
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
    fun `Day05Part2 puzzle`() {
        Day05Part2().test()
    }

    @Test
    fun `Day06Part1 sample`() {
        Assert.assertEquals(
            "5934", Day06Part1().runForInput(
                """3,4,3,1,2""".lines()
            )
        )
    }

    @Test
    fun `Day06Part1 puzzle`() {
        Day06Part1().test()
    }

    @Test
    fun `Day06Part2 sample`() {
        Assert.assertEquals(
            "26984457539", Day06Part2().runForInput(
                """3,4,3,1,2""".lines()
            )
        )
    }

    @Test
    fun `Day06Part2 puzzle`() {
        Day06Part2().test()
    }

    @Test
    fun `Day07Part1 sample`() {
        Assert.assertEquals(
            "37", Day07Part1().runForInput(
                """16,1,2,0,4,2,7,1,2,14""".lines()
            )
        )
    }

    @Test
    fun `Day07Part1 puzzle`() {
        Day07Part1().test()
    }

    @Test
    fun `Day07Part2 sample`() {
        Assert.assertEquals(
            "168", Day07Part2().runForInput(
                """16,1,2,0,4,2,7,1,2,14""".lines()
            )
        )
    }

    @Test
    fun `Day07Part2 puzzle`() {
        Day07Part2().test()
    }

    @Test
    fun `Day08Part1 sample`() {
        Assert.assertEquals(
            "26", Day08Part1().runForInput(
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
    fun `Day08Part1 puzzle`() {
        Day08Part1().test()
    }

    @Test
    fun `Day08Part2 sample`() {
        Assert.assertEquals(
            "61229", Day08Part2().runForInput(
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
    fun `Day08Part2 puzzle`() {
        Day08Part2().test()
    }

    @Test
    fun `Day08Part2Generic sample`() {
        Assert.assertEquals(
            "61229", Day08Part2Generic().runForInput(
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
    fun `Day08Part2Generic puzzle`() {
        Day08Part2Generic().test()
    }

    @Test
    fun `Day09Part1 sample`() {
        Assert.assertEquals(
            "15", Day09Part1().runForInput(
                """2199943210
3987894921
9856789892
8767896789
9899965678""".lines()
            )
        )
    }

    @Test
    fun `Day09Part1 puzzle`() {
        Day09Part1().test()
    }

    @Test
    fun `Day09Part2 sample`() {
        Assert.assertEquals(
            "1134", Day09Part2().runForInput(
                """2199943210
3987894921
9856789892
8767896789
9899965678""".lines()
            )
        )
    }

    @Test
    fun `Day09Part2 puzzle`() {
        Day09Part2().test()
    }

    @Test
    fun `Day10Part1 sample`() {
        Assert.assertEquals(
            "26397", Day10Part1().runForInput(
                """[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]""".lines()
            )
        )
    }

    @Test
    fun `Day10Part1 puzzle`() {
        Day10Part1().test()
    }

    @Test
    fun `Day10Part2 sample`() {
        Assert.assertEquals(
            "288957", Day10Part2().runForInput(
                """[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]""".lines()
            )
        )
    }

    @Test
    fun `Day10Part2 puzzle`() {
        Day10Part2().test()
    }

    @Test
    fun `Day11Part1 sample`() {
        Assert.assertEquals(
            "1656", Day11Part1().runForInput(
                """5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526""".lines()
            )
        )
    }

    @Test
    fun `Day11Part1 puzzle`() {
        Day11Part1().test()
    }

    @Test
    fun `Day11Part2 sample`() {
        Assert.assertEquals(
            "195", Day11Part2().runForInput(
                """5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526""".lines()
            )
        )
    }

    @Test
    fun `Day11Part2 puzzle`() {
        Day11Part2().test()
    }

    @Test
    fun `Day12Part1 sample 1`() {
        Assert.assertEquals(
            "10", Day12Part1().runForInput(
                """start-A
start-b
A-c
A-b
b-d
A-end
b-end""".lines()
            )
        )
    }

    @Test
    fun `Day12Part1 sample 2`() {
        Assert.assertEquals(
            "19", Day12Part1().runForInput(
                """dc-end
HN-start
start-kj
dc-start
dc-HN
LN-dc
HN-end
kj-sa
kj-HN
kj-dc""".lines()
            )
        )
    }

    @Test
    fun `Day12Part1 sample 3`() {
        Assert.assertEquals(
            "226", Day12Part1().runForInput(
                """fs-end
he-DX
fs-he
start-DX
pj-DX
end-zg
zg-sl
zg-pj
pj-he
RW-he
fs-DX
pj-RW
zg-RW
start-pj
he-WI
zg-he
pj-fs
start-RW""".lines()
            )
        )
    }

    @Test
    fun `Day12Part1 puzzle`() {
        Day12Part1().test()
    }

    @Test
    fun `Day12Part2 sample 1`() {
        Assert.assertEquals(
            "36", Day12Part2().runForInput(
                """start-A
start-b
A-c
A-b
b-d
A-end
b-end""".lines()
            )
        )
    }

    @Test
    fun `Day12Part2 sample 2`() {
        Assert.assertEquals(
            "103", Day12Part2().runForInput(
                """dc-end
HN-start
start-kj
dc-start
dc-HN
LN-dc
HN-end
kj-sa
kj-HN
kj-dc""".lines()
            )
        )
    }

    @Test
    fun `Day12Part2 sample 3`() {
        Assert.assertEquals(
            "3509", Day12Part2().runForInput(
                """fs-end
he-DX
fs-he
start-DX
pj-DX
end-zg
zg-sl
zg-pj
pj-he
RW-he
fs-DX
pj-RW
zg-RW
start-pj
he-WI
zg-he
pj-fs
start-RW""".lines()
            )
        )
    }

    @Test
    fun `Day12Part2 puzzle`() {
        Day12Part2().test()
    }

    @Test
    fun `Day13Part1 sample`() {
        Assert.assertEquals(
            "17", Day13Part1().runForInput(
                """6,10
0,14
9,10
0,3
10,4
4,11
6,0
6,12
4,1
0,13
10,12
3,4
3,0
8,4
1,10
2,14
8,10
9,0

fold along y=7
fold along x=5""".lines()
            )
        )
    }

    @Test
    fun `Day13Part1 puzzle`() {
        Day13Part1().test()
    }

    @Test
    fun `Day13Part2 puzzle`() {
        Day13Part2().test()
    }

    @Test
    fun `Day14Part1 sample`() {
        Assert.assertEquals(
            "1588", Day14Part1().runForInput(
                """NNCB

CH -> B
HH -> N
CB -> H
NH -> C
HB -> C
HC -> B
HN -> C
NN -> C
BH -> H
NC -> B
NB -> B
BN -> B
BB -> N
BC -> B
CC -> N
CN -> C""".lines()
            )
        )
    }

    @Test
    fun `Day14Part1 puzzle`() {
        Day14Part1().test()
    }

    @Test
    fun `Day14Part2 sample`() {
        Assert.assertEquals(
            "2188189693529", Day14Part2().runForInput(
                """NNCB

CH -> B
HH -> N
CB -> H
NH -> C
HB -> C
HC -> B
HN -> C
NN -> C
BH -> H
NC -> B
NB -> B
BN -> B
BB -> N
BC -> B
CC -> N
CN -> C""".lines()
            )
        )
    }

    @Test
    fun `Day14Part2 puzzle`() {
        Day14Part2().test()
    }

    @Test
    fun `Day15Part1 sample`() {
        Assert.assertEquals(
            "40", Day15Part1().runForInput(
                """1163751742
1381373672
2136511328
3694931569
7463417111
1319128137
1359912421
3125421639
1293138521
2311944581""".lines()
            )
        )
    }

    @Test
    fun `Day15Part1 puzzle`() {
        Day15Part1().test()
    }

    @Test
    fun `Day15Part2 sample`() {
        Assert.assertEquals(
            "315", Day15Part2().runForInput(
                """1163751742
1381373672
2136511328
3694931569
7463417111
1319128137
1359912421
3125421639
1293138521
2311944581""".lines()
            )
        )
    }

    @Test
    fun `Day15Part2 puzzle`() {
        Day15Part2().test()
    }

    @Test
    fun `Day16Part1 sample`() {
        Assert.assertEquals("16", Day16Part1().runForInput("8A004A801A8002F478".lines()))
        Assert.assertEquals("12", Day16Part1().runForInput("620080001611562C8802118E34".lines()))
        Assert.assertEquals("23", Day16Part1().runForInput("C0015000016115A2E0802F182340".lines()))
        Assert.assertEquals("31", Day16Part1().runForInput("A0016C880162017C3686B18A3D4780".lines()))

    }

    @Test
    fun `Day16Part1 puzzle`() {
        Day16Part1().test()
    }

    @Test
    fun `Day16Part2 sample`() {
        Assert.assertEquals("3", Day16Part2().runForInput("C200B40A82".lines()))
        Assert.assertEquals("54", Day16Part2().runForInput("04005AC33890".lines()))
        Assert.assertEquals("7", Day16Part2().runForInput("880086C3E88112".lines()))
        Assert.assertEquals("9", Day16Part2().runForInput("CE00C43D881120".lines()))
        Assert.assertEquals("1", Day16Part2().runForInput("D8005AC2A8F0".lines()))
        Assert.assertEquals("0", Day16Part2().runForInput("F600BC2D8F".lines()))
        Assert.assertEquals("0", Day16Part2().runForInput("9C005AC2F8F0".lines()))
        Assert.assertEquals("1", Day16Part2().runForInput("9C0141080250320F1802104A08".lines()))
    }

    @Test
    fun `Day16Part2 puzzle`() {
        Day16Part2().test()
    }

    @Test
    fun `Day17Part1 sample`() {
        Assert.assertEquals("45", Day17Part1().runForInput("target area: x=20..30, y=-10..-5".lines()))
    }

    @Test
    fun `Day17Part1 puzzle`() {
        Day17Part1().test()
    }

    @Test
    fun `Day17Part2 sample`() {
        Assert.assertEquals("112", Day17Part2().runForInput("target area: x=20..30, y=-10..-5".lines()))
    }

    @Test
    fun `Day17Part2 puzzle`() {
        Day17Part2().test()
    }

    private fun <T,K> PuzzleBase<T,K>.test() {
        println("$this: ${run()}")
    }
}
