import scala.io.StdIn.readLine

object SUBS extends App {
  val (text, pattern) = (readLine(), readLine())
  val indexes_list =
    for (index <- 0 until text.length - pattern.length + 1
         if text.substring(index, index + pattern.length) == pattern)
      yield index + 1
  print(indexes_list.mkString(" "))
}
