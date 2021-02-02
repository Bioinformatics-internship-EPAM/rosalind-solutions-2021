import scala.io.StdIn.readLine

object HAMM extends App {
  print(readLine().zip(readLine()).count(x => x._1 != x._2))
}
