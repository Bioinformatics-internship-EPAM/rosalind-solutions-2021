import scala.io.StdIn.readLine

object HAMM extends App {
  val (first, second) = (readLine(), readLine())
  print(first.zip(second).count({case (c1, c2) => c1 != c2}))
}
