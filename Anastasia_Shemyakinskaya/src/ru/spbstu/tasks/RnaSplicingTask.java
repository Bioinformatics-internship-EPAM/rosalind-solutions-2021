package ru.spbstu.tasks;

import ru.spbstu.utils.FileUtils;

import java.io.IOException;
import java.util.Map;

public class RnaSplicingTask {

    public String spliceDna() throws IOException {
        Map<String, String> dnaMap = FileUtils.readFastaFileAndReturnDnaMap("splicing_rna.fasta");
        String dnaString = dnaMap.values().stream().findFirst().get();
        dnaMap.values().remove(dnaString);
        for (String itron : dnaMap.values()) {
            dnaString = dnaString.replaceAll(itron, "");
        }
        TranscribeDnaTask rnaTask = new TranscribeDnaTask(dnaString);
        String rna = rnaTask.transformToRna();
        ProteinTranslationTask protTask = new ProteinTranslationTask(rna);
        return protTask.constructProteinChain();
    }
}
