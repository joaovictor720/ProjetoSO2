import java.util.LinkedList;
import java.util.List;

public class OTM extends SubstitutionAlgorithm {
    
    OTM(int numOfFrames, List<Integer> readSequence, String prefix){
        super(numOfFrames, readSequence, prefix);
        this.memory = new LinkedList<>();
    }

    public void run() {
        for (int i = 0; i < readSequence.size(); i++){
            if (!memoryContains(readSequence.get(i))){
                faultCounter++;
                if (memory.size() == frameCount) {
                    Page farthestPage = null;
                    int biggestDistance = 0;
                    if (DEBUG) {
                        System.out.print("MEMORY ");
                        for (Page page : memory)
                            System.out.print(page.pageNumber + " ");
                        System.out.println("REQUESTING " + readSequence.get(i));
                    }
                    for (Page pageInMemory : memory) {
                        int distance = 1;
                        for (int j = i+1; j < readSequence.size(); j++) {
                            if (readSequence.get(j) != pageInMemory.pageNumber) {
                                distance++;
                            } else {
                                break;
                            }
                        }
                        if (DEBUG)
                            System.out.println("distance of page " + pageInMemory.pageNumber + " = " + distance);
                        if (distance > biggestDistance) {
                            farthestPage = pageInMemory;
                            biggestDistance = distance;
                        }
                    }
                    memory.remove(farthestPage);
                    memory.add(new Page(readSequence.get(i)));
                } else {
                    memory.add(new Page(readSequence.get(i)));
                }
            }
        }
    }

}
