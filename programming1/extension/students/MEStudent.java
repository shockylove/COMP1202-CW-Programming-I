package students;

import bugs.Bug;
import building.Building;

/**
 * Base attributes: Attack-15; Delay-0
 * Special ability: gain 3 times KP after kill bugs
 * */
public class MEStudent extends AllStudent{

    public MEStudent(int level) {
        super(level, 15, 0);
    }

    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;
        bugs[0].damage(normalAttack());
        if (bugs[0].getCurrentHp() < 1) { //
            building.removeBug(bugs[0]);    //remove the bug
            kp = (bugs[0].getLevel() * 20 * 3);   //knowledge point
        }
        return kp;
    }
}
