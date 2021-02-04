import scala.annotation.tailrec
import scala.io.StdIn.readLine

object REVC {
  def main(args: Array[String]) {
    val result = reverse(readLine.toList)
    for (c <- result) print(c)
  }

  def reverse(dna: List[Char]): List[Char] = {
    @tailrec def inner(in: List[Char], out: List[Char]): List[Char] = in match {
      case elem :: tail => inner(tail, transform(elem) :: out)
      case Nil => out
    }

    inner(dna, List())
  }

  def transform(c: Char): Char = c match {
    case 'T' => 'A'
    case 'A' => 'T'
    case 'C' => 'G'
    case 'G' => 'C'
  }
}