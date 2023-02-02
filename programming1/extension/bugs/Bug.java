package bugs;

/**
 * addition variable: damage
 * addition method: Constructor with 6 parameter/ etAttack(the get method of damage)/ getClassName/ LetBugGetIn
 */
public class Bug {
    protected String name;
    protected int baseHp;
    protected int baseSteps;
    protected int level;

    protected int currentHp;
    protected int currentSteps;
    protected int currentFloor = -1;
    protected int damage = 1;

    /**
     * the basic damage its sub-bugs inheritance
     */

    public Bug() {
        if(this.level < 1 ){
            this.level = 1;
        } else if(this.damage < 1){
            this.damage = 1;
        }
    }

    public Bug(String name, int baseHp, int baseSteps, int level) {
        this.name = name;
        this.baseHp = baseHp;
        this.baseSteps = baseSteps;
        this.level = level;
    }

    /**
     * New constructor
     */
    public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps, int damage) {
        this.name = name;
        this.currentHp = (int) Math.round(baseHp * Math.pow(level, 1.5));
        this.baseSteps = baseSteps;
        this.level = level;
        this.currentSteps = initialSteps;
        this.damage = damage;
    }

    public Bug(String name, int baseHp, int baseSteps, int level, int initialSteps) {
        this.name = name;
        this.currentHp = (int) Math.round(baseHp * Math.pow(level, 1.5));
        this.baseSteps = baseSteps;
        this.level = level;
        this.currentSteps = initialSteps;
    }

    public int getBaseSteps() {
        return baseSteps;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getCurrentSteps() {
        return currentSteps;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getAttack() {
        return damage;
    }

    /**
     * getter method for bug type
     */
    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    //set method
    public void damage(int amount) {
        this.currentHp -= amount;
        if (this.currentHp <= 0) {
            this.currentHp = 0;
        }
    }

    /**
     * Let one bug outside building get in
     */
    public void letBugGetIn() {
        this.currentFloor = 0;
    }

    public void move() {
        if (currentSteps > 0) {
            currentSteps--;
        } else {
            currentFloor++;
            currentSteps = getBaseSteps() - 1;
        }
    }

    public void slowDown(int steps) {
        currentSteps += steps;
    }


    /** below methods are only for extensions*/

    public void changeBaseSteps(int amount){
        this.baseSteps += amount;
    }

    public void decreaseCurrentFloor(){
        this.currentFloor--;
    }

    public void decreaseDamage(){
        this.damage--;
    }
}
