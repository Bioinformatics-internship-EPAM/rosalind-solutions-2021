package Lab3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/Lab3/rosalind_revc.txt");
        int i;
        Stack<Character> stack = new Stack<>();
        while((i=fileInputStream.read())!= -1) {
            switch (i) {
                case 'A' -> stack.push('T');
                case 'G' -> stack.push('C');
                case 'C' -> stack.push('G');
                case 'T' -> stack.push('A');
            }
        }
        while ( !stack.isEmpty())
            System.out.print(stack.pop());
    }
}