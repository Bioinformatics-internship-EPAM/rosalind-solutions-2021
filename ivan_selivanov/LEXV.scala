import java.io.{File, PrintWriter}
import scala.io.StdIn.{readInt, readLine}
import scala.util.Using

object LEXV extends App {
  val alphabet = readLine().toCharArray.filter(_ != ' ')

  Using(new PrintWriter(new File("answer.txt"))) { writer =>

    def output_permutations(depth: Int): Unit = {
      def output_permutations_rec(str_acc: String, current_depth: Int): Unit = {
        if (current_depth > 0) {
          writer.println(str_acc)
        }
        if (current_depth != depth)
          alphabet.foreach(x => output_permutations_rec(str_acc + x, current_depth + 1))
      }

      output_permutations_rec("", 0)
    }

    val depth = readInt()
    output_permutations(depth)
  }
}
