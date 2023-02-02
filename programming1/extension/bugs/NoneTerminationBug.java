package bugs;

/**
 * Super() method is different from the one in PDF
 * one more parameter---damage
 */
public class NoneTerminationBug extends Bug {

    public NoneTerminationBug(String name, int level, int initialSteps) {
        super(name, 200, 6, level, initialSteps, 4);
    }
}