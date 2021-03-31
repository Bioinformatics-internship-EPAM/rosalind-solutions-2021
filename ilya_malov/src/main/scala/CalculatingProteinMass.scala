object CalculatingProteinMass extends App {

  // A, 71.03711, C, 103.00919, D, 115.02694...
  val masses = io.Source.fromResource("monoisotopic_mass_table.txt")
    .getLines().mkString(" ").split(" +")

  val massTable = masses
    .grouped(2)
    .map{ case Array(aminoAcid, mass) => aminoAcid.head -> mass.toDouble}
    .toMap

  val proteinString = io.Source.fromResource("rosalind_prtm.txt").getLines.mkString

  val weight = proteinString.map(massTable).sum

  println(weight)
}
