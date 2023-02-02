package students;

import bugs.Bug;
import building.Building;

/**
 * Base attributes: Attack-60; Delay-10
 * Special ability: heal building
 *                  heal amount is (1+level)
 * */
public class BEStudent extends AllStudent implements Student{
    private int heal;

    public BEStudent(int level) {
        super(level, 60, 10);
        heal = 1+level;
    }

    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            building.getHeal(heal);
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
