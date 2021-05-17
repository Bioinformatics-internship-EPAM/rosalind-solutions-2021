package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DNAIntoRNATranscribingTest {

    @Test
    void testOnNormalDataset() {
        String result = DNAIntoRNATranscribing.transcribe("GATGGAACTTGACTACGTAAATT");
        Assertions.assertEquals("GAUGGAACUUGACUACGUAAAUU", result);
    }

}
