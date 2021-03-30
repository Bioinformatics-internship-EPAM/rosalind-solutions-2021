package BioinformStrong.SUBS;

import java.io.IOException;

public class Main {

    final static String pathSUBSTask = "rosalind_subs";

    public static void main(String[] args) {

        //To load dataset
        ParserForSUBS parserForSUBS = new ParserForSUBS(pathSUBSTask);

        MyMatchers myMatchers = new MyMatchers(parserForSUBS.getSource(), parserForSUBS.getMatch());

        try {
            myMatchers.letsFind(MyMatchers.typeMatchers.KnuthMorrisPratt);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("\n\n\t\t->\t\tMaybe writer wasn't prepared (look up).");
        }
    }
}
