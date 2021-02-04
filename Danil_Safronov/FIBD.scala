import scala.annotation.tailrec
import scala.io.StdIn.readInt

object FIBD {
  def main(args: Array[String]) {
    print(countRabbits(readInt, readInt))
  }

  def countRabbits(n: Int, m: Int): Long = {
    @tailrec def updRabbits(n: Int, m: Int, d: Int, big: List[Long], little: List[Long]): Long = n match {
      case 0 => 1
      case 1 => big.last + little.last
      case _ if d < m => updRabbits(n - 1, m, d + 1, big ++ List(big.last + little.last), little ++ List(big.last))
      case _ => updRabbits(n - 1, m, d + 1, big ++ List(big.last + little.last - little(d - m)), little ++ List(big.last))
    }

    updRabbits(n, m, 1, List(0), List(1))
  }

  def countRabbitsNative(n: Int, m: Int): Long = {
    @tailrec def updRabbits(n: Int, m: Int, rabbits: List[Int]): Long = n match {
      case 0 => 1
      case 1 => rabbits.length
      case _ => updRabbits(n - 1, m, List.tabulate(rabbits.filter(_ > 1).length)(_ => 1) ++ rabbits.filter(_ < m).map(n => n + 1))
    }

    updRabbits(n, m, List(1))
  }
}
