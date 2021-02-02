import java.io.{File, PrintWriter}
import scala.io.StdIn.{readInt, readLine}

object LEXV extends App {
  val writer = new PrintWriter(new File("answer.txt"))
  val alphabet = readLine().toCharArray.filter(_ != ' ')

  def calc_pert(array: Array[Char], depth: Int): Unit = {
    def calc_pert_acc(array: Array[Char], str_acc: String, current_depth: Int): Unit = {
      if (current_depth > 0) {
        writer.println(str_acc)
      }
      if (current_depth != depth)
        array.foreach(x => calc_pert_acc(array, str_acc + x, current_depth + 1))
    }

    calc_pert_acc(array, "", 0)
  }
  calc_pert(alphabet, readInt())
  writer.close()

}
