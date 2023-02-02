package bugs;

/**
 * HealBug: HP-300; base Steps-6; damage-1
 * When move into a new floor, HP increases by 100， no limit
 * */
public class HealBug extends Bug implements SpecialAbility{
    public HealBug(String name, int level, int initialSteps) {
        super(name, 300, 6, level, initialSteps, 1);
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
        this.baseHp += 10;
    }


}

