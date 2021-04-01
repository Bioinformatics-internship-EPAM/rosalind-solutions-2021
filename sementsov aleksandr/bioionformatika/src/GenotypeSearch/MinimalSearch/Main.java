package GenotypeSearch.MinimalSearch;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    public static Map<String, Integer> headerChromosomes = new TreeMap<>(); //будет заменено на решение из VCF-fileReader

    public static String[] matchHeaders(String source) {
        List<String> preResult = new ArrayList<>();
        String[] result;
        for (String key: headerChromosomes.keySet()) {
            if (key.indexOf(source) != -1) {
                preResult.add(key);
            }
        }
        result = new String[preResult.size()];
        for (int k = 0; k < preResult.size(); k++) {
            result[k] = preResult.toArray()[k].toString();
        }
        return result;
    }

    public static void readBiiigFile() throws IOException { //будет заменено на решение из VCF-fileReader
        try (BufferedReader brReader = new BufferedReader(new FileReader("notbig.csv", StandardCharsets.UTF_8))) {
            Scanner scanner = new Scanner(brReader);

            //запись заголовка
            List<String[]> result = new ArrayList<>();
            String[] header = scanner.nextLine().split("\t");
            for (int i = 0; i < header.length; i++) {
                headerChromosomes.put(header[i], i);
            }

            //HG - это образцы
            //Результат: ID; Значение образца

            //попытка поиска заголовка
            String[] matchedHeaders = matchHeaders("HG0011");

            //запись данных
            while (true) {
                try {
                    result.add(scanner.nextLine().split("\t"));
                }
                catch (NoSuchElementException eo) {
                    break;
                }
            }
            System.out.println(result.get(11)[10]); //Должен быть DP=5215, потому что: 11 = 13 - 1(отсчёт с 0) - 1(строка заголовка); 10 = С11 - 1(отсчёт с нуля)
        }
    }

    public static void main(String[] args) {
        try {
            readBiiigFile();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\n\n\t\t->\t\tшо-то пошло не так (см. выше)");
        }
        finally {
            System.out.println("\nНу прога, по крайне мере, запустилась :)\n");
        }
    }
}
