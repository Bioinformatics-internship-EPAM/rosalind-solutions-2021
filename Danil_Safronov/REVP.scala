import scala.io.Source

object REVP {
  def main(args: Array[String]) {
    for (lines <- reversePalindromes("rosalind_revp.txt", 4, 12)) println(lines._1 + " " + lines._2)
  }

  def reversePalindromes(filename: String, min: Int, max: Int) = {
    val dna = splitFile(filename)(0)._2

    for { i <- 0 until (dna.length - 1);
          len <- (min until max + 1).filter(_ % 2 == 0)
         if (i + len <= dna.length) &&
           (dna.substring(i, i + (len / 2)) == reverseDNA(dna.substring(i + (len / 2), i + len))) }
              yield (i + 1, len)
  }

  def splitFile(filename: String): Array[(String, String)] = {
    val lines = Source.fromFile(filename)
      .toArray
      .mkString
      .split('>')
      .filter(_.length != 0)

    val splitted_lines = { for (line <- lines) yield line.split("\r\n") }

    {
      for (line <- splitted_lines)
        yield (
          line(0),
          line.drop(1).mkString("")
        )
    }
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
