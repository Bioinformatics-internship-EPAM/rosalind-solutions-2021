import java.nio.file.{Files, Paths}
import scala.util.{Failure, Success, Try, Using}

object Main extends App {

  def getOrCreateFile(file: String) = {
    val path = Paths.get(file).toAbsolutePath
    Try(Files.createFile(path)) match {
      case Failure(_) => path
      case Success(file) => file
    }
  }

  val source = io.Source.fromResource("sars-cov-genome.txt")
  val dnaString = source.getLines.mkString
  source.close()

  val dna = Dna(dnaString)
  val dnaComplement = dna.reverseComplement

  val rna = dna.toRna
  val rnaComplement = dnaComplement.toRna

  val orfs = List(
    rna.readingFrame1,
    rna.readingFrame2,
    rna.readingFrame3,
    rnaComplement.readingFrame1,
    rnaComplement.readingFrame2,
    rnaComplement.readingFrame3
  ).flatMap(OpenReadingFrame.getOrfs).flatten

  val proteins = orfs.map(orf => Protein(orf)).distinct
  val proteinMasses = proteins.map(p => p.toString + " -> " + p.mass)

  println(proteins.size + " potential proteins found")

  val outProteins = getOrCreateFile("proteins.txt")
  Using(Files.newBufferedWriter(outProteins))(_.write(proteins.mkString("\n")))

  val outProteinMasses = getOrCreateFile("masses.txt")
  Using(Files.newBufferedWriter(outProteinMasses))(_.write(proteinMasses.mkString("\n")))
}
