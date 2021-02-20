package subs

fun main() {
    val s = readLine()!!
    val t = readLine()!!

    val res = ArrayList<Int>()
    while (true) {
        val element = s.indexOf(t, res.lastOrNull() ?: 0)
        if (element >= 0) res.add(element + 1) else break
    }
    println(res.joinToString(" "))
}
