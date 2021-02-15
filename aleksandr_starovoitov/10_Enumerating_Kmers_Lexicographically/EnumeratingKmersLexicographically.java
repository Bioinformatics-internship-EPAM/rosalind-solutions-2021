public class EnumeratingKmersLexicographically {
    private static final String FileName = "rosalind_lexf.txt";

    public static void main(String[] args) throws Exception {
        var input = FileUtils.readFromFile(FileName);

        getResult(input.get(0), input.get(1));
    }

    private static void getResult(String first, String second) {
        var str = first.replace(" ", "");
        int count = Integer.parseInt(second);

        combination(str, count, new StringBuffer());
    }

    private static void combination(String input, int depth, StringBuffer output) {
        if (depth == 0) {
            System.out.println(output);
        } else {
            for (int i = 0; i < input.length(); i++) {
                output.append(input.charAt(i));
                combination(input, depth - 1, output);
                output.deleteCharAt(output.length() - 1);
            }
        }
    }
}
