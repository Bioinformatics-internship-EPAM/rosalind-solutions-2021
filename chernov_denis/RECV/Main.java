package RECV;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        int i;
        try (FileInputStream fileInputStream = new FileInputStream("src/RECV/rosalind_revc.txt")) {
            while ((i = fileInputStream.read()) != -1) {
                switch (i) {
                    case 'A' -> stack.push('T');
                    case 'G' -> stack.push('C');
                    case 'C' -> stack.push('G');
                    case 'T' -> stack.push('A');
                }
            }
        }
        while ( !stack.isEmpty())
            System.out.print(stack.pop());
    }
}