import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        File wordsFile = new File("words.txt");
        File vowelFile = new File("vowel.txt");
        File consonantFile = new File("consonant.txt");

        wordsFile.createNewFile();
        consonantFile.createNewFile();
        vowelFile.createNewFile();

        FileReader fr = new FileReader(wordsFile);
        FileWriter vfw = new FileWriter(vowelFile);
        FileWriter cfw = new FileWriter(consonantFile);

        BufferedReader br = new BufferedReader(fr);
        BufferedWriter vowelWriter = new BufferedWriter(vfw);
        BufferedWriter consonantWriter = new BufferedWriter(cfw);

        String word = "";

        int c;
        while ((c = br.read()) != -1) {
            if (c == '\n' || c == ' ') {
                System.out.println();
                continue;
            }

            System.out.printf("%c", c);

        }

        br.close();
        cfw.close();
        vfw.close();
    }
}
