package sseq

import java.io.File

fun main() {
    val fileName = readLine()!!

    val input = File(fileName).readText()
    val oneLineInput = input.replace(Regex("\\s"), "")
    val seqArrayInput = oneLineInput.split(Regex(">Rosalind_\\d+")).drop(1)
    val (dna, subsequence) = seqArrayInput

    val res = ArrayList<Int>()
    subsequence.forEach({
        val element = dna.indexOf(it, res.lastOrNull() ?: 0)
        res.add(element + 1)
    })
    println(res.joinToString(" "))
}
