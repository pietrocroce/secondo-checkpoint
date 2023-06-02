import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> righe = SecondoCheckpoint.processFile("prova.txt");
        Map<String, Integer> mappa = SecondoCheckpoint.processLines(righe);
        SecondoCheckpoint.writeResult("result.txt", mappa);
    }

}
