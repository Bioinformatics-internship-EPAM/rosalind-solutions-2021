import scala.annotation.tailrec
import scala.io.StdIn.readInt

object FIBD {
  def main(args: Array[String]) {
    print(countRabbits(readInt, readInt))
  }

  def countRabbits(n: Int, m: Int): Long = {
    @tailrec def updRabbits(n: Int, m: Int, d: Int, adult: List[Long], small: List[Long]): Long = n match {
        //d - past days
        //adult - array with counts of adult rabbits for each day
        //small - with small
      case 0 => 1
      case 1 => adult.last + small.last
      case _ if d < m => updRabbits(n - 1, m, d + 1, adult :+ (adult.last + small.last), small :+ adult.last)
      case _ if d >= m => updRabbits(n - 1, m, d + 1, adult :+ (adult.last + small.last - small(d - m)), small :+ adult.last)
    }

    updRabbits(n, m, 1, List(0), List(1))
  }
}
