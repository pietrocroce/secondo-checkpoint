import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondoCheckpoint {

    public static List<String> processFile(String filename) throws IOException {
        /*FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> righe = new ArrayList<>();
        while (bufferedReader.ready()) {
            righe.add(bufferedReader.readLine().trim());
        }
        return righe;*/
        return Files.lines(Path.of(filename)).map(riga -> riga.trim()).toList();
    }

    public static Map<String, Integer> processLines(List<String> lines) {
        Map<String, Integer> mappa = new HashMap<>();
        for (String riga : lines) {
            if (riga.isEmpty()) System.out.println("la riga è vuota!");
            else {
                riga = riga.replaceAll("[^A-Za-z\s]", "").toLowerCase();
                String[] parole = riga.split(" ");
                for (String parola : parole) {
                    // conto le vocali
                    int nVocali = 0;
                    for (int i = 0; i < parola.length(); i++) {
                        char lettera = parola.charAt(i);
                        if (lettera == 'a' || lettera == 'e' || lettera == 'i' || lettera == 'o' || lettera == 'u') {
                            nVocali++;
                        }
                    }
                    mappa.put(parola, nVocali);
                }
            }
        }
        return mappa;
    }

    public static void writeResult(String filename, Map<String,Integer> mappa) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for (String parola : mappa.keySet()) {
            bw.write(parola + " - " + mappa.get(parola) + "\n");
        }
        bw.close();
    }
}