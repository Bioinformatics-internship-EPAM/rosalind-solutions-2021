import scala.io.StdIn.readLine
import DNA.rec_count

import scala.io.Source

object GC {
  def main(args: Array[String]) {
    val result = {
      for (line <- splitFile("rosalind_gc.txt")) yield (line._1, countGC(line._2))
    } maxBy (_._2)

    println(result._1)
    println(result._2)
  }

  def splitFile(filename: String): Array[(String, String)] = {
    val lines = Source.fromFile(filename)
      .toArray
      .mkString
      .split('>')
      .filter(_.length != 0)

    {
      for (line <- lines)
        yield (
          line.split('\n')(0)
            .replaceAll("\r", ""),
          line.replaceAll("\r", "")
            .split('\n')
            .drop(1)
            .mkString("")
        )
    }
  }

  def countGC(dna: String): Double = {
    val res = rec_count(dna)
    ((res('C') + res('G')).toDouble / (res('C') + res('G') + res('A') + res('T'))) * 100
  }
}
