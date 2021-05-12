object TranslatingRnaIntoProtein extends App {

  // UUU, F, CUU, L, AUU, I...
  val codonsAndAminoAcids = io.Source.fromResource("rna_codon_table.txt")
    .getLines().mkString(" ").split(" +")

  val codonToAminoAcid = codonsAndAminoAcids
    .grouped(2)
    .map { case Array(codon, aminoAcid) => codon -> aminoAcid }
    .toMap

  val rna = io.Source.fromResource("rosalind_prot.txt").getLines.mkString

  val proteinString = rna.grouped(3).map(codonToAminoAcid).mkString

  println(proteinString)
}
