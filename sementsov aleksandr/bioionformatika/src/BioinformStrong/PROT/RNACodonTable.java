package BioinformStrong.PROT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class RNACodonTable {

    public Map<String, String> codonList;

    BufferedReader runToRead() throws IOException {
        try (BufferedReader brReadr = new BufferedReader(new FileReader("RNA-codon-table.txt", StandardCharsets.UTF_8))) {
            return brReadr;
        }
    }

    RNACodonTable() {
        try {
            codonList = new TreeMap<>();
            FileReader reader = new FileReader("RNA-codon-table.txt", StandardCharsets.UTF_8);
            Scanner scanner = new Scanner(reader);
            char currentCharacter = ' ';
            String[] elements;
            StringBuilder[] currentSequence = new StringBuilder[2];

            //работа с файлом
            while (true) {

                //будущая задумка
                //elements = scanner.nextLine().split("\s+"); //учесть пробел (\s), имеющий длину не меньше одного символа (+)

                //ОЧИСТКА ПРОБЕЛОВ перед записью ключа последовательности
                while (currentCharacter == ' ' || currentCharacter == '\n') {
                    currentCharacter = (char) reader.read();
                }
                if (currentCharacter == (char) (-1)) {
                    break;
                }
                else {

                    //ЗАПИСЬ КЛЮЧА данной последовательности
                    do  {
                        currentSequence[0].append(currentCharacter);
                    } while ((currentCharacter = (char) reader.read()) != ' ' && currentCharacter != '\n' && currentCharacter != (char) (-1));
                    if (currentCharacter == (char) (-1)) {
                        break;
                    }
                    else {

                        //ОЧИСТКА ПРОБЕЛОВ перед записью значения последовательности
                        while (currentCharacter == ' ' || currentCharacter == '\n') {
                            currentCharacter = (char) reader.read();
                        }
                        if (currentCharacter == (char) (-1)) {
                            break;
                        }
                        else {

                            //ЗАПИСЬ ЗНАЧЕНИЯ данной последовательности
                            do  {
                                currentSequence[1].append(currentCharacter);
                            } while ((currentCharacter = (char) reader.read()) != ' ' && currentCharacter != '\n' && currentCharacter != (char) (-1));

                            //после того, как запишем значение данной последовательности, внесём получившееся данные в дерево данных
                            codonList.put(currentSequence[0].toString(), currentSequence[1].toString());
                            currentSequence[0] = new StringBuilder();
                            currentSequence[1] = new StringBuilder();
                        }
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
