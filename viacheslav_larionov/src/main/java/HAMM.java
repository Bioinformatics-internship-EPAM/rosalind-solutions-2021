import java.util.List;

public class HAMM {

    // Counting Point Mutations
    public static void main(String[] args) {
        List<String> dnaStrings = Utils.readDNAStringsFromFile("hamm.txt");

        if (dnaStrings.size() == 2
                && (dnaStrings.get(0).length() == dnaStrings.get(1).length())) {
            System.out.println(Utils.hammingDistance(dnaStrings.get(0), dnaStrings.get(1)));
        }
    }
}
