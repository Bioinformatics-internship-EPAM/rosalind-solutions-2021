package ru.spbstu;

import ru.spbstu.tasks.*;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args){
        System.out.println("Task #1 Counting DNA Nucleotides");
        CountNucleotidsTask dnaTask = new CountNucleotidsTask("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");
        dnaTask.countNucleotides().forEach((k, v) -> System.out.println("Nucleotide: " + k + " count: " + v));
        System.out.println("-------------------------------------------------");

        System.out.println("Task #2 Transcribing DNA into RNA");
        TranscribeDnaTask rnaTask = new TranscribeDnaTask("GATGGAACTTGACTACGTAAATT");
        System.out.println(rnaTask.transformToRna());
        System.out.println("-------------------------------------------------");

        System.out.println("Task #3 Complementing a Strand of DNA");
        ReverseComplementTask recvTask = new ReverseComplementTask("AAAACCCGGT");
        System.out.println(recvTask.reverseDna());
        System.out.println("-------------------------------------------------");

        System.out.println("Task #4 Computing GC Content");
        ComputeGCTask gcTask = new ComputeGCTask();
        try {
            gcTask.countMaxGC();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(gcTask.getMaxId() + " " + gcTask.getMaxPercentage());
        System.out.println("-------------------------------------------------");

        System.out.println("Task #5 Counting Point Mutations");
        HammingDistanceTask hammTask = new HammingDistanceTask("GAGCCTACTAACGGGAT", "CATCGTAATGACGGCCT");
        System.out.println("Hamming distance: " + hammTask.evaluateHammingDistance());
        System.out.println("-------------------------------------------------");

        System.out.println("Taks #6 Translating RNA into Protein");
        ProteinTranslationTask protTask = new ProteinTranslationTask("AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA");
        System.out.println(protTask.constructProteinChain());
        System.out.println("-------------------------------------------------");

        System.out.println("Task #7 Finding a Motif in DNA");
        DnaMotifTask subsTask = new DnaMotifTask("GATATATGCATATACTT");
        List<Integer> locations = subsTask.countLocationsOfSubstring("ATAT");
        locations.forEach(i -> System.out.print(i + " "));
        System.out.println();
        System.out.println("-------------------------------------------------");

        System.out.println("Task #8 Finding a Shared Motif");
        SharedMotifTask lcsmTask = new SharedMotifTask();
        try {
            System.out.println(lcsmTask.countMaxSubstring());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------");

        System.out.println("Task #9 RNA Splicing");
        RnaSplicingTask splcTask = new RnaSplicingTask();
        try {
            System.out.println(splcTask.spliceDna());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------");

        System.out.println("Task #10 Calculating Protein Mass");
        ProteinMassTask prtmTask = new ProteinMassTask("SKADYEK");
        try {
            System.out.println(prtmTask.countWeight());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
