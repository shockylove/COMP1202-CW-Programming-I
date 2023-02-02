package students;


import bugs.Bug;
import building.Building;

public class SeStudent extends AllStudent implements Student {
    public SeStudent(int level) {
        super(level, 5, 6);
    }

    /**
     * return KP which is gotten after this defence
     */
    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            int firstFiv = building.getAllBugs().length;
            {
                if (firstFiv > 5) {
                    firstFiv = 5;
                }
            }
            for (int i = 0; i < firstFiv; i++) {
                bugs[i].slowDown(2);
            }
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
