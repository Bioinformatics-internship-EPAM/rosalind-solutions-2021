import scala.io.StdIn.readLine

object SUBS extends App {
  val s = readLine()
  s"(?=($readLine))".r.findAllMatchIn(s).map(_.start + 1).foreach(x => print(x + " "))
}
