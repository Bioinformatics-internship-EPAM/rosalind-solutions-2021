package RNA;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/RNA/rosalind_rna.txt");
        int i;
        while((i=fileInputStream.read())!= -1) {
            if (i == 'T')
                System.out.print('U');
            else
                System.out.print((char) i);
        }
    }
}