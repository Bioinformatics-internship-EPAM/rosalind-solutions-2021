package hamm

fun main() {
    val s = readLine()!!
    val t = readLine()!!

    val res = s.zip(t, { a, b -> if (a != b) 1 else 0 }).sumBy({ it })

    println(res)
}
