package prot

fun main() {
    val codons = mapOf(
        "UUU" to "F", "CUU" to "L", "AUU" to "I", "GUU" to "V",
        "UUC" to "F", "CUC" to "L", "AUC" to "I", "GUC" to "V",
        "UUA" to "L", "CUA" to "L", "AUA" to "I", "GUA" to "V",
        "UUG" to "L", "CUG" to "L", "AUG" to "M", "GUG" to "V",
        "UCU" to "S", "CCU" to "P", "ACU" to "T", "GCU" to "A",
        "UCC" to "S", "CCC" to "P", "ACC" to "T", "GCC" to "A",
        "UCA" to "S", "CCA" to "P", "ACA" to "T", "GCA" to "A",
        "UCG" to "S", "CCG" to "P", "ACG" to "T", "GCG" to "A",
        "UAU" to "Y", "CAU" to "H", "AAU" to "N", "GAU" to "D",
        "UAC" to "Y", "CAC" to "H", "AAC" to "N", "GAC" to "D",
        "UAA" to "", "CAA" to "Q", "AAA" to "K", "GAA" to "E",
        "UAG" to "", "CAG" to "Q", "AAG" to "K", "GAG" to "E",
        "UGU" to "C", "CGU" to "R", "AGU" to "S", "GGU" to "G",
        "UGC" to "C", "CGC" to "R", "AGC" to "S", "GGC" to "G",
        "UGA" to "", "CGA" to "R", "AGA" to "R", "GGA" to "G",
        "UGG" to "W", "CGG" to "R", "AGG" to "R", "GGG" to "G"
    )

    val s = readLine()!!
    val res = s.chunked(3, { codons[it] }).joinToString("")
    println(res)
}
