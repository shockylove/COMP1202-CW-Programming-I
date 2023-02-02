package students;


import bugs.Bug;
import building.Building;

public class AiStudent extends AllStudent implements Student {
    public AiStudent(int level) {
        super(level, 7, 7);
    }

    /**
     * return KP which is gotten after this defence
     */
    @Override
    public int defence(Building building) {

        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            int firstThr = 0;
            {
                if (bugs.length > 3) {
                    firstThr = 3;
                }
            }
            for (int i = 0; i < firstThr; i++) {
                bugs[i].damage(normalAttack());
                if (bugs[i].getCurrentHp() < 1) { //
                    building.removeBug(bugs[0]);    //remove the bug
                    kp = (bugs[0].getLevel() * 20);   //knowledge point
                }
            }
            currentDelay = baseDelay;
        } else {    //do normal attack
            bugs[0].damage(normalAttack());
            currentDelay -= 1;
            if (bugs[0].getCurrentHp() < 1) { //
                building.removeBug(bugs[0]);    //remove the bug
                kp = (bugs[0].getLevel() * 20);   //knowledge point
            }
        }


        return kp;
    }


}
