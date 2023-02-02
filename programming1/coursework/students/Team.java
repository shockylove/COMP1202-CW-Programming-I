package students;

import building.Building;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Addition variable: cost
 * Addition methods: gianKP/spendKP/studentsAct/getLowestLevel/readRandomInt
 */
public class Team {
    private int knowledgePoint;
    private int studentsNum = 0;
    private int cost = 100;
    private ArrayList<AllStudent> students = new ArrayList<AllStudent>();

    public Team(int knowledgePoint) {
        this.knowledgePoint = knowledgePoint;
    }

    public int getKnowledgePoint() {
        return knowledgePoint;
    }

    public void spendKP(int spend) {
        this.knowledgePoint -= spend;
    }   //set method

    public void gainKP(int gian) {
        this.knowledgePoint += gian;
    }

    public int getNewStudentCost() {
        cost += 10 * studentsNum;
        return cost;
    }

    public ArrayList<AllStudent> getStudents() {
        return students;
    }

    public void recruitNewStudent() throws Exception {
        if (getKnowledgePoint() < getNewStudentCost()) {
            throw new Exception("Not enough KnowledgePoint");
        }

        switch (readRandomInt()) {  // 1/4 probability
            case 1:
                CsStudent css = new CsStudent(1);
                students.add(css);
                spendKP(getNewStudentCost());
                break;
            case 2:
                CyberStudent cbs = new CyberStudent(1);
                students.add(cbs);
                spendKP(getNewStudentCost());
                break;
            case 3:
                AiStudent ais = new AiStudent(1);
                students.add(ais);
                spendKP(getNewStudentCost());
                break;
            case 4:
                SeStudent ses = new SeStudent(1);
                students.add(ses);
                spendKP(getNewStudentCost());
                break;
        }
        cost = cost + 10;
    }

    public void upgrade(AllStudent student) throws Exception {
        if (getKnowledgePoint() < getNewStudentCost()) {
            throw new Exception("Not enough KnowledgePoint");
        }
        student.increaseLevel();
        spendKP(student.upgradeCost());
    }

    /**
     * call all the students to defence once, print KP gained in one run
     */
    public void studentsAct(Building building) {
        int KPCount = 0;
        int KPOneRun = 0;
        for (AllStudent st : students
        ) { // defence once and take KP
            if (building.getAllBugs().length > 0) {  // each student defence once
                KPOneRun = st.defence(building);
                gainKP(KPOneRun);
                KPCount += KPOneRun;
            } else {
                System.out.println("KP Gained this run:" + KPCount);
                break;
            }
        }
        System.out.println("KP Gained this run:" + KPCount);
    }

    /**
     * to get the lowest level student to upgrade
     */
    public AllStudent getLowestLevel() throws Exception {    // get the lowest level student to upgrade
        HashMap<Integer, AllStudent> stLevels = new HashMap<Integer, AllStudent>();
        for (AllStudent st : students
        ) {
            stLevels.put(st.getLevel(), st);
        }

        ArrayList<Integer> levelList = new ArrayList<Integer>(stLevels.keySet());  // sort hashmap, mapping students with Level
        Collections.sort(levelList);    //increasing
        return stLevels.get(levelList.get(0));
    }

    /**
     * for randomly recruit new students
     */
    private int readRandomInt() {
        Toolbox tb = new Toolbox();
        return tb.getRandomInteger(4);
    }


}
