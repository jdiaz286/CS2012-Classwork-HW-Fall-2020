# CS2012-Classwork-HW-Fall-2020
This is just for me, it's all the work I used during my CS 2012 class at CSULA
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
