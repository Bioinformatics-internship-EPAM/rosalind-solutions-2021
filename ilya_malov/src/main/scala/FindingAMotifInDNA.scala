object FindingAMotifInDNA extends App {

  val input = io.Source.fromResource("rosalind_subs.txt").getLines.toVector
  val (dna, substring) = (input(0), input(1))

  val dnaSlices = dna.sliding(substring.length)
  val locations = for ((slice, i) <- dnaSlices.zipWithIndex if slice == substring) yield i + 1

  println(locations.mkString(" "))
}
