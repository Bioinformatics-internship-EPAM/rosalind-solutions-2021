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
            switch (c) {
                case 'A':
                    reverseComplDna.append('T');
                    break;
                case 'C':
                    reverseComplDna.append('G');
                    break;
                case 'T':
                    reverseComplDna.append('A');
                    break;
                case 'G':
                    reverseComplDna.append('C');
                    break;
            }
        }
        return reverseComplDna.toString();
    }
}
