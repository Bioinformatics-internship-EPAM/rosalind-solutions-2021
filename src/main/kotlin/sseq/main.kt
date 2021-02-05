package sseq

import java.io.File

fun main() {
    val fileName = readLine()!!

    val input = File(fileName).readText()
        .replace(Regex("\\s"), "")
        .split(Regex(">Rosalind_\\d+"))
        .drop(1)
        .toMutableList()
    val (dna, subsequence) = input

    val res = ArrayList<Int>()
    subsequence.forEach({
        val element = dna.indexOf(it, res.lastOrNull() ?: 0)
        res.add(element + 1)
    })
    println(res.joinToString(" "))
}
