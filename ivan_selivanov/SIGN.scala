import java.io.{File, PrintWriter}
import scala.annotation.tailrec
import scala.io.StdIn.readInt

object SIGN extends App {
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

  def calc_pert(array: Array[Int]): Unit = {
    def calc_pert_acc(array: Array[Int], str_acc: String): Unit = {
      if (array.isEmpty) {
        writer.println(str_acc)
      }
      else
        array.foreach(x => calc_pert_acc(array.filter(k => k.abs != x.abs), str_acc + x + " "))
    }

    calc_pert_acc(array, "")
  }
  writer.println(factorial(n) * math.pow(2, n).toInt)
  calc_pert(Array.range(-n, n + 1).filter(_ != 0))
  writer.close()
}
