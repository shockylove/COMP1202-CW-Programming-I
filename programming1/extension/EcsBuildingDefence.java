import bugs.*;
import building.Building;
import students.Team;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Circuit
 * 1. read from cmd & declare variables
 * 2. split file
 *      a. spilt by line get each wave split into every bug()
 *      b. spilt every bugs then add them to arraylist(spilt method: turn all punctuation into "," split",")
 * 3. start game
 *      a. two loops: first for each wave, second for every battle Steps
 */
public class EcsBuildingDefence {
    public static void main(String[] args) {


        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Enter Game Name");
            String gameName = reader.readLine();
            while (gameName.equals("java EcsBuildingDefence")) {

            System.out.println("Welcome to Java EcsBuildingDefence");
            System.out.println("Enter Top Floor, Construction Point, File Name and Knowledge Point in turn");
            int Floor = Integer.parseInt(reader.readLine());
            int CP = Integer.parseInt(reader.readLine());
            String fileName = reader.readLine();
            int KP = Integer.parseInt(reader.readLine());

            // create objects
            int waveCount = 1;
            Building building = new Building(Floor, CP);
            Team team = new Team(KP);
            Battle battle = new Battle(team, building);
            int battleSteps = Floor * 8;

            //read file content by line
            ArrayList<String> bugWaves = new ArrayList<>();
            try (Scanner sc = new Scanner(new FileReader(fileName))) {
                while (sc.hasNextLine()) {
                    bugWaves.add(sc.nextLine());
                }
            }

            /**     2 for loops
             *      first for means each wave
             *      second for means do steps
             *      Structure
             *      Whole game---> 50 waves(in bugs.txt)---> battleSteps( 8*topFloor)
             * */
            System.out.println("In TOTAL, THERE WILL BE " + bugWaves.size() + " WAVES");
            System.out.println("LET'S START");
            for (String oneWave : bugWaves    // whole game, every wave start
            ) {
                /** replace "(" and ")" with "," */
                oneWave = oneWave.replace(")", ",");
                oneWave = oneWave.replace("(", ",");
                String[] thisWave = oneWave.split(";");  //contain one line bugs
                int bugsNum = thisWave.length;

                ArrayList<String> bugName = new ArrayList<>();
                ArrayList<String> bugType = new ArrayList<>();
                ArrayList<Integer> bugLevel = new ArrayList<>();
                ArrayList<Integer> bugStep = new ArrayList<>();

                /** get name/type/level/step of bugs in one wave */
                for (String bugs : thisWave
                ) {
                    String[] bugInf = bugs.split(",");
                    bugName.add(bugInf[0]);
                    bugType.add(bugInf[1]);
                    bugLevel.add(Integer.parseInt(bugInf[2]));
                    bugStep.add(Integer.parseInt(bugInf[3]));
                }

                /**add bugs to building*/
                for (int i = 0; i < bugsNum; i++) {
                    switch (bugType.get(i)) {
                        case "CMB":
                            ConcurrentModificationBug bug = new ConcurrentModificationBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug);
                            break;
                        case "NTB":
                            NoneTerminationBug bug1 = new NoneTerminationBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug1);
                            break;
                        case "NPB":
                            NullPointerBug bug2 = new NullPointerBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug2);
                            break;
                        case "Jump":
                            JumpBug bug3 = new JumpBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug3);
                        case "Heal":
                            HealBug bug4 = new HealBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug4);
                        case "Destroy":
                            DestroyBug bug5 = new DestroyBug(bugName.get(i), bugLevel.get(i), bugStep.get(i));
                            building.addBug(bug5);
                        default:
                            throw new Exception("No Such Bug");
                    }
                }

                /** start every wave*/
                System.out.println("\n===================================================");
                System.out.println("THIS IS WAVE  " + waveCount);
                System.out.println("===================================================\n");
                battle.start(battleSteps);
                waveCount++;
                if (building.getConstructionPoints() < 1) {
                    System.out.println("\nTHE BUILDING HAS BEEN OVERRUN BY THE BUGS. BETTER LUCK NEXT TIME...");
                    break;
                }
            }
            if (building.getConstructionPoints() > 0) {
                System.out.println("\nSUCCESSFUL! CONGRATULATIONS!");
            } else {
                System.out.println("\nFAILED! BUILDING HAS BEEN DESTROYED! ");
            }
        } // while ends
            } catch(FileNotFoundException e){
                e.printStackTrace();
            } catch(IOException e){
                e.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
    }
}