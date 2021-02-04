import scala.io.StdIn.readLine

object SUBS extends App {
  val (text, pattern) = (readLine(), readLine())
  val matches = s"(?=($pattern))".r.findAllMatchIn(text)
  println(matches.map(_.start + 1).mkString(" "))
}
