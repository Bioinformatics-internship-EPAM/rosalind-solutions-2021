object CalculatingExpectedOffspring extends App {

  val dominantProbabilities = Array(1, 1, 1, 3.0/4, 1.0/2, 0)
  val offspringsPerCouple = 2

  val couples = io.Source.fromResource("rosalind_iev.txt")
    .getLines().mkString.split(" ").map(_.toInt)

  val expectedDominantOffspring = (couples zip dominantProbabilities)
    .map{ case (n, prob) => offspringsPerCouple * n * prob }
    .sum

  println(expectedDominantOffspring)
}
