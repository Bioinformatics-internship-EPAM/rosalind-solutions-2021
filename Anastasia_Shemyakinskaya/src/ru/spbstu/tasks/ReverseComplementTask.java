package ru.spbstu.tasks;

public class ReverseComplementTask {
    private String dnaString;

    public ReverseComplementTask(String dnaString) {
        this.dnaString = dnaString;
    }

    public String reverseDna() {
        StringBuilder reverseComplDna = new StringBuilder();
        String reverseDna = new StringBuilder(dnaString).reverse().toString();
        for (char c : reverseDna.toCharArray()) {
            if (c == 'A') {
                reverseComplDna.append('T');
            } else if (c == 'C') {
                reverseComplDna.append('G');
            } else if (c == 'T') {
                reverseComplDna.append('A');
            } else if (c == 'G') {
                reverseComplDna.append('C');
            }
        }
        return reverseComplDna.toString();
    }
}
