import scala.io.StdIn.readLine

object DNA extends App {
  val answer = readLine().toList.foldLeft(Map.empty[Char, Int]) {
    (count, base) => count + (base -> (count.getOrElse(base, 0) + 1))
  }
  print(answer('A') + " " + answer('C') + " " + answer('G') + " " + answer('T'))
}
