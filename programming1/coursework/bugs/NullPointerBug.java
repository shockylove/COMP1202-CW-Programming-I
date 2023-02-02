package bugs;

/**
 * Super() method is different from the one in PDF
 * one more parameter---damage
 */
public class NullPointerBug extends Bug {
    public NullPointerBug(String name, int level, int initialSteps) {
        super(name, 10, 2, level, initialSteps, 1);
    }
}
