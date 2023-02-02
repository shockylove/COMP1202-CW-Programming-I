package bugs;

/**
 * Super() method is different from the one in PDF
 * one more parameter---damage
 */
public class ConcurrentModificationBug extends Bug {

    public ConcurrentModificationBug(String name, int level, int initialSteps) {
        super(name, 20, 4, level, initialSteps, 2);
    }

}
