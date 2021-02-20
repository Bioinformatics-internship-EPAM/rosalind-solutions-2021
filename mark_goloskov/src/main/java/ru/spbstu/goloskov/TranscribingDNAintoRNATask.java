package ru.spbstu.goloskov;

import ru.spbstu.goloskov.utils.Utils;

import java.util.List;

public class TranscribingDNAintoRNATask {
    public static void main(String[] args) throws Exception {
        List<String> lines = Utils.readDataset(Utils.TRANSCRIBE_DNA_RNA);
        System.out.println(lines.get(0).replace('T', 'U'));
    }
}
