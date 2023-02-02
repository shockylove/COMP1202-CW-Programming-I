import bugs.Bug;
import building.Building;
import students.AllStudent;
import students.Team;

/**
 * Strategy:
 * 1. let all bugs get in the building
 * 2. start the one wave within the specific steps
 * 3. recruit & upgrade students ---> strategy: Upgrade after priority recruitment
 * 4. bugs move & attack building
 * 5. students act
 * 6. print
 */
public class Battle {
    private Team team;
    private Building building;

    public Battle(Team team, Building building) {
        this.team = team;
        this.building = building;
    }

    public void start(int battleSteps) {
        building.letBugsIn();

        for (int i = 1; i <= battleSteps; i++) {
            manageTeam();
            building.bugsMove();

            if (building.getAllBugs().length > 0) {
                team.studentsAct(building);
                step(team, building);
            } else {
                step(team, building);
                System.out.println("NO BUGS EXIST IN THE BUILDING");
                System.out.println("NEXT WAVE COMING!!!");
                break;
            }
        }
    }

    public void manageTeam() {
        System.out.println("ONE RUN STARTS");
        int oneTurnCost = 0;
        /** 1.recruit & upgrade students ---> strategy: first recruit then upgrade  */
        try {
            if (team.getKnowledgePoint() >= team.getNewStudentCost() || building.getAllBugs().length == 0) {
                team.recruitNewStudent();
                oneTurnCost = team.getNewStudentCost();
            } else if (team.getKnowledgePoint() < team.getNewStudentCost()
                    && team.getKnowledgePoint() >= team.getLowestLevel().upgradeCost()) {
                team.upgrade(team.getLowestLevel());
                oneTurnCost = team.getNewStudentCost();
            } else {
                System.out.println("NO Recruit & Upgrade");
            }
            System.out.println("Recruiting & Upgrade cost: " + oneTurnCost);
        } catch (Exception e) {
            System.out.println("Not enough KnowledgePoint");
        }
    }

    public void step(Team team, Building building) {

        /**Team information*/
        System.out.println("Current KP: " + team.getKnowledgePoint());

        System.out.println("Students Type & its Level: ");
        for (AllStudent st : team.getStudents()
        ) {
            System.out.print("(" + st.getClassName() + " " + "," + st.getLevel() + "); ");
        }
        System.out.println(" ");

        /**Building information*/
        System.out.println("Current Construction Point: " + building.getConstructionPoints());
        System.out.println("Bug type, Current Floor, Current Steps, Level & HP : ");
        for (Bug bug : building.getAllBugs()
        ) {
            System.out.println("(" + bug.getName() + "," + bug.getClassName() + "," + bug.getCurrentFloor()
                    + "," + bug.getCurrentSteps() + "," + bug.getLevel() + "," + bug.getCurrentHp() + ");");
        }

        System.out.println("ONE RUN OVER");
        System.out.println(" ");
    }

}
