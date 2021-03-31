object CountingPointMutations extends App {

  val input = io.Source.fromResource("rosalind_hamm.txt").getLines.mkString
  val (dna1, dna2) = input.splitAt(input.length / 2)

  var count = 0
  for ((nucleobase1, nucleobase2) <- dna1 lazyZip dna2) {
    if (nucleobase1 != nucleobase2)
      count += 1
  }

  println(count)
}
