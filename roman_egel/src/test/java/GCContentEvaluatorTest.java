import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class GCContentEvaluatorTest {
  String fasta = """
                    >Rosalind_3235
                    ATTAGCGCCCTGAAACGTCCCTACGGGAGGGCTCATCGAAGGCTTTCAAAAATCTCGAGA
                    AAGCCTCCGAGATTTACCTAATGACTATCCCCGGCCGTACCTGACGTGGCTAATTAGTAG
                    GAATTATGAAGATCTGGGTCCAGAGTTGTCCGCCCGGACTCAAGACGGCGACACCACATT
                    CGGCACGGAGATTCCATTGACCCGTCCAGCATTACGTACGAGATGAGGCCTCGATAATAC
                    CTCAGGGCATCTACGGCCCAGCCGCGACAGACTGACTACAGCACAGTGGGTGTGAGTGAC
                    TCCTCGTTGGATTAGTACGTTTAAAATTTCAGCGTCATCACAACAGTCCGGTCGTGCTAG
                    CATATCGTTTTATCAATATGCGATGTGTTCCTCCGCAGGAGTCGTCGGCTGGGCAACAGT
                    TGATCTCCTTGATGAATCTGTGTTTCCGTCTGACCCAACAAGTTGTCGGCTGGTTGACTA
                    TACGTTCCAGTGATTAAGACCCACGATCGACTACCGCTTATAAGCGAATAGAGGGCTACG
                    AATAAATGGTCGAAATAACGCGCGTATGCGTAGCGCATCAACGCGTACGTACGCCGGCTT
                    TCCCTGTCCGAACGGACCATCGGGAGCGCACAGAAAGGGGGTTCAACGGCTTCGTTCGGA
                    AACGCGCCAATAGCCTTTACTTACGGATTCCGCGTGTCGTCTCAATTGCTTACCCTTGAG
                    AAGTCGCCCGTTTCAAGCGAGTTGTGCAAATCAGGTATTTGTCGGGATGGAATGCATGAA
                    TTTGATTGATTCCATCGCGACAGGCTTTGAGCACTCCAAGTTG
                    >Rosalind_5104
                    GATAGACGTAAAGTGGTAGATCTAGATAGATAAGCTTCACAGGCTACAAGTCGTGACTCC
                    TATGTTCGGCGCAAATCGTATACATTACTAGGACGTGTAGCACACGGGAGTTACAGGTGC
                    CATGCTTTTGCGCTGGTTGTTCGCTACAGGCTGGATGATCCATTTTATCCATTGTTTACT
                    ACCCGTGCCGACGAAGGGTTGAGGGCACCCTTTTTTGACCACTCCTCATCATTCCTACTG
                    AACCTCATCAACCTGCACGGTGGGCAATCCGTGCTCAATTTTGCATTTAGTTCGAGTCAC
                    AGGCCTTGGATCTCTACTGTTGCAGAGATAAGCGGGCACACCTTAGAGCAGGCGCTCGTT
                    CCTACGGAGTCAAGTAATCCAGCATTGAGCATAAACGAAGGAGGGTCGTGGTCGCGCTAG
                    AATCAGTGTACCCCGAACGCTCTCAGCCAACAAGTATAAAAAAGTCCCAGAGTCCGGAGA
                    GACTGCTGCGCCAGGCGCGTAAGGCGCATTGACCCATTCGCGGGTACCATTTCGGAGATG
                    TTGGAATTCTTAGCTCTGCAAGGTTGGGTATGGCTGGTATTCCTACTCAGAGTAACGATC
                    TTGTACGTGCTCAGTGATAGCGGGAAATCTTCGAGGTTTAGCCCCCGGTCTAGTGGACGA
                    GTGGCCGTGGACAATGGCTCGTGCGTGGGTTCAAAGAGGAATTTACTGCCAACAGCGCGC
                    AATTGCTAAGCTTTAGTCTCATCTACTCATGGGACCAGTTTGACGCGTAAATTCCAAATG
                    TGTGGTGAATGGTAGGTTACCCCAGTCCTGCCTTGAATTTTGGTGGGCAGAGTGGCCCAG
                    TGGGCATCCCGTCGCTACATTATTAACGTTGAGTTCGTCGGCGGAGTCTGCTATATGACC
                    GACTCATCGAATTCTGTTTGATGTTCCCTTTTGAGCCTTATTCAACCGCTAGGGACTCCG
                    GAGCCACGTCACCTATCGATTTGTAAGCCGACTCG
                    >Rosalind_9226
                    CAGCGTATCCATAAGTCAGCCGCTTTAACCGGGGCGTTTGGTACCAGTCCTTTACATTTA
                    CAGGGAGTGCATGGAAATGGCATCCTGAGCCGGGCCTTTCCAGAAATTAATAAGGATCTA
                    TGTGTATGGGGATTCTCGCCCTGTAACTCGGTGAACCAGCCCAGCGTGGGTGCACCCGGT
                    TTGGAGTTATGCGAGTGATTATCGGCCGAGTCCGTGAATAAGCGAAAGTTCTGTTAAGAT
                    CCAAGCACCGTCCACGGTATAAATTAGGTATTCAGCTTTGCTTAACCCTGAGGATTTTCT
                    CGACGTCGCGGTGCATAATCGTGAATGTTGTGCGTTCTCTGCAATAGGGTTCGGGCGCAC
                    TCGATCAGCAACAAGTAAAAGCCCTACAAGGCGCACCTAGGGGGCCTCCTACTGGCCTAA
                    AACGTGTGGTCCCTCGCTTGATATAGCGTTCCCGCCAGGTAAGTATGACCCAATGTATCG
                    AGAGATGTGCACGGCTATGCAATGTCGCGCAGTGTGAACTGACACTCTCCCAATCTGCCC
                    CGTCTATTCGTATACGGTGTCGCATCCTCACCCGATTACGAGCATTTCGGTCTCTAAGTA
                    GAGAGTACGTCCGACAGCGCCGTAATGGGCCCGGCTTAGAGCTAAGCCCCCTCTTGAGAA
                    CCGATGCCCACGGAGACTGGACACAGTTACGCACATGGCGGAGGCATATATTACGGGTTT
                    TCGATAGGCCGGCTTTCGACAAACCATTCTGGGGGAGATGGTTTTTCGTGAAAATCAGTT
                    CTCAGGGCAGTCTATAAGGAATGAGACTCAAGTGGAT
                    >Rosalind_7209
                    CCTCTGCAGTGTCGCACCCGTTATTAGTCATTCGTTGGAGGTCCACGATGGGCACAAGAA
                    CAGGGCGCGTCATGCGAATACATCTGAGTATTATGTGTGGATTTAATCAGCTGTTTCGTA
                    GCCGTCTAATACCCCCCAGCGGCTGCAGATTGTAGTTAACATACTTGGGTATTCAAGTCA
                    TTACGCTTCGCGCTCAGGCCTTCTGCTGCAGGTGACCAGTTTTGGAGTAATTAAAAAGAA
                    AGTAAGACAGTAGAAGATTGTCGGATGAAGAAACCATCCTGGGAGAGAAATGATCTAGAC
                    GTGATTTTCTTGGGCGGCTCATGCCTGCCCTCTTAAGTGCGACTCGTGATGACTTCAGTT
                    CCTTTATTATTGGATGGCATTTGTTCACACCTCAAGAATGGGCTGACTAGAACGAAGCAG
                    AACCAGTACCATATCGCAGAATTGTTATCCGCGATGTGAGGCGCGCGAAGATGGAGTCGG
                    TATCGAGGACGACCATGTGAGGACTAAACTCTCAAGAGAATGCTCTGAGCAGGTCCATAG
                    CTTACTGGATCGTCTGGCACGCAGGCTCTTCTCGCGCAGATAATTTTAAGGTAGAACGAT
                    GCAGCTTACATCGCAACCCCTGGGACGAGCGACTGGGAAGCATTACAGTAGACGGAACTA
                    TGTCACCACTCAGCGGTTCGAAGAGCCGTGGACAGATGCCCCGTCGTAACTTCTCACCTA
                    ACGACGGATGTCTCTGTGTGCTATGAGTGAGAACTTTAGGGGCCCGCGTTGCGAATAGGT
                    GTGGGAGCCGCGCCAACTAACGAACTAAAACGCTAGCTAGTTACGCTGGAATGATCGTGA
                    AGATTCCTGTATGCCTTACATCTTGAACTGACTCGCTATTGAATTGGAGCAATAGCTCCC
                    TATCCTGCTTGCATCCGGTATACAGAATTTAACTTTATACTCACCCACAACCTATCACGA
                    CCTGTATGTGATTCAAAATCT
                    >Rosalind_3886
                    TACTCCGTTGCGGGGGTAACTATGTCGTCTCGTATTAACAGCCCCGGCAGGAAAACTTGT
                    AAAGTTTCCCTCCCAGCCGTGGAGCGTGAGTTACCCGATTGCAGGCGTCGTTACCTCTAC
                    ACACGTGGTAGTTCTTCTAATCCATGCTTCTATTCTAGCCTGGATATCAACGTGCTTAAA
                    AATCCCGAACACAGAATGTCAGTGGGCGACATCTACCAAACTGTCATGAGTGTACATGTA
                    ACATCGAGGAGGGCGTGACTACGGCACTAAGTGTACAATATTTTTGATGATTTTGCCCTG
                    GTCTCATGTATCTACACACCTGCTTACAGCAATCCGCTCGAATATGTGTACAATGGGCCG
                    AACGTATTAGGGGTTCGGCCTCCCTCAAAAAGTTTACGGGTCCATTGGAAGGTTTAATTG
                    GATCCAGCGCGGCCAATTAGGAATGTATATTTACGGTGTGTCCTAGTACCTTAGAACTCC
                    CCGCCTAACGCTCCCTGGCCCATGTGCCGAACGAGACATTCAGCACACGGAGCCGAATTG
                    AAGAGGGGAAACGTTTGTTCAGGGCCAAAAACAACCATCATGGGGTACCCTCATGTGGAC
                    TTAGTACGCGATCCTAATTTGAATTGCGCTGGCTAAATTTGAACAAGGTGCGTCGCTCTA
                    TAACCGACCCGCTAAGGTCTAGTCTACTCTATAGCGCACCTTAGGGCGCTAGCATCGCTT
                    AGTTGTCAAGAATGTCATCTCACCGCTCTTCCGACCTCCTGTATGTTAGCGCATCTGCTT
                    GCGGAGAGGCGGGTTTGATTCCCAGGTGA
                    >Rosalind_2780
                    TGTGGTCCTGTGCAACCATGCACTTGACATTGTACAGGGCTCTCTTAATGACCATCCGTG
                    GCACGCCGCCCTCACACCTCCTGGCTGCTATCCTAACTCGATTTGACGGCAGGCCCCAAG
                    TTCAAAACGGATGCAGCCGTGCATCATTCATCCTAATGTCAGATAGATTGCCAGATTGGC
                    ACCTTAAGGCCCGAATCTTGGATACCCTTACTCAAGGGGGGGCCGCGCCCCTACTCGTAC
                    ACGATAGGTGGGAAGCGCACGTACACTGAAATATCTCCCCTTAGAAGCACTCTTCGGTAT
                    ATTCCTTATTGAATGACGGATTAGACAACTGACAGCACGCGCAGGGTCCGCCGGGAGACC
                    ATTAATGATTTGGTACAGGCTCCCTACGTGGTTCAACGTACAAATCGCCGGATCGTAAAA
                    GTATTACGGTCTGCAGATGGACGCGGGTCCTATGAGTACTTGGGGACTCTACAACAGATT
                    CCTAAAGAATTAGAAGACCAAACTCATATGACCAACTACACAGAAGAAAACCATTAGTTA
                    ACTGCACTCAAAGTCACCTTCTTGTGAAGCTCGTGGCAACGCCCGATGATTGCCCCACAA
                    CCATTGGACCGAGGTTGCTGTGCGATTTTCAGTGCAGTAGTGGATCGCACAGTCAGCCGC
                    AAGAGAGGGAGGAAAGGATCTGGGAACAAAACGCCTCCGAAGCGGACTCGCGATTACCAA
                    ACGCGTCCTAACTGAATAAGAACAAAAGACTAGTTGAGCCGTTTTCTACCCTATAACCGA
                    CGGGAGGTCCTAGTCCCGAGTGTCAAGGAAGTCTTTACT
                    >Rosalind_5660
                    CCCACCCTTCTGGAGCCGTTTTCTAACTAAGCCATTTGCTGACGGTATGACGCGTACGGG
                    CGTACGCGTGCTGAGTCGGACAGTATGAGGGTACCCCCCACAAACTGGAATTTGGTTCAC
                    TGCACATTGTTGCTCGCGCAGAGCAGACTATACAATCACTCGTCCCGCAAGGGCTAGTGG
                    TTTTTCATTGCAACCTGGAACTACCTTTCTCACAACTAACCATCTGCTGGAAGAGCCAAA
                    CTAATAAAGTGAGCATCCCATTAGCTAATGATAACTAAAATTGTGTCGCCCATTACATTC
                    TTCGATGCTAGAACAAATCACCGCAGGAAAGTCGCCCCTATAAATATCATAGCGGACCGC
                    CTTTAGCGATATTTGTTACTTTGTCATCTTGTAAGTACACTCCAGGCCCTTAGCACAGGA
                    TTATTCCGCGCATATGTCGGGCGTGTAGAGCTAATCAAGGACGGAAGTCGGCTCTCCAGC
                    GGAACAGTTCAGCCTTAGCTGCTTTTGAGATCTATGACATCCGTTTTAAAGAACAGTGCC
                    ATATCAAGCTAAGTGAAGGGCTTCGGGTACGTAGACACATACCTGGCGAGGATGCCTCAT
                    GTTTGTCGACAGGTGCGTCAATATCCGTATATCTGTCCGAGCTTGCGTTCCGTTTCGGGT
                    TGATCGAAGCGAGTACATCCTAGGGACCAACGATTGTCCAAACGCAACTCAACTGGTTCA
                    TATAAGGAGTGTACGTCACGTATTGTAGAAGACCGACGAGCACCCTTGTTTAGCACCTAG
                    GTATTGAAAATGGTACTAGGCCCGCGATAAATAAGGTTAATTGGATCCA""";

  @Test
  public void testGcContentEvaluator() {
    Map.Entry<String, Double> gcContent = GCContentEvaluator.getHighestGCContentFromFasta(fasta);
    Assert.assertEquals("Rosalind_9226", gcContent.getKey());
    Assert.assertEquals(51.52998776009792, gcContent.getValue(), 0.0001);
  }
}
