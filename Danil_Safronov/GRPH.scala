import GC.splitFile

object GRPH {
  def main(args: Array[String]) {
    for (lines <- edges("rosalind_grph.txt", 3)) println(lines._1._1 + " " + lines._2._1)
  }

  def edges(filename: String, n: Int) = {
    val dataset = splitFile(filename)

    { for {iline <- dataset; jline <- dataset if (iline != jline) && (iline._2.takeRight(n) == jline._2.take(n))} yield (iline, jline) }
  }
}
