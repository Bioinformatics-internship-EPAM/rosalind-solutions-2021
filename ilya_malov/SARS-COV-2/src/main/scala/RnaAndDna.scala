
case class Rna(s: String) {
  private def toCodons(s: String): List[Codon] =
    s.dropRight(s.length % 3).sliding(3, 3).map(s => Codon(s)).toList

  lazy val readingFrame1: List[Codon] = toCodons(s)
  lazy val readingFrame2: List[Codon] = toCodons(s.drop(1))
  lazy val readingFrame3: List[Codon] = toCodons(s.drop(2))
}

case class Dna(s: String) {
  lazy val reverseComplement: Dna = Dna(s.map({
    case 'A' => 'T'
    case 'T' => 'A'
    case 'C' => 'G'
    case 'G' => 'C'
  }).reverse.mkString)

  def toRna: Rna = Rna(s.replace('T', 'U'))
}