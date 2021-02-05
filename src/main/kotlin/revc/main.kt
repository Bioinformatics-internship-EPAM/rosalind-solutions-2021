package revc

fun main() {
    val complements = mapOf(
        'A' to 'T',
        'T' to 'A',
        'C' to 'G',
        'G' to 'C'
    )

    val s = readLine()!!
    val res = s.foldRight(StringBuilder(), { char, acc -> acc.append(complements[char]) })
    println(res)
}
