import java.io.{File, PrintWriter}
import scala.io.StdIn.{readInt, readLine}

object LEXF extends App {
  val writer = new PrintWriter(new File("answer.txt"))
  val alphabet = readLine().toCharArray.filter(_ != ' ').sorted

  def calc_pert(array: Array[Char], depth: Int): Unit = {
    def calc_pert_acc(array: Array[Char], str_acc: String, current_depth: Int): Unit = {
      if (current_depth == depth) {
        writer.println(str_acc)
      }
      else
        array.foreach(x => calc_pert_acc(array, str_acc + x, current_depth + 1))
    }

    calc_pert_acc(array, "", 0)
  }
  calc_pert(alphabet, readInt())
  writer.close()
}
