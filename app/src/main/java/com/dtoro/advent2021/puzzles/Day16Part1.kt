package com.dtoro.advent2021.puzzles

import java.util.*
import kotlin.experimental.and

/**
 * https://adventofcode.com/2021/day/16
 * Packet Decoder
 */
class Day16Part1 : PuzzleBase<Day16Part1.Bits, Day16Part1.Packet>() {

    companion object {
        private const val HEXADECIMAL_RADIX = 16
        private const val VERSION_BIT_LENGTH = 3
        private const val TYPE_BIT_LENGTH = 3
        private const val LITERAL_TYPE = 4
        private const val LITERAL_CHUNK_BIT_LENGTH = 5
        private const val LENGTH_TYPE_ID_0_BIT_LENGTH = 15
        private const val LENGTH_TYPE_ID_1_BIT_LENGTH = 11

        fun Boolean.toInt() : Int {
            return when (this) {
                false -> 0
                true -> 1
            }
        }
    }

    override val day = 16
    override val part = 1

    class Bits(private val bitSet: BitSet, private var length: Int) {
        constructor() : this(BitSet(), 0)

        private var index = 0

        fun read(bitLength: Int): Bits {
            val result = bitSet[index, index+bitLength]
            index += bitLength
            return Bits(result, bitLength)
        }

        fun write(other: Bits) {
            while (other.hasNext()) {
                bitSet[index++] = other.next()
                length = maxOf(index, length)
            }
        }

        fun next(): Boolean {
            return bitSet[index++]
        }

        fun hasNext() : Boolean {
            return index < length
        }

        fun toInt() : Int {
            var result = 0
            (0 until length).forEach { idx ->
                result = result shl 1
                result += bitSet[idx].toInt()
            }
            return result
        }

        override fun toString() : String {
            val sb = StringBuilder()

            var idx = 0
            while (idx < length) {
                sb.append(bitSet[idx++].toInt())
            }

            return sb.toString()
        }
    }

    sealed class Packet(open val version: Int) {
        data class Literal(
            override val version: Int,
            val value: Int,
        ) : Packet(version)

        data class Operator(
            override val version: Int,
            val packets: List<Packet>,
        ) : Packet(version)
    }

    override fun convertInput(input: List<String>): Bits {
        var index = 0
        val bitSet = BitSet()
        input
            .first()
            .map { it.digitToInt(HEXADECIMAL_RADIX).toByte() }
            .forEach { byte ->
                (3 downTo 0).forEach {
                    val mask = (1 shl it).toByte()
                    bitSet[index++] = (byte and mask) > 0
                }
            }
        return Bits(bitSet, length = index)
    }

    override fun convertOutput(output: Packet): String {
        return output.versionSum().toString()
    }

    override fun run(input: Bits): Packet {
        return input.toPacket()
    }

    private fun Packet.versionSum(): Int {
        return version + when (this) {
            is Packet.Operator -> packets.sumOf { it.versionSum() }
            else -> 0
        }
    }

    private fun Bits.toPacket(): Packet {
        val version = read(VERSION_BIT_LENGTH).toInt()
        val type = read(TYPE_BIT_LENGTH).toInt()

        return if (type == LITERAL_TYPE) {
            val literalBits = Bits()

            var hasMoreChunks = true
            while (hasMoreChunks) {
                val chunk = read(LITERAL_CHUNK_BIT_LENGTH)
                hasMoreChunks = chunk.next()
                literalBits.write(chunk)
            }

            Packet.Literal(
                version = version,
                value = literalBits.toInt(),
            )
        } else {
            val lengthType = next()

            val subPackets = if (lengthType) {
                val subPacketCount = read(LENGTH_TYPE_ID_1_BIT_LENGTH).toInt()
                this.toPackets(subPacketCount)
            } else {
                val subPacketBitLength = read(LENGTH_TYPE_ID_0_BIT_LENGTH).toInt()
                read(subPacketBitLength).toPackets()
            }

            Packet.Operator(
                version = version,
                packets = subPackets,
            )
        }
    }

    private fun Bits.toPackets(count: Int): List<Packet> {
        val packets = mutableListOf<Packet>()

        while (packets.size < count) {
            packets.add(this.toPacket())
        }

        return packets
    }

    private fun Bits.toPackets(): List<Packet> {
        val packets = mutableListOf<Packet>()

        while (this.hasNext()) {
            packets.add(this.toPacket())
        }

        return packets
    }
}
