package students;

import bugs.Bug;
import building.Building;

/**
 * Base attributes: Attack-80; Delay-10
 * Special ability: build one more topFloor for the building
 *                  the probability is (1+level)% , and max value is 10
 * */
public class AEEStudent extends AllStudent implements Student{
    private int probability;

    public AEEStudent(int level) {
        super(level, 80, 10);
        probability =  1 + level;
        if (probability >= 10) {
            probability = 10;
        }
    }

    @Override
    public int defence(Building building) {
        Bug[] bugs = building.getAllBugs();
        int kp = 0;     //to count the kp after special attack

        if (currentDelay == 1 ) { //do special ability
            if (countProbability() <= probability) {
                building.increaseTopFloor(1);
            } else {}
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

    /**
     * take Integer from Toolbox, pass it
     */
    public int countProbability() {
        Toolbox myTB = new Toolbox();
        return myTB.getRandomInteger(100);
    }
}
