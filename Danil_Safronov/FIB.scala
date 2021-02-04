import scala.annotation.tailrec
import scala.io.StdIn.readInt

object FIB {
  def main(args: Array[String]) {
    print(countRabbits(readInt, readInt))
  }

  def countRabbits(n: Int, k: Int): Long = {
    @tailrec def updRabbits(n: Int, k: Int, big: Long, little: Long): Long = n match {
      case 0 => 1
      case 1 => big + little
      case _ => updRabbits(n - 1, k, big + little, big * k)
    }

    updRabbits(n, k, 0, 1)
  }
}