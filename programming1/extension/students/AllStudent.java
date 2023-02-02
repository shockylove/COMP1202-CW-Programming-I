package students;

import building.Building;

/**
 * Addition variable: currentDelay
 * Addition methods: getClassName/ normalAttack
 * <p>
 * All types of students override defence
 */
public abstract class AllStudent implements Student {
    protected int level;
    protected int baseDelay, baseAttack;
    protected int currentDelay;

    public AllStudent(int level, int baseAttack, int baseDelay) {
        this.baseAttack = baseAttack;
        this.level = level;
        this.baseDelay = baseDelay;
        this.currentDelay = baseDelay;  /** to count delay */
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void increaseLevel() {
        level++;
    }

    @Override
    public int upgradeCost() {
        return (100 * (int) Math.pow(2, level));
    }

    public String getClassName() {  //get Student type
        return this.getClass().getSimpleName();
    }

    protected int normalAttack() {
        return (int) (Math.round(baseAttack * Math.pow(level, 1.2)));
    }

    @Override
    public abstract int defence(Building building);
}
