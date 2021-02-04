import java.io.{File, PrintWriter}
import scala.io.StdIn.readInt
import scala.util.Using

object SIGN extends App {
  val n = readInt()

  def factorial(num: Int) = (1 to num).foldLeft(1)({ case (a, b) => a * b })

  Using(new PrintWriter(new File("answer.txt"))) { writer =>

    def output_permutations(array: Array[Int]): Unit = {
      def output_permutations_rec(array: Array[Int], str_acc: String): Unit = {
        if (array.isEmpty) {
          writer.println(str_acc.dropRight(1))
        }
        else
          array.foreach(x => output_permutations_rec(array.filter(k => k.abs != x.abs), str_acc + x + " "))
      }

      output_permutations_rec(array, "")
    }

    writer.println(factorial(n) * math.pow(2, n).toInt)
    output_permutations(Array.range(-n, n + 1).filter(_ != 0))
  }
}
