package ru.spbstu.tasks;

import java.util.ArrayList;
import java.util.List;

public class DnaMotifTask {
    private String dnaString;

    public DnaMotifTask(String dnaString) {
        this.dnaString = dnaString;
    }

    public List<Integer> countLocationsOfSubstring(String substring) {
        List<Integer> listOfIndexes = new ArrayList<>();
        int index = this.dnaString.indexOf(substring);
        listOfIndexes.add(index + 1);
        while (true) {
            index = this.dnaString.indexOf(substring, index + 1);
            if (index > 0) {
                listOfIndexes.add(index + 1);
            } else {
                break;
            }
        }
        return listOfIndexes;
    }
}
