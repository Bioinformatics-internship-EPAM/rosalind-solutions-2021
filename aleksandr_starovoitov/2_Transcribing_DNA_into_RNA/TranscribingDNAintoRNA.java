public class TranscribingDNAintoRNA {
    private static final String FileName = "rosalind_rna.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName).get(0);

        var result = getResult(input);

        System.out.println(result);
    }

    private static String getResult(String input) {
        return input.replace('T', 'U');
    }
}
