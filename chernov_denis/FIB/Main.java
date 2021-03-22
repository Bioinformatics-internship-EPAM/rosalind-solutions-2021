package FIB;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Number of months and rabbit life length as input arguments were expected");
            return;
        }
        int months = Integer.parseInt(args[0]);
        int children = Integer.parseInt(args[1]);
        long ancestor = 1L;
        long current = 1L;
        long descendant = 0L;
        for (int i = 2; i < months; i++) {
            descendant = (ancestor * children) + current;
            ancestor = current;
            current = descendant;
        }
        System.out.print(descendant);
    }
}
