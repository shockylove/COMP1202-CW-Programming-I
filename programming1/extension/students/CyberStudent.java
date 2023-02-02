package students;


import bugs.Bug;
import building.Building;

/**
 * Addition methods: getProbability/ countProbability
 */
public class CyberStudent extends AllStudent implements Student {
    private int probability;

    public CyberStudent(int level) {
        super(level, 7, 8);
        probability = 20 + level;
        if (probability >= 50) {
            probability = 50;
        }
    }

    @Override
    public int defence(Building building) {
        /**
         * return KP which is gotten after this defence
         */
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1) { //do special ability
            if (countProbability() < getProbability()) { //special ab1
                building.removeBug(bugs[0]);
                kp = (bugs[0].getLevel() * 20);
            } else {    //special ab2
                bugs[0].damage(normalAttack() * 2);
                if (bugs[0].getCurrentHp() < 1) { //
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

    /**
     * count the probability
     */
    public int getProbability() {
        return probability;
    }

    /**
     * take Integer from Toolbox, pass it
     */
    public int countProbability() {
        Toolbox myTB = new Toolbox();
        return myTB.getRandomInteger(100);
    }
}
