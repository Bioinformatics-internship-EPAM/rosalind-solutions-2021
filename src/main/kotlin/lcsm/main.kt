package lcsm

import java.io.File

fun main() {
    val fileName = readLine()!!
    var motifs = HashSet<String>()

    File(fileName).readText()
        .replace(Regex("\\s"), "")
        .split(Regex(">Rosalind_\\d+"))
        .drop(1)
        .forEach({ inputString ->
            if (motifs.isEmpty()) {
                motifs.add(inputString)
            } else {
                val newMotifs = HashSet<String>()
                motifs.forEach({ motif -> newMotifs.addAll(collectMotifs(motif, inputString)) })
                motifs = newMotifs
            }
        })

    val res = motifs.maxByOrNull({ it.length })
    println(res)
}

fun collectMotifs(s1: String, s2: String): Set<String> {
    val motifs = HashSet<String>()
    val longComSubMatrix = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 || j == 0) {
                longComSubMatrix[i][j] = 0
            } else if (s1[i - 1] == s2[j - 1]) {
                longComSubMatrix[i][j] = longComSubMatrix[i - 1][j - 1] + 1
                if (i == s1.length || j == s2.length) {
                    getMotifFromMatrix(longComSubMatrix, i, j, s1, motifs)
                }
            } else {
                longComSubMatrix[i][j] = 0
                if (longComSubMatrix[i - 1][j - 1] > 0) {
                    getMotifFromMatrix(longComSubMatrix, i - 1, j - 1, s1, motifs)
                }
            }
        }
    }
    return motifs
}

private fun getMotifFromMatrix(
    longComSubMatrix: Array<IntArray>,
    i: Int,
    j: Int,
    s1: String,
    motifs: HashSet<String>
) {
    val motif = StringBuilder()
    for (k in 0..longComSubMatrix[i - 1][j - 1]) {
        motif.append(s1[i - 1 - longComSubMatrix[i - 1][j - 1] + k])
    }
    motifs.add(motif.toString())
}
