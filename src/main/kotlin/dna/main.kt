package dna

fun main() {
    val s = readLine()!!
    val res = s.groupingBy({ it }).eachCount()
    println("${res['A'] ?: 0} ${res['C'] ?: 0} ${res['G'] ?: 0} ${res['T'] ?: 0}")
}
