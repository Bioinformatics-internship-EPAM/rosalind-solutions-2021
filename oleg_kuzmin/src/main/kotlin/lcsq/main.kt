package lcsq

import java.io.File
import kotlin.math.max

fun main() {
    val fileName = readLine()!!

    val input = File(fileName).readText()
    val oneLineInput = input.replace(Regex("\\s"), "")
    val seqArrayInput = oneLineInput.split(Regex(">Rosalind_\\d+")).drop(1)
    val (s1, s2) = seqArrayInput

    println(findSplicedMotif(s1, s2))
}

fun findSplicedMotif(s1: String, s2: String): String {
    val longComSubMatrix = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) {
                longComSubMatrix[i][j] = 0
            } else if (s1[i - 1] == s2[j - 1]) {
                longComSubMatrix[i][j] = longComSubMatrix[i - 1][j - 1] + 1
            } else {
                longComSubMatrix[i][j] = max(longComSubMatrix[i][j - 1], longComSubMatrix[i - 1][j])
            }
        }
    }
    return getSplicedMotifFromMatrix(longComSubMatrix, s1, s2)
}

private fun getSplicedMotifFromMatrix(longComSubMatrix: Array<IntArray>, s1: String, s2: String): String {
    val motif = StringBuilder()
    var i = longComSubMatrix.size - 1
    var j = longComSubMatrix[0].size - 1
    while (i > 0 && j > 0) {
        val cur = longComSubMatrix[i][j]
        val upLeft = longComSubMatrix[i - 1][j - 1]
        if (upLeft + 1 == cur && s1[i - 1] == s2[j - 1]) {
            motif.insert(0, s1[i - 1])
            i--
            j--
        } else if (longComSubMatrix[i - 1][j] > longComSubMatrix[i][j - 1]) {
            i--
        } else {
            j--
        }
    }
    return motif.toString()
}
