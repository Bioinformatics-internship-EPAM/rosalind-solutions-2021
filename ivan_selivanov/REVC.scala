import scala.io.StdIn.readLine


object REVC extends App {
  val complements = Map(
    'A' -> 'T',
    'T' -> 'A',
    'C' -> 'G',
    'G' -> 'C'
  )
  println(readLine().reverse.map(complements).mkString(""))
}
