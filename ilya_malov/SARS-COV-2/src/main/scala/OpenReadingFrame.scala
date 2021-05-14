
case class OpenReadingFrame(codons: List[Codon], endCodon: Codon) {
  val startCodon: Codon = Codon.startCodon

  override def toString: String = s"ORF(${Codon.startCodon} ${codons.mkString(" ")} $endCodon)"
}

object OpenReadingFrame {
  def getOrfs(codons: List[Codon]): Option[List[OpenReadingFrame]] = {
    val z = (List.empty[Codon], List.empty[OpenReadingFrame], Option.empty[Codon])
    codons.foldRight(z) {
      case (Codon.startCodon, (acc, orfs, e@Some(endCodon))) => {
        val orf = OpenReadingFrame(acc, endCodon)
        (Codon.startCodon :: acc, orf :: orfs, e)
      }
      case (c, (_, orfs, _)) if Codon.endCodons contains c => (Nil, orfs, Some(c))
      case (c, (acc, orfs, e@Some(_))) => (c :: acc, orfs, e)
      case (_, z) => z
    }._2 match {
      case Nil => None
      case l => Some(l)
    }
  }

  implicit def orfToCodonList(orf: OpenReadingFrame): List[Codon] =
    (orf.startCodon +: orf.codons.toBuffer :+ orf.endCodon).toList
}