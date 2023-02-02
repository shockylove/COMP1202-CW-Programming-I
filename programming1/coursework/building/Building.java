package building;

import bugs.Bug;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * No addition variables
 * Addition methods: LetBugsIn/
 */
public class Building {
    private int constructionPoints;
    private int topFloor;
    private ArrayList<Bug> bugs = new ArrayList<Bug>();

    public Building(int topFloor, int constructionPoints) {
        this.topFloor = topFloor;
        this.constructionPoints = constructionPoints;

    }

    public int getTopFloor() {
        return topFloor;
    }

    public int getConstructionPoints() {
        return constructionPoints;
    }

    public Bug[] getAllBugs() {
        ArrayList<Bug> bugsInBuilding = new ArrayList<>();//create a arrayList for bug that is alive (Hp > 0) and Floor not equals to -1.

        for (Bug bug : bugs) {
            if (bug.getCurrentHp() > 0 && bug.getCurrentFloor() != -1) {
                bugsInBuilding.add(bug);
            } else if (bug.getCurrentHp() <= 0) {
                bugsInBuilding.remove(bug);
            } else {
            }
        }

        bugsInBuilding.sort(new Comparator<Bug>() {

            @Override
            public int compare(Bug o1, Bug o2) {
                if (o1.getCurrentFloor() == o2.getCurrentFloor()) {
                    if (o1.getCurrentSteps() < o2.getCurrentSteps()) {
                        return -1;
                    }
                    //return 0;
                } else if (o1.getCurrentFloor() > o2.getCurrentFloor()) {
                    return -1;
                } else if (o1.getCurrentFloor() < o2.getCurrentFloor()) {
                    return 1;
                }
                return 0;

            }
        });
        Bug[] bugArray = new Bug[bugsInBuilding.size()];
        bugArray = bugsInBuilding.toArray(bugArray);
        return bugArray;
    }

    public int addBug(Bug bug) {
        if (bugs.contains(bug)) {
            return -1;
        } else {
            bugs.add(bug);
            return bugs.size();
        }
    }

    public void removeBug(Bug bug) {
        bugs.remove(bugs.indexOf(bug));
    }

    public void bugsMove() {
        Bug bugToRemove = null;
        try {
            System.out.println("All Bugs Move One Step");
            for (Bug bug : bugs) {
                bug.move();
                if (bug.getCurrentFloor() == getTopFloor()) {
                    constructionPoints = getConstructionPoints() - bug.getAttack();
                    bugToRemove = bug;
                    System.out.println(bug.getName() + " Reached the top floor, doing " + bug.getAttack() + " damage!");
                    System.out.println("Building Construction Points Remaining: " + constructionPoints + "\n");
                }
                if (constructionPoints < 1) {
                    System.out.println("\nTHE BUILDING HAS BEEN OVERRUN BY THE BUGS. BETTER LUCK NEXT TIME...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bugToRemove != null) {
                bugs.remove(bugToRemove);
            }
        }
    }

    /**
     * Let all bugs get in building
     */
    public void letBugsIn() {
        for (Bug bug : bugs
        ) {
            bug.letBugGetIn();
        }
    }
}






