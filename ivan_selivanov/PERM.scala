import java.io.{File, PrintWriter}
import scala.annotation.tailrec
import scala.io.StdIn.readInt

object PERM extends App {
  val writer = new PrintWriter(new File("answer.txt"))
  val n = readInt()

  def factorial(num: Int): Int = {
    @tailrec
    def factorial_acc(num: Int, acc: Int): Int = {
      if (num == 1) acc
      else factorial_acc(num - 1, num * acc)
    }

    factorial_acc(num, 1)
  }

  def calc_perm(array: Array[Int]): Unit = {
    def calc_perm_acc(array: Array[Int], str_acc: String): Unit = {
      if (array.isEmpty) {
        writer.println(str_acc)
      }
      else
        array.foreach(x => calc_perm_acc(array.filter(k => k != x), str_acc + x + " "))
    }

    calc_perm_acc(array, "")
  }
  writer.println(factorial(n))
  calc_perm(Array.range(1, n + 1))
  writer.close()
}
