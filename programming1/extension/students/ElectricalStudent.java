package students;

import bugs.Bug;
import building.Building;

/**
 * Base attributes: Attack-6; Delay-15
 * Special ability: force the last bug decrease it base damage
 * */
public class ElectricalStudent extends AllStudent{
    public ElectricalStudent(int level) {
        super(level, 6, 15);
    }

    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            bugs[bugs.length - 1].decreaseDamage();
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
