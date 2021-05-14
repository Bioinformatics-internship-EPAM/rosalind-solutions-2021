
object TranscribingDNAtoRNA extends App {
  val source = io.Source.fromResource("rosalind_rna")
  val dna = source.getLines().mkString
  source.close()

  val rna = dna.replace('T', 'U')

  println(rna)
}
