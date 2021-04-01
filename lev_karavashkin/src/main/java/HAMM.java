public class HAMM {
    public static int countPointMutations(String s, String t) {
        if(s.length() == t.length()){
            int counter = 0;

            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();

            for (int i = 0; i < s.length(); i++) {
                if(sArr[i] != tArr[i]) {
                    counter++;
                }
            }
            return counter;
        }

        return -1;
    }
}
