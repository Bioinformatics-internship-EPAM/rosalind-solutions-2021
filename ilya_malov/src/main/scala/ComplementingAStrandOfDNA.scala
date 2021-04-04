
object ComplementingAStrandOfDNA extends App {
  val source = io.Source.fromResource("rosalind_revc.txt")
  val dna = source.getLines.mkString
  source.close()

  val reverseComplement = dna.map({
    case 'A' => 'T'
    case 'T' => 'A'
    case 'C' => 'G'
    case 'G' => 'C'
  }).reverse.mkString

  println(reverseComplement)
}
