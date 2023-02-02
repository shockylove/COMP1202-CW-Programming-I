package bugs;
/**
 * JumpBug: HP-150; base Steps-6; damage-3
 * When move into a new floor, base steps decrease by 1, at least 1
 * */
public class JumpBug extends Bug implements SpecialAbility{
    public JumpBug(String name, int level, int initialSteps) {
        super(name, 150, 6, level, initialSteps, 3);
    }

    @Override
    public void move(){
        if (currentSteps > 0) {
            currentSteps--;
        } else {
            currentFloor++;
            spAbility();
            currentSteps = getBaseSteps() - 1;
        }
    }

    @Override
    public void spAbility() {
        if (baseSteps >= 2) {
            this.baseSteps--;
        } else {}
    }


}
