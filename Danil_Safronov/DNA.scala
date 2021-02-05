import scala.io.StdIn.readLine
import scala.annotation.tailrec

object DNA {
  def main(args: Array[String]) {
    val result = iter_count(readLine())
    println(List(
      result('A').toString,
      result('C').toString,
      result('G').toString,
      result('T').toString,
    ).mkString(" "))
  }

  def rec_count(dna: String): Map[Char, Int] = {
    @tailrec def inner(dna: List[Char], counts: Map[Char, Int]): Map[Char, Int] = dna match {
      case Nil => counts
      case elem :: tail => inner(tail, counts + (elem -> (counts(elem) + 1)))
    }

    inner(dna.toList, Map(
      'A' -> 0,
      'C' -> 0,
      'G' -> 0,
      'T' -> 0,
    ))
  }

  def iter_count(dna: String): Map[Char, Int] = {
    var result = Map(
      'A' -> 0,
      'C' -> 0,
      'G' -> 0,
      'T' -> 0,
    )

    for (ch <- dna) {
      result += (ch -> (result(ch) + 1))
    }

    result
  }

}
