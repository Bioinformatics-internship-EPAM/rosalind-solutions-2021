import Protein.massTable

import scala.util.{Failure, Success, Using}

case class Protein(s: String) {
  def mass: Double = s.map(massTable).sum

  override def toString: String = s
}

object Protein {

  private val massTable: Map[Char, Double] = {
    Using(io.Source.fromResource("monoisotopic_mass_table.txt")) { source =>
      source.getLines().mkString(" ").split(" +")
    } match {
      case Failure(exception) => throw exception
      case Success(ms) => ms.grouped(2)
        .map { case Array(aminoAcid, mass) => aminoAcid.head -> mass.toDouble }
        .toMap
    }
  }

  private val codonToAminoAcid = {
    Using(io.Source.fromResource("rna_codon_table.txt")) { source =>
      source.getLines().mkString(" ").split(" +")
    } match {
      case Failure(exception) => throw exception
      case Success(codonsAndAminoAcids) => codonsAndAminoAcids
        .grouped(2)
        .map { case Array(codonString, aminoAcid) => Codon(codonString) -> aminoAcid }
        .toMap
    }
  }

  def apply(codons: List[Codon]): Protein =
    Protein(codons.map(codonToAminoAcid).mkString.dropRight(4))
}