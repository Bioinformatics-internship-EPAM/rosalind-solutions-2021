import scala.annotation.tailrec
import scala.io.StdIn.readLine

object SUBS {
  def main(args: Array[String]) {
    for (index <- subs(readLine, readLine)) print(index.toString + " ")
  }

  def subs(dna: String, subdna: String): List[Int] = {
    @tailrec def inner (dna: String, subdna: String, res: List[Int]): List[Int] = dna.indexOf(subdna) match {
      case -1 => res
      case n => inner(dna.drop(n + 1), subdna, res ++ List(res.last + n + 1))
    }

    inner(dna, subdna, List(0)).drop(1)
  }
}
