import scala.io.StdIn.readLine
import scala.annotation.tailrec

object DNA {
  def main(args: Array[String]) {
    val result = count(readLine())
    println(result('A').toString + ' ' + result('C').toString + ' ' + result('G').toString + ' ' + result('T').toString)
  }

  def count(dna: String): Map[Char, Int] = {
    @tailrec def inner(dna: List[Char], counts: Map[Char, Int]): Map[Char, Int] = dna match {
      case elem :: tail => inner(tail, counts ++ Map(elem -> (counts(elem) + 1)))
      case Nil => counts
    }

    inner(dna.toList, Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0))
  }
}