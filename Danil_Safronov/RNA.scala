import scala.io.StdIn.readLine

object RNA {
  def main(args: Array[String]) {
    println(readLine.map(ch => transform(ch)))
  }

  def transform(c: Char): Char = c match {
    case 'T' => 'U'
    case _ => c
  }
}
