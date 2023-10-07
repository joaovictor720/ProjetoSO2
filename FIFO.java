import java.util.LinkedList;
import java.util.List;

public class FIFO extends SubstitutionAlgorithm {
    
    public FIFO(int numOfFrames, List<Integer> readSequence, String prefix){
        super(numOfFrames, readSequence, prefix);
        this.memory = new LinkedList<>();
    }
    
    public void run() {
        for (int i = 0; i < readSequence.size(); i++){
            if (!memoryContains(readSequence.get(i))){
                faultCounter++;
                if (memory.size() == frameCount) {
                    memory.poll();
                    memory.add(new Page(readSequence.get(i)));
                } else {
                    memory.add(new Page(readSequence.get(i)));
                }
            }
        }
    }

}
