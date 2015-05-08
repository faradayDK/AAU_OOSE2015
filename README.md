# SupperMassiveFab Breakout

The application is prototype of common known _*Breakout game*_. Player should control the panel at the bottom of the games pace, he/she can move it to the left or to the right by clicking on the corresponding button. His/her goal is to keep a flying ball in game space and to lead ball in the direction of the bricks. Each time ball hits the brick -> brick breaks (a bit); after several hits, the brick destroys. Player wins if all bricks are destroyed and looses if he/she missed ball three times (i.e. lost three lives). During the game process, player can see the buffs, if player collects them with a platform -> he/she can get more scores or one additional life.

### Features:
* Bricks has different type of "breakness"
* Player can collect buffs to enlarge scores and get more lives

### Control:
* LEFT and RIGHT to move platform
* ESC to call in-game menu

## Project configuration

1. Open up Eclipse.
2. Create a new java project and select the folder containing this seed.
2. Go to Project Menu  --> Properties in the menu bar.
3. Click on Java Build Path.
4. click the Add Jar button.
5. Select the *lib* folder in your project.
6. Select all the *.jar* files and click OK.
7. Expand *lwjgl.jar*.
8. Select *Natives Library Location* and click the Edit button.
9. Click the Workspace button.
10. Select the *native* folder in your project
11. Select your operating system and click OK until you get back to the default eclipse window.
12. Press play to check if it works.

## Build runnable JAR file:
To generate an executable version of the game you will need to use JarSplice:

1. Use _ Eclipse _
2. Choose File -> Export
2. Click on Java and select * JAR File * .
3. Select current project in the Lunch configuration .
4. Select _ Extract generated classes files and resources _ ,
5. Select all _ Options _ in the bottom of the window.
6. Press _ Finish _ .
7. Download JarSplice at http://ninjacave.com/jarsplice and execute it (double-click on it).
8. Select * ADD JARS *, press the * Add Jar(s) * button in the bottom and select the previously exported JAR file, as well as, go to the _ lib _ game folder and select all Jars.
9. Select * ADD NATIVES * , press the Add Native(s) button in the bottom, go to you projects native library and select files for your OS.
10. Select * MAIN CLASS * , and in the Enter Main Class area type in the name of your main class including the name of the package : game.GameSpace
11. Select * CREATE FAT JAR * and press the Create Fat Jar button.
12. * Now you can play *


***
Authors: Jelizaveta Zovnercuka, Kristians Konovalovs, Germans Savcisens
***
Aalborg University - Copenhagen , 2015

