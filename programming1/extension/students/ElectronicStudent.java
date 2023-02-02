package students;

import bugs.Bug;
import building.Building;

/**
 * Base attributes: Attack-6; Delay-6
 * Special ability: force the first bug baseSteps increase by 2
 * */
public class ElectronicStudent extends AllStudent{
    public ElectronicStudent(int level) {
        super(level, 6, 6);
    }

    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            bugs[0].changeBaseSteps(2);
            currentDelay = baseDelay;
        } else {    //do normal attack
            bugs[0].damage(normalAttack());
            currentDelay -= 1;
        }
        if (bugs[0].getCurrentHp() < 1) { //
            building.removeBug(bugs[0]);    //remove the bug
            kp = (bugs[0].getLevel() * 20);   //knowledge point
        }
        return kp;
    }
}
