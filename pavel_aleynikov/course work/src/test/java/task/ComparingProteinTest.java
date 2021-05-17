package task;

import dto.Protein;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.fasta.FASTAItem;

import java.util.ArrayList;
import java.util.List;

public class ComparingProteinTest {

    @Test
    void testParseFastaLabel() {
        FASTAItem sourceItem = new FASTAItem("QIH45051.1/location:29558..29674", "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT");
        List<Protein> proteins = ComparingProtein.convertFastsToProtein(List.of(sourceItem));

        Protein resultProtein = new Protein("QIH45051.1",
                29558,
                29674,
                "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT");
        Assertions.assertEquals(proteins.get(0), resultProtein);
    }

    @Test
    void testCompareProteinSuccess() {
        Protein definedProtein = new Protein("QIH45051.1",
                29558,
                29674,
                "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT");
        Protein computedProtein = new Protein(29588,
                29704,
                "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT");
        Assertions.assertEquals(ComparingProtein.analyze(List.of(definedProtein), List.of(computedProtein)), 1);
    }

    @Test
    void testCompareProteinWithUnSuccess() {
        List<Protein> definedProteins = new ArrayList<>(2);
        definedProteins.add(new Protein("QIH45051.1",
                29558,
                29674,
                "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT"));
        definedProteins.add(new Protein("QIH45047.1",
                27202,
                27387,
                "MFHLVDFQVTIAEILLIIMRTFKVSIWNLDYIINLIIKNLSKSLTENKYSQLDEEQPMEID"));
        List<Protein> computedProteins = new ArrayList<>(2);
        computedProteins.add(new Protein(29558,
                29674,
                "MGYINVFAFPFTIYSLLLCRMNSRNYIAQVDVVNFNLT"));
        computedProteins.add(new Protein(27205,
                27384,
                "MFHLVDFQVTIAEILLIIMRTFKVSIWNLDYIINLIIKNLSKSLTENKYSQLDEEQPME"));
        Assertions.assertEquals(ComparingProtein.analyze(definedProteins, computedProteins), 1);
    }

}
