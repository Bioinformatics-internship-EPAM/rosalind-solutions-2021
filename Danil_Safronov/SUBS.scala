import scala.annotation.tailrec
import scala.io.StdIn.readLine

object SUBS {
  def main(args: Array[String]) {
    println(subs(readLine, readLine).mkString(" "))
  }

  def subs(dna: String, subdna: String): List[Int] = {
    @tailrec def inner (dna: String, subdna: String, res: List[Int]): List[Int] = dna.indexOf(subdna) match {
      case -1 => res
      case n if res.isEmpty => inner(dna.drop(n + 1), subdna, res :+ (n + 1))
      case n => inner(dna.drop(n + 1), subdna, res :+ (res.last + n + 1))
    }

    inner(dna, subdna, List())
  }
}
