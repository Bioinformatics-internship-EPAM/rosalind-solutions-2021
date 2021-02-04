import GC.splitFile
import REVC.reverse

object REVP {
  def main(args: Array[String]) {
    for (lines <- reversePalindromes("rosalind_revp.txt", 4, 12)) println(lines._1 + " " + lines._2)
  }

  def reversePalindromes(filename: String, min: Int, max: Int) = {
    val dna = splitFile(filename)(0)._2

    for {i <- 0 until (dna.length - 1); len <- (min until max + 1).filter(_ % 2 == 0)
         if (i + len <= dna.length) &&
           (dna.substring(i, i + (len / 2)).toList == reverse(dna.substring(i + (len / 2), i + len).toList))}
              yield (i + 1, len)
  }
}
