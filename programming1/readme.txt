# Basic  #

## Part 1 ##
I have implemented the classes Bug and its subclasses ConcurrentModificationBug, NoneTerminatationBug, NullPointerBug following the coursework specification

Additional member variable: 
damage: in Bug class to present its damage cause to building.

Additional method: 
constructor :in Bug class and its subclass to receive <damage> as parameter)





## Part 2 ##
I have implemented the class building following the coursework specification

I have added additional methods in building class:
LetBugsIn: to let the bugs in the floor -1 get in the building






## Part 3 ##
I have implemented the classes Student/AiStudent/CsStudent/SeStudent/CyberStudent following the coursework specification

I added a new superclass AllStudent to be inherited by all types of students.

Addition variable:
currentDelay: to count the times for students doing special attack

Addition methods:
getClassName: for print students types
normalAttack: to do normalAttack once





## Part 4 ##
I have implemented the class Team following the coursework specification

This class is to interactive with students.
The strategy for the different students is not here.

Addition variable:
Cost: to count the cost of students

Addition methods:
gainKP: gain kp after kill a bug
spendKP: spend kp when upgrade or recruit students
studentAct: to call all students attack(defence) once
getLowestLevel: to get the lowest level student  





## Part 5 ##
I have implemented the classes Battle following the coursework specification

Strategy
1. Let all bugs get in the building
2. Start the one wave within the specific steps
3. Recruit & upgrade students ——> upgrade after priority recruitment
4. Bugs move & attack building
5. Print
...





## Part 6 ##
I have implemented the classes EcsBuilding following the coursework
specification

Circuit:
1 read from cmd & declare variables
2 split file
	a.spilt by line get each wave, 
	b.split them to array list
3.start game
	




# Extension #
I have implement the following extension.

The following classes are added 

In bugs package:
DestroyBug: when move into a new floor, damage cause to building increase
HealBug: when move into a new floor, HP increase
JumpBug: when move into a new floor, run faster


In students package & its special ability:
AEEStudent: to build one more floor for building
BEStudent: heal building
ElectronicStudent: force first bug baseSteps increase
EEEStudent: force bugs’ level decrease
ElectricalStudent: force the last bug’s damage cause to building decrease
MEStudent: gain more KP after kill bugs


To run the program with the extension, please use the following
command
java EcsBuildingDefence