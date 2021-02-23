package my.rosalind;

public class CountingPointMutations {
    public int exec(String s, String t) {
        int distance = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
