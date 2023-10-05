import java.util.List;

public abstract class SubstitutionAlgorithm {
    public int numOfFrames;
    public int numOfFaults;
    public String prefix = "ABSTRACT";
    public List<Page> pagesInMemory;
    public List<Integer> readSequence;

    abstract public void run();

    public SubstitutionAlgorithm(int numOfFrames, List<Integer> readSequence) {
        this.numOfFrames = numOfFrames;
        this.readSequence = readSequence;
    }

    public void print() {
        System.out.println(prefix + " " + numOfFaults);
    }
}
