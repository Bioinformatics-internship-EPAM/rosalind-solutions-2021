import scala.annotation.tailrec

object RabbitsAndRecurrenceRelations extends App {

  val n = 29
  val k = 2

  def countRabbits(n: Long, k: Long): Long = {
    @tailrec
    def f(gen1: Long, gen2: Long, i: Long): Long = {
      if (i == 0) gen2 else f(gen2, gen2 + k * gen1, i - 1)
    }

    f(1, 1, n - 2)
  }

  println(countRabbits(n, k))
}
