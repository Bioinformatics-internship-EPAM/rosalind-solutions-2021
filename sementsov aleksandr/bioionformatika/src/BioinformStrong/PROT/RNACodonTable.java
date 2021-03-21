package BioinformStrong.PROT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class RNACodonTable {

    final String codonTableFile = "RNA-codon-table.txt";

    public Map<String, String> codonList;

    RNACodonTable() throws IOException {
        try (BufferedReader brReader = new BufferedReader(new FileReader(codonTableFile, StandardCharsets.UTF_8))) {
            codonList = new TreeMap<>();
            Scanner scanner = new Scanner(brReader);
            String readString;
            String[] elementsInString;
            String[] currentSequence = new String[2];
            int elementIndex = 0;

            //работа с файлом
            while (true) {
                try {
                    readString = scanner.nextLine(); //если строка будет присутствовать, то программа продолжит работу
                    elementsInString = readString.split("\s+"); //учесть пробел (\s), имеющий длину не меньше одного символа (+)

                    //рассмотрим пары, имеющиеся в извлечённой строке
                    for (String s : elementsInString) {
                        currentSequence[elementIndex % 2] = s;

                        //если пара целиком записана, то можно добавить добавить в словарь
                        if (elementIndex % 2 == 1) {
                            codonList.put(currentSequence[0], currentSequence[1]);
                        }
                        elementIndex++;
                    }
                }
                catch (NoSuchElementException e) {
                    break;
                }
            }
        }
    }
}
