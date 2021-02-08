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
                case 'C':
                    reverseComplDna.append('G');
                case 'T':
                    reverseComplDna.append('A');
                case 'G':
                    reverseComplDna.append('C');
            }
        }
        return reverseComplDna.toString();
    }
}
