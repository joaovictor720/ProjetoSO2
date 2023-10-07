import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Passe o nome do arquivo de entrada");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String temp;
        int numOfFrames = Integer.parseInt(reader.readLine());
        List<Integer> requestSequence = new ArrayList<>();

        while ((temp = reader.readLine()) != null) {
            requestSequence.add(Integer.parseInt(temp));
        }
        SubstitutionAlgorithm fifo = new FIFO(numOfFrames, requestSequence, "FIFO");
        fifo.run();
        fifo.print();

        SubstitutionAlgorithm otm = new OTM(numOfFrames, requestSequence, "OTM");
        otm.run();
        otm.print();

        SubstitutionAlgorithm lru = new LRU(numOfFrames, requestSequence, "LRU");
        lru.run();
        lru.print();

        reader.close();
    }
}