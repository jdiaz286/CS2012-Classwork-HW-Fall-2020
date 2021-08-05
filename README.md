# CS2012-Classwork-HW-Fall-2020
This is just for me, it's all my work I created during my CS 2012 class at CSULA
* This is an eclipse workspace, to run any file please use whole workspace

## Homework 1 folder includes:
Class name  | Task
-------------    | -------------
Homework1.java     |  Write a method that creates an array of ten nonnegative doubles, initializes it with values taken from console input inside a loop, and returns a reference to the array. Validate the user input to make sure the program does not crash if the user enters invalid data. For each double you request, keep asking until the user enters a valid nonnegative double.
  ----    |  Write a void method that takes an array of doubles as its only parameter, calculates the cube of each value in the array, and prints out each result. This method should not change the values in the array.
 ----     |  Write a method that takes an array of doubles as its only parameter and replaces any value exceeding 250 with the value 250. This method should be void; in other words it should not return anything. Be sure you understand how array references are sent to methods.
----     |  Write a method that takes an array of doubles as its only parameter, copies the array, replaces each value in the old array with its inverse (1/x), and returns a reference to the new array. Be sure you understand the difference between copying an array and copying an array reference, or you will not do this part correctly.
 ----     |  Write a void method that takes an array of doubles as its only parameter and prints out all the values.
----     |  main() should call the input method, then send the array to the print method, then run each of the other methods, using the print method to print the current values after each method is done. After running the method that creates a new array, print out both the original array and the one returned by the method. If the two arrays contain the same values, the method that makes a copy and calculates the inverses is probably not correct.

## Homework 2 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | This assignment requires you to write an object-oriented application with several classes and a driver.  You will need to write constructors, getters, setters, and toString() methods.
MonsterAttack.java     |  MonsterAttack has the following private data variables: monsterName, attackLocation, damagesInMillionUSD, and date. Create whatever constructors, getters, and setters you need.  Be sure to write a reasonable toString().
AttackMonitor.java     |  AttackMonitor contains an array of MonsterAttacks and  has methods to generate reports on the attacks.  It should include at least these methods:
 ----     |  reportAttacks() creates an array of five attacks, takes user input using a Scanner from System.in, creates the attacks (instances of MonsterAttack), and adds the attacks to the array.
----     | showAttacks() iterates through the array and prints out the result of running the toString() of each attack.
 ----     |  showDamages() calculates and prints the total amount of damages for all attacks and the mean damages
 ----     | showMonsters() shows the names of all monsters involved in the attacks and the number of attacks for each monster (ie: "Godzilla, 3 attack(s); Bigfoot, 1 attack(s); Yeti: 1 attack(s)).  Since we may discover new monsters after compile time, you must find the names using a getter in MonsterAttack.  Don't hard- code the monster names.
 ----     |  findEarliestAttack() prints out the to String() of the earliest MonsterAttack in the array.
 ----     | A menu method that offers the user the opportunity to run any of the methods listed above or to quit.  The menu must be contained in a loop with a swtich statement, as shown in several lecture examples..  The user can do any of the above tasks in any order, as many times as she wants to.
 ----     |  Write a main() method for AttackMonitor.  Think about what it needs to do to show that the other classes work correctly.  The driver should only call methods from AttackMonitor, not methods from MonsterAttack.

## Homework 3 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | Write an application that models courses, students, and faculty members in a university.
Address.java     |  An address has a street number, street name, city, state or province, and country.
Course.java     | A course has a course identifier (eg, EE-132) and a number of units (int).
 Person.java     |  A Person has a name and an Address (represented by an object of class Address, not a String). Note that the subclasses of Person inherit the fields and methods of Person. You may need to override some of the methods in the subclasses.
Student.java     | Student is a subclass of Person. In addition to the data inherited from Person, a student has CIN and a course schedule represented by an ArrayList of Courses (objects of class Course). You must provide ways for a Student to add and drop an existing Course.
 FacultyMember.java     |  FacultyMember is also subclass of Person. A FacultyMember has an employee id number and a teaching schedule, which is an ArrayList of Courses. Provide a way to assign a FacultyMember to teach an existing Course and for a Faculty member to find a class in the list and drop it.
 University.java     | Write a University class that maintains lists of Students, Courses, and FacultyMembers and has an instance method containing a menu that provides ways to list them and to create them and add them to the list. Provide ways to delete Students and FacultyMembers and for Students and FacultyMembers to add and delete Courses from their course schedules. However, you do not need to provide a way to delete a Course from the list of Courses. Do not create a new Course when a Student adds or when a faculty member is assigned to teach; let the user choose a Course from the list.
 UniversityDriver.java     |  Write a simple Driver class that instantiates a University and calls the correct method to get the menu.
 
 ## Homework 4 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | Begin with your code from Homework 2. Complete the Monster Attack project by doing the following:
MonsterAttack.java     |  MonsterAttack has the following private data variables: monsterName, attackLocation, damagesInMillionUSD, and date. Create whatever constructors, getters, and setters you need.  Be sure to write a reasonable toString().
 AttackMonitor.java     | In place of the driver used in homework 2, add a menu with a loop and switch.  The user must be able to add attacks, get a report on existing attacks, sve a file, retrieve a file, and clear the list as many times as she wants in any order she wants.
----     | Replace the array of MonsterAttacks with an ArrayList of MonsterAttacks.  This will require changes in several methods.  You will need to be able to handle any number of MonsterAttacks the user chooses to input.
----     | Add a method to AttackMonitor that saves the list of attacks to a comma separated values file. Iterate through the list, and for each attack, get each field using the getters from MonsterAttack. Write each value to the file, following each one except the last with a comma. Save the date as a single String in the format MM/DD/YYYY. After you have written out all the data for one attack, write out a newline. Add an item to the main menu that calls this method.
----     | Add a method that clears the list of monster attacks, then uses a Scanner to read data from a .csv file, uses it to instantiate MonsterAttack objects, and adds the attacks to the list. This method must be able to read the files you write out in the method described above. You will need to use String's split() method here. Add an item to the main menu that calls this method. Make sure you can input attack data, save to a file, quit the program, start the program again, read your output file, and show the data from the file.

 ## Homework 5 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | Write an application that models a brutal war for survival among small animals.
Animal.java     |  All the animals in this lab inherit from the abstract class Animal. Animal has a name and a weight in grams. It has a public method eat, which takes a double parameter that represents the weight in grams of a food item and adds that much to the animal's weight. It also has a call() method. Since different animals have different calls, call() must be an abstract method.
 AnimalDriver.java     | Create a driver class with reasonable results.
Bird.java     | The concrete classes Bird extends Prey in appropriate ways.
Cat.java     | The concrete class Cat extends predator and implements call() by showing a message like "Fifi says 'Meow'". It overrides toString() to return a message similar to "Fifi is a Cat weighing 982.3 grams."
Mouse.java     | The concrete classes Mouse extends Prey in appropriate ways.
Predator.java     | The abstract class Predator extends Animal by adding a predate() method. Predate() takes a reference to a Prey animal (one that extends Prey), calls the instance Animal's (that is, the Predator's) eat() method with the weight of the Prey animal as parameter, and shows a message similar to "Thor The Wolf eats Bambi," using the actual names of the Predator and Prey animals.
Prey.java     | The abstract class Prey extends Animal by adding a flee() method. Since different Prey animals flee differently, this method must be abstract.

 ## Homework 6 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | Set up a JavaFX GUI-based program that shows a 10 X 10 grid of labels that forms a multiplication table, with the labels displaying the multiplication problems, rather than the answers. Provide a text input field and a button with an event handler that reads an integer value from the text input and changes the CSS styling in some obvious way for all problems in the table with the given answer. When a new answer is entered and the button is clicked, change all the labels back to the original style, then change the labels showing problems for the new answer to the new style. Use CSS, not setters, for all the styling.
Homework6.java     | My solution uses a GridPane, several HBoxes, a VBox, and a BorderPane, as well as a Button, a TextField and many Labels. You may use the image posted as hw6.png as an example, but feel free to make your GUI look different from this as long as your work meets the specifications above, looks good, and is easy to understand.
 ----     | There is no easy way to access components in a GridPane by row and column indices, so create a two-D array of Labels and add the labels to it at the same time you add them to the GridPane.  You can get to the individual labels using their subscripts in the array.

Result for homework 6 should look something similar to this:
 
 ![lab7image](https://user-images.githubusercontent.com/55372515/128221529-5ba7aaf5-ccee-423f-afaa-1f1aa1807fdd.png)
 
  ## Homework 7 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | Etch-A-Sketch is a classic toy in which a user draws an image using a cursor that leaves a trail.  The toy uses two dials to control the cursor, but we will use the scroll keys of the computer keyboard.  On an Etch-A-Sketch, the trail can be erased by shaking the toy, but we will accomplish this using a Label marked "Shake. "  Don't use a Button, because this will make it harder to handle the scroll key events. Represent the screen with a GridPane containing Labels.  Labels will have three different css classes, one for labels that have not been traversed, one for labels which have been traversed but are not currently the cursor location, and one for the current cursor location.  Once components have been added to a GridPane, there is no way to reference them by column and row, so create a separate 2D array of Labels and add the labels to the array at the same time you add them to the GridPane.  You can change the css classes of the labels by accessing them by row and column in the array.
Game.java     | Create a Game class with an int row and column which will represent the current location of the cursor.  Game will also need a method to determine whether a row, column pair represents a valid square on the screen (that is, neither the row nor the column may be less than zero, the row can't be greater than the maximum row on the screen, and the column can't be greater than the maximum column.)  Set the number of rows and columns in the constructor.
 GUI.java     | Put the GUI code in a class that extends BorderPane and has a constructor that takes the numbers of rows and columns that will be on the screen. See the Click Counter for some ideas about how to set up the GUI.  You will need a label to show the current location and a shake label with an event handler that changes all the labels' css classes back to the unoccupied style.  I suggest you put both of these in an HBox.
  Main.java     | Put the start method in a class called Main.  Start() should instantiate a Game and then instantiate the GUI, sending the numbers of rows and columns to both constructors.  Think out how to connect the Game to the GUI. Link to the stylesheet in Main.
   Homework7.css     | Use a css file to control the appearance of your GUI.
 
Result for homework 7 should look something similar to this:
![etch-2](https://user-images.githubusercontent.com/55372515/128291387-27f1a439-6687-4d12-9371-e304f1227b23.jpg)

  ## Homework 8&9 folder includes:
Class name  | Task
-------------    | -------------
Purpose    | You will create a game that simulates a stroll through a pasture in which a number of cows are grazing. The player's objective is to reach the gate while keeping their shoes clean.
Coordinate.java     | A Coordinate class with an int row, an int column, and a char representing the value of the coordinate (this week, you will use four values for the Coordinates: blank (' ') for an empty space, F for a fence, S for the starting point, and E for the exit.) Provide getters and setters.
 Cow.java     | You will need a Cow class. Among other things, it will contain a method to determine the cow's next step. Make sure the cows move in some sensible way. For example, Cows can move at random, or can try to find the player and move towards him. If you are ambitious, you could try to simulate the actual behavior of cows in a field, or to get the cows to move away from each other in order to make the game challenging. Like the player, the cows cannot move through fences. Do not let a cow move onto a square already occupied by another cow; this would lead to insufficient dispersal. Both the GUI and the map class need to know each location. The GUI and the Map will also need to keep track of every location where a cow has been, because the player must recognize these soiled squares to avoid stepping on them. As the Cows and the player move, change the css classes for the labels they move to as well as the labels they move from. Don't try to add new labels to the grid as they move. When the GUI is created, the Cows should appear at random places in the pasture. You may want to avoid placing Cows near the beginning and end of the player's path, though; Cows in those locations make the game very difficult. The cows should move faster than the player. The best way to implement this is for the cows to take more than one move for each runner move. You can code this by writing a method in PastureMap that calls each cows's move method, and calling the PastureMap method some number of times from inside the player move event handler (the one that responds to the scroll keys.)
  MainDriver.java     | Create a driver class that calls on the GUI.
   PastureGUIPane.java     | A JavaFX GUI class called PastureGUIPane. Since the constructor for Scene takes a Pane as a parameter, this class should extend one of the Pane classes, most likely BorderPane. It should also contain a GridPane with a two-dimensional grid of Labels. One label in the GridPane corresponds to one Coordinate in the StreetMap. Note this important distinction: the PastureGUIPane is for the the user interface while the PastureMap is for data.
 ---- | The outer edges of the grid should consist of fences, except for one starting square and one exit square. When the game starts, squares that are not on the edges should be randomly set to fence and space squares (use about 15% fences.) Note that this does not guarantee that the player will not be fenced in; that is why you need to be able to toggle between walls and spaces.
  ---- | Clicking on a label that is not on the edge of the board toggles the label between fence and empty space. The event handling code must update the PastureMap when the squares toggle. It must also change the css class of the Label in order to change its appearance.
 ---- | You will also need a game reset button. You do not need to make the button work yet. In my solution, this button is in an HBox contained in the PastureGUIPane.
   PastureMap.java     | A PastureMap class with a two-dimensional array of Coordinates but no GUI code.
   PastureGUIPane.css     | A css file to control the appearance of the GUI
   
  ![pasture-1](https://user-images.githubusercontent.com/55372515/128293716-e5d54d98-eede-41c8-8e7a-9b5e3b906b4b.png)
