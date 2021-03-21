package BioinformStrong.SUBS;

public class Main {

    final static String pathSUBSTask = "rosalind_subs";

    public static void main(String[] args) {

        //To load dataset
        ParserForSUBS.LetsParse(pathSUBSTask);
        String s = ParserForSUBS.getSource();
        String searchString = ParserForSUBS.getMatch();

        MyMatchers.letsFind(s, searchString, MyMatchers.typeMatchers.KnuthMorrisPratt);
    }
}
