import java.util.LinkedList;
import java.util.List;

public class FIFO extends SubstitutionAlgorithm {
    
    public FIFO(int numOfFrames, List<Integer> readSequence) {
        super(numOfFrames, readSequence);
        this.pagesInMemory = new LinkedList<>();
    }
    
    public void run() {
        for (int i = 0; i < this.readSequence.size(); i++) {
            if (!pagesInMemory.contains(readSequence.get(i))){
                this.numOfFaults++;
                pagesInMemory.poll();
                pagesInMemory.add(readSequence.get(i));
            }
        }
    }

}
