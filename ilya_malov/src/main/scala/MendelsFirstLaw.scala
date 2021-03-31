
object MendelsFirstLaw extends App {

  val source = io.Source.fromResource("rosalind_iprb.txt")
  val Array(k, m, n) = source.getLines().mkString.split(' ').map(_.toDouble)
  source.close()

  val population = k + m + n

  val Aa_prob_a = (m / population) * 0.5
  val Aa_Aa_probRecessive = Aa_prob_a * ((m - 1) / (population - 1)) * 0.5
  val Aa_aa_probRecessive = Aa_prob_a * (n / (population - 1))

  val aa_prob_a = (n / population)
  val aa_aa_probRecessive = aa_prob_a * ((n - 1) / (population - 1))
  val aa_Aa_probRecessive = aa_prob_a * (m / (population - 1)) * 0.5

  val probDominant = 1 - (Aa_Aa_probRecessive + Aa_aa_probRecessive + aa_aa_probRecessive + aa_Aa_probRecessive)

  println(probDominant)

}
