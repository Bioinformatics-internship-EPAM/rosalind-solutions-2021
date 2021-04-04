import collection.mutable

object DNA extends App {
  val source = io.Source.fromResource("rosalind_dna.txt")
  val dna = source.getLines.mkString
  source.close()

  val ACGTCount = mutable.Map[Char, Int]()
  ACGTCount.addAll("ACGT".map(_ -> 0))

  dna.foreach(ACGTCount(_) += 1)

  println("ACGT".map(ACGTCount(_)).mkString(" "))
}
