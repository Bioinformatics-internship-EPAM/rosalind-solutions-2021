import scala.io.StdIn.readLine

object DNA extends App {
  val charCounts = readLine().groupMapReduce(identity)(_ => 1)(_ + _)
  val result = Seq('A', 'C', 'G', 'T').map(charCounts).mkString(" ")
  print(result)
}
