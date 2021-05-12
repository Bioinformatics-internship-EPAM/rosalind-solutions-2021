
case class Codon(x: Char, y: Char, z:Char) {
  override def toString: String = s"$x$y$z"
}

object Codon {
  val startCodon: Codon = Codon("AUG")
  val endCodons = Set(Codon("UAA"), Codon("UAG"), Codon("UGA"))

  def apply(s: String): Codon = {
    Codon(s(0), s(1), s(2))
  }
}