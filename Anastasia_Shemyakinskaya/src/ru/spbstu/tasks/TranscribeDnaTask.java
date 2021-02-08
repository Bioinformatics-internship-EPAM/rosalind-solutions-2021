package ru.spbstu.tasks;

public class TranscribeDnaTask {
    private String dnaString;

    public TranscribeDnaTask(String dnaString) {
        this.dnaString = dnaString;
    }

    public String transformToRna() {
       return dnaString.replace('T', 'U');
    }
}
