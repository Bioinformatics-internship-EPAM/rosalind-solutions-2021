package BioinformStrong.SUBS;

public class Main {

    final static String pathSUBSTask = "rosalind_subs";

    public static void main(String[] args) {

        //To load dataset
        ParserForSUBS parserForSUBS = new ParserForSUBS(pathSUBSTask);

        MyMatchers.letsFind(parserForSUBS.getSource(), parserForSUBS.getMatch(), MyMatchers.typeMatchers.KnuthMorrisPratt);
    }
}
