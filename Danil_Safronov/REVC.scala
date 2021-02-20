import scala.io.StdIn.readLine

object REVC {
  def main(args: Array[String]) {
    println(reverseDNA(readLine))
  }

  def reverseDNA(dna: String) = {
    dna.reverse.map(ch => transform(ch))
  }

  def transform(c: Char): Char = c match {
    case 'T' => 'A'
    case 'A' => 'T'
    case 'C' => 'G'
    case 'G' => 'C'
  }
}
