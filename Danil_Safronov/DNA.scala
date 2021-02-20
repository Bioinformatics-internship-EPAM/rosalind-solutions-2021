import scala.io.StdIn.readLine

object DNA {
  def main(args: Array[String]) {
    val result = count(readLine())
    println(List(
      result('A').toString,
      result('C').toString,
      result('G').toString,
      result('T').toString,
    ).mkString(" "))
  }

  def count(dna: String) = {
    val empty = Map(
      'A' -> 0,
      'C' -> 0,
      'G' -> 0,
      'T' -> 0,
    )

    empty ++ dna.groupBy(identity).transform((_, v) => v.size)
  }
}
