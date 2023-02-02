package bugs;
/**
 * DestroyBug: HP-20; base Steps-5; damage-4
 * When move into a new floor, damage increases by 1， no limit
 * */
public class DestroyBug extends Bug implements SpecialAbility{

    public DestroyBug(String name, int level, int initialSteps) {
        super(name, 20, 5, level, initialSteps, 4);
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
        this.damage++;
    }
}
