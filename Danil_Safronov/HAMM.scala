import scala.annotation.tailrec
import scala.io.StdIn.readLine

object HAMM {
  def main(args: Array[String]) {
    print(hamming(readLine, readLine))
  }

  def hamming(s1: String, s2: String): Int = {
    @tailrec def inner(s1: List[Char], s2: List[Char], n: Int): Int = (s1, s2) match {
      case (Nil, Nil) => n
      case (s1, Nil) => -1
      case (Nil, s2) => -1
      case (s1_elem :: s1_tail, s2_elem :: s2_tail) if s1_elem == s2_elem => inner(s1_tail, s2_tail, n)
      case (s1_elem :: s1_tail, s2_elem :: s2_tail) => inner(s1_tail, s2_tail, n + 1)
    }
    inner(s1.toList, s2.toList, 0)
  }
}
