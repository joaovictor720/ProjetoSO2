import java.util.List;
import java.util.Queue;

public abstract class SubstitutionAlgorithm {
    public int frameCount;
    public int faultCounter;
    public String prefix;
    public Queue<Page> memory;
    public List<Integer> readSequence;

    protected boolean DEBUG = false;

    abstract public void run();

    protected boolean memoryContains(int pageNumber) {
        for (Page pageInMemory : memory) {
            if (pageInMemory.pageNumber == pageNumber) {
                return true;
            }
        }
        return false;
    }

    public SubstitutionAlgorithm(int numOfFrames, List<Integer> readSequence, String prefix) {
        this.frameCount = numOfFrames;
        this.readSequence = readSequence;
        this.prefix = prefix;
    }

    public void print() {
        System.out.println(prefix + " " + faultCounter);
    }
}
