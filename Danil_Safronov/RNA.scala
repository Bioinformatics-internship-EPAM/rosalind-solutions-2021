import scala.io.StdIn

object RNA {
  def main(args: Array[String]) {
    for (c <- StdIn.readLine.toList) print(transform(c))
  }

  def transform(c: Char): Char = c match {
    case 'T' => 'U'
    case _ => c
  }
}