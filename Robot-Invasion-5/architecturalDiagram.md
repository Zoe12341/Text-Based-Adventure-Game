Here is an image summary of how the various classes interactive with each other:

<img src="diagram.png">



**Robot Invasion Class**
- The robot invasion class is the class that runs the entire game by creating instances of the location, item, NPC, and User class. The instances collectively form a world of the gameplay. The class also has methods that correspond to each of the user's response and dictate what changes/occurs when the user executes a certain command. Some of the methods in Robot Invasion Class include: look, examine, take, drop, go, attack, bring, eat, approach, abandon, check inventory, check health, endGame, help, setUp, and playGame. The methods of the Robot Invasion class call methods from Location, Item, NPC and User class. You could say that the Robot Invaison Class is the glue that joins all the classes together and forms a game that the user is able to play.

**Item Class:** 
- The Item Class represents items in the game. It includes a contructor to form an item given a name, description, and power of the item. It contains getters for these private attributes. There is also a set method for the power, since this the power decreases when the user uses the item. The only other method in the class returns a boolean true if the power of the item is 0.

**Location Class:**
- The Location class represents a location in the game. It uses the item, NPC, and User class to keep track of the different instances of these things in a location. It utilizes hashsets to allow items/NPCs to be added to or removed from the location quickly. The location also has attributes representing the name and description and name of the location. 

**NPC Class**
- The NPC class represents the NPCs in the game. It includes a constructor that forms a new npc, who is given a name, power, strength(or health), and a boolean that determines whether or not that NPC is a robot. The class contains a series of getters and setters for each of these attributes and also contains an additional attacksUser method that allows that NPC to attack if they are a robot or are attacked by the user.

**User Class**
- The User class represents the main player of the game. It contains a contructor that places a new user at a starting location and also a series of getter and setter methods for health, inventory, npc party, and location attributes. The class contains a multitude of methods that allow the user to perform certain actions. These actions include moving from location to locaition, eating food to gain or lose health, taking and dropping items, taking and abandoning npcs, as well as looking around a location to see what items are present. There are also additional featureus to check players health and inventory to make sure that the player has the necessary items/enough health to complete the game. 
