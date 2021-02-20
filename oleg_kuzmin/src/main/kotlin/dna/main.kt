package dna

fun main() {
    val s = readLine()!!
    val res = s.groupingBy({ it }).eachCount()
    val output = listOf('A', 'C', 'G', 'T').joinToString(" ", transform = { "${res[it] ?: 0}" })
    println(output)
}
