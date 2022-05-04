/** 
 * Class that runs the entire game
 *
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */ 
import java.util.*; 
class RobotInvasion{
  /** attribute setup for all of the locations */
  private Location mainApartment;
  private Location pennStation;
  private Location hotel;
  private Location conv_store;
  private Location police_station;
  private Location central_park;
  private Location ferry;
  private Location statue_liberty;

  /** attribute setup for all of the items */
  private Item chip;
  private Item baseball_bat;
  private Item gun;
  private Item sandwich;
  private Item notebook;
  private Item boat;
  private Item Hcar;
  private Item Pcar;
  private Item train;
  private Item map;
  private Item donut;
  private Item apple;
  private Item orange;
  private Item mints;

  /** attribute setup for all of the NPCs */
  private NPC homeless_man;
  private NPC police_officer;
  private NPC professor;
  private NPC sus_guy;
  private NPC headRobot;
  private NPC robot;
  private NPC bossRobot;
  private NPC shivani;

  /** attribute setup for the user */
  private User player;

  
  
/** 
 * Sets up the entire game including locations, npcs, and different items.
 *
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */
  public void setUp(){
     
    this.mainApartment = new Location ("apartment", "You arrive at the apartment. The place is practically empty, and you sense the people who were living here left in a hurry.");
    
    this.pennStation = new Location("penn station", "You arrive at Penn station. There is none of the usual hustle and bustle that you expected from a New York City station. The area is desolate and the only things around are pieces of trash on the ground.");
    
   this.hotel = new Location ("hotel", " You arrive at the hotel and see that the area had clearly been hit by robots. Cars were alflame and the doors in front of the hotel were barricaded with luggage. You remember that your senior officer had mentioned that the professors who invented the Robots were staying here.");
    
    this.conv_store = new Location ("convenience store", "You arrive at the convenience store and see that almost all of the aisles are empty. It seems that people raided the area for supplies just as the robot invasion was starting." );
    
    this.police_station = new Location("police station", "You arrive at the police station and were shocked by how horrible the scene was. Bullet holes were found everywhere and you could even see some marks of blood around the ground. ");
    
     this.central_park = new Location ("central park", "You arrive at central park and everything seems relatively normal compared to other places you have seen. A sense of calm envelopes you as you see how not much of the scenery has changed yet.");
    
     this.ferry = new Location ("ferry", " You arrive at the ferry dock and are hit by a cool sea breeze. Not much is present around the area and all that really gets your attention is the strong scent of the sea and the distance between you and your destination.");
    
     this.statue_liberty = new Location("statue of liberty", "You arrive at the Statue of liberty and can see that a lot of robots are swarming around the area. You can see the large satellite connected to a computer atop the statue but you have to be careful not to accidentally trigger one into their attack mode. ");


    //main apartment neighbors
    this.mainApartment.addNeighbors(this.pennStation);
    this.mainApartment.addNeighbors(this.hotel);
    this.mainApartment.addNeighbors(this.police_station);
    this.mainApartment.addNeighbors(this.conv_store);
    //police station neighbor 
    this.police_station.addNeighbors(this.mainApartment);
    this.police_station.addNeighbors(this.hotel);
    this.police_station.addNeighbors(this.central_park);
    // convinient store neighbors
    this.conv_store.addNeighbors(this.mainApartment);
    this.conv_store.addNeighbors(this.pennStation);
    //hotel neighbors
    this.hotel.addNeighbors(this.ferry);
    this.hotel.addNeighbors(this.police_station);
    this.hotel.addNeighbors(this.mainApartment);
    this.hotel.addNeighbors(this.central_park);
  
    //penn station neighbors
    this.pennStation.addNeighbors(this.conv_store);
    this.pennStation.addNeighbors(this.mainApartment);
    this.pennStation.addNeighbors(this.ferry);
    this.pennStation.addNeighbors(this.central_park);
    //central park neighbors 
    this.central_park.addNeighbors(this.pennStation);
    this.central_park.addNeighbors(this.police_station);
    this.central_park.addNeighbors(this.hotel);
    //ferry neighbors 
    this.ferry.addNeighbors(this.pennStation);
    this.ferry.addNeighbors(this.hotel);
    this.ferry.addNeighbors(this.statue_liberty);
    //statue of liberty neighbors
    this.statue_liberty.addNeighbors(this.ferry);

    //making a player
    this.player = new User(mainApartment);

    /**Item setup*/
    //Item(String name, boolean canEat, int power(#reuses))
    //Item notebook = new Item("notebook", false, 1);
    //new item(name, description, power)
    this.chip = new Item("chip","You examine the chip and it green in color", 10);
    this.baseball_bat = new Item("bat","100% organic wood", 2);
    this.gun = new Item("gun","You examine the gun and it is loaded with 5 bullets", 5);
    this.sandwich = new Item ("sandwich", "You examine the sandwich and it has a chick-fil-a reciept attached that has someone named Dave's order of 1 Spicy Chicken Sandwich for $5.00", -1);
    this.notebook = new Item("notebook","You look at the notebook and it seems to be a diary of sorts. It reads: April 17, 2022:The robots are coming closer, I don’t know why they are here but they are dangerous. This will be my last entry but if anyone finds this please find help and save our city… The entry cuts off there.", 3);
    this.boat = new Item ("boat keys","You examine the boat and it is white and blue in color.", -2);
    this.Hcar = new Item ("van keys","You examine the van and it is with a full tank. ", 2);
    this.Pcar = new Item ("car keys","You examine the police car and the entire system is broken and it seems as if someone damaged it on purpose but it still has a full tank.", 2);
    this.train = new Item ("train switch","You examine the train and it is empty and not even the engineer is present.", 2);
    this.map = new Item("map", "You examine the map and see that there are places near you", 0);
    this.donut = new Item("donut", "You examine the donut and it is covered with pink frosting and rainbow sprinkles", -1);
    this.apple = new Item("apple", "You examine the apple and it is red and big.", -1);
    this.orange = new Item("orange", "You examine the orange and it is small and has a green stem.", -1);
    this.mints= new Item("mints", "You examine the mints and they are peppermint flavor. ",-1);
    
    pennStation.addItem(train);
    ferry.addItem(boat);
    hotel.addItem(Hcar);
    police_station.addItem(Pcar);
    mainApartment.addItem(notebook);
    hotel.addItem(chip);
    conv_store.addItem(baseball_bat);
    conv_store.addItem(sandwich);
    police_station.addItem(gun);
    mainApartment.addItem(map);
    police_station.addItem(donut);
    mainApartment.addItem(apple);
    mainApartment.addItem(orange);
    hotel.addItem(mints);


    //Adds npc to each location and also sets a response for npc if user asks questions
    // npc(name, str)
    this.homeless_man = new NPC("homeless man", 1, 3, false);
    this.police_officer = new NPC ("police officer", 3, 3, false);
    this.headRobot = new NPC ("head robot", 6, 31, true);
    this.professor = new NPC ("professor nick", 2, 3, false);
    this.sus_guy = new NPC ("suspicious guy", 5, 50, true);
    this.shivani = new NPC ("english major", 2, 10, false);

    homeless_man.setResponse("The homeless man is staring blankly off into the distance. You nudge him, and he jolts awake suddenly going on a random tangent: He spent his life as a train engineer then entered the US navy where he was 'falsely' accused of a crime, and now he lives in penn station");
    police_officer.setResponse(" As you approach the police officer, he mentions that yesterday he recieved a call from a lady named Karen. She was screaming for help and begged to officer to come to the Central Park. The police officer rushed over only to find that the lady was angry that children were laughing too loudly. However, he then noticed a force of robots grabbing humans and taking them somewhere. The officer was able to escape to the police station. He soon realized this was happening everywhere and that he was the only officer left.");
    professor.setResponse("Professor Nick and  Jordan were working on inventing a new Robot Species when they encountered a malfunction in one of the Head Robot.The Head Robot wanted to wipe out humankind and take over the earth. Jordan tried to remove the programming chip from the robot. Unfortunately, the Head Robot caught and killed Jordan. Professor Nick cries hysterically. After the death of his friend, Prof Nick hid in the hotel and created a chip to reset the Head Robot's programming. Professor Nick gives the chip to attack the head robot and save humankind. The Head Robot has made the Statue of Liberty his base.");
    sus_guy.setResponse("The suspicious person does not respond to you");
    shivani.setResponse(" You approach the english major. She speculates about Wordsworth's reaction to the robot invasion and its connection to the industrialization of London. Then she gets shot.");
    this.robot = new NPC ("angry robot", 6, 15, true);
   
    statue_liberty.addNPC(robot);
    police_station.addNPC(police_officer);
    pennStation.addNPC(homeless_man);
    statue_liberty.addNPC(headRobot);
    ferry.addNPC(shivani);
    central_park.addNPC(sus_guy);
    hotel.addNPC(professor);

    

  }
   /**
    * allows player to play game via the console.
    */
  public void playGame(){
    System.out.println("\nHello! Welcome to The NYC Robot Invasion Game.\n");
    help();
    Scanner sc = new Scanner(System.in);
    boolean wonGame = false;
    System.out.println("\n\nAs an FBI agent, your task is to find the source of a sudden violent robot invasion that is taking place in New York City. There is not much time left to stop the invasion as a previous nationwide broadcast announced that the robots will take over the entirety of the United States by sundown. Entering the city however, you were attacked by robots and lost your phone and all your weapons. You head to the apartment complex that you were sent to investigate, where the first attack of the robot invasion occurred. \n ");
    System.out.println(player.getLocation().getDescription());

    //Taking in User input
    while(endGame(wonGame)== false) { // allows for player to repeatedly enter input
			// scanner set up to read user input
      System.out.print("\n> ");
			String input = sc.nextLine();
			input = input.toLowerCase();
			String[] words = input.split(" ");
      System.out.println();

			// if command is to take
			if (words[0].equals("take")) {
			  take(words);
			} 
      else if (words[0].equals("drop")) { // player wants to drop
			  drop(words);
			} 
      else if (words[0].equals("look")) { 
				player.look();
			} 
      else if (words[0].equals("go")){ 
        go(words);
      }

      //user wants to attack an NPC
      else if(words[0].equals("attack")){
        wonGame = attack(words, wonGame);
      }

      //user wants to bring NPC
      else if(words[0].equals("bring")){
        bring(words);
      }

      //user wants to eat item
      else if(words[0].equals("eat")){
        eat(words);
      }

      else if(words[0].equals("approach")){
        approach(words);
      }

      else if(words[0].equals("check")&& words[1].equals("inventory")){
        checkInventory();
      }

      else if(words[0].equals("check")&& words[1].equals("health")){
        checkHealth();
      }
      else if(words[0].equals("check")&& words[1].equals("party")){
        checkParty();
      }
      else if(words[0].equals("end")&& words[1].equals("game")){
        stopGame();
        
      }
      else if(words[0].equals("examine")){
        examine(words);
      }
      else if(words[0].equals("help")){
        help();
      }
      else if(words[0].equals("abandon")){
        leaveNPC(words);
      }
      else { // else no such command
				System.out.println("No such command, please try again");
			}
    }
    
  }
  

  /**
   * Ends game if player dies or reaches ending locaiton
   * @param wonGame, whether or not won game
   * @return true if the game should end
   */
  public boolean endGame(boolean wonGame){
    if(wonGame == true){
      
      System.out.println("Yay! you won.");
      return true;
    }
    if(player.getHealth() > 0){
      return false; //the player is alive so don't end game
      }else{
      System.out.println("You fall to the ground in pain. A few seconds later you breath your last breath and die.");
      System.out.println("You lost. The robots reign supreme!");
      return true;
    }
  }

   /**
    * Allows player to attack npc or robot
    * @param words, command to attack npc
    */
  public boolean attack(String[] words, Boolean wonGame){
    if (words.length >= 5) {
		  String myNpc = words[1]+ " " + words[2];
      boolean isNPC = false;
      NPC toAttack = null;
      //looking for npcs in location
      for(NPC npc : player.getLocation().getLocNPC()){
        if(npc.getNPCname().equals(myNpc)){
          toAttack = npc;
          isNPC = true;
        }
      }
      //looking for npcs in user's party
      for(NPC npc : player.getParty()){
        if(npc.getNPCname().equals(myNpc)){
          toAttack = npc;
          isNPC = true;
        }
      }

      String aItem = words[4];
      if (words.length ==6){
        aItem+=" " + words[5];
      }
      
      
      boolean haveItem = false;
      Item toUse = null;
          
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(aItem)){
          toUse = myItem;
          haveItem = true;
        }
      }

      if(isNPC == false && haveItem == false){
        System.out.print("There is no " + words[1] + " " + words[2] + " near you to attack, and you do not have a " + aItem);
      }

      if(haveItem == true && isNPC == false){
        System.out.println("There is no " + words[1] + " " + words[2] + " near you to attack");
      }

      if(haveItem == false && isNPC == true){
        System.out.println("You do not have a " + aItem);
      }
 
      if(isNPC == true && haveItem == true){ //valid NPC and valid item
        player.attack(toUse, toAttack);
        if(myNpc.equals("head robot")){
          if(!player.getLocation().getLocNPC().contains(headRobot)){
            wonGame = true;
            
          }
        }
      }
		} else {
			System.out.println("Please be more specific. List who you want to attack and with what item. Ie Attack man with stick");
		}
    return wonGame;
  }

 
  /**
    * Allows player to take an item
    * @param words, command to take an item
    */
  public void take(String[] words){
    // making sure input has command and item
	  if (words.length >= 2) {
			String item = words[1]; //the item should be the second thing typed
      if (words.length ==3){
        item+=" " + words[2];
      }
      boolean haveItem = false;
      for(Item myItem : player.getLocation().getLocItem()){
        if(myItem.getName().equals(item)){
          player.pickUp(myItem, player.getLocation());
          haveItem = true;
          break;
        }
      }
      if(haveItem == false){
        System.out.print(words[1]);
        if (words.length ==3){
        System.out.print(" "+ words[2]);
      }
      System.out.print(" is not near you.");
      }
		}else { 
			System.out.println("What item do you want to take?");
		}
  }

  // /**
  //   * Allows player to take an item
  //   * @param words, command to take an item
  //   */
  public void examine(String[] words){
    // making sure input has command and item
	  if (words.length >= 2) {
			String item = words[1]; //the item should be the second thing typed
      if(words.length==3){
        item+=" " + words[2];
      }
      Item examineItem = null;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
          examineItem = myItem;
        }
      }
      if (examineItem==null){
        System.out.println("You are not holding " + item + ".");
      }
      else{
        try{
        if(examineItem.getName().equals("map")){
          lookMap();
        }else{
          System.out.println(examineItem.getDescription());
        }
        }catch(NullPointerException e){
        }
       
      }
      
      
    }else{
      System.out.println("This item is not valid.");
    }
  }
   
  
   /**
    * Allows player to drop an item
    * @param words, command to drop an item
    */
  public void drop(String[]words){
    if (words.length >= 2) {
			String item = words[1];
      if (words.length ==3){
        item+=" " + words[2];
      }
    
      boolean haveItem = false;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
          player.drop(myItem, player.getLocation());
          haveItem = true;
          break;
        }
      }
      if(haveItem == false){
        System.out.println("You don't have a " + item);
      }
		} else {
			System.out.println("What item do you want to drop?");
		}
  }

  /**
    * Allows player to drop an item
    * @param words, command to drop an item
    */
  public void leaveNPC(String[]words){
    if (words.length >= 3) {
      boolean isNPC = false;
      NPC abandoned = null;
	    String npc = words[1] + " " + words[2]; //the npc should be the second thing typed
      for(NPC myNPC : player.getParty()){
        if(myNPC.getNPCname().equals(npc)){
          abandoned = myNPC;
          isNPC = true;
        }
      }
      if(isNPC == false){
        System.out.print(npc + " is not in your party.");
      }else{
        player.abandonNPC(abandoned, player.getLocation());
      }
    }else { 
			System.out.println("Who do you want to abandon? Please write their full name.");
		} 
  }


  /**
    * Allows player to move from location to location
    * @param words, command to move
    */
  public void go(String[] words){
    HashMap<String, Location> carLocs = new HashMap<String, Location>();
    carLocs.put("apartment", mainApartment);
    carLocs.put("penn station", pennStation);
    carLocs.put("hotel", hotel);
    carLocs.put("convenience store", conv_store);
    carLocs.put("police station", police_station);
    carLocs.put("central park", central_park);
    carLocs.put("ferry", ferry);
    //stores location name in a string
    String place = words[2];
    for(int i = 3; i < words.length; i++){
      place += " " + words[i];
    }

    Location newLoc = null;
    //you are at location
    if (place.equals(player.getLocation().getName())){
      System.out.println("You are currently here.");
    }else if((player.getInventory().contains(Pcar)|| player.getInventory().contains(Hcar)) && !player.getLocation().getName().equals("statue of liberty")&& !place.equals("statue of liberty")){
      if (carLocs.containsKey(place)) {
        newLoc = carLocs.get(place);
        player.move(newLoc);
        System.out.println(newLoc.getDescription());
      }
      else{
        System.out.println("Sorry, you can't go there");
      }
    }
    else{
      
      boolean foundPlace = false;//found place is null
      for (Location p:player.getLocation().getNeighbors()){
        String n = p.getName();
        newLoc = p;
        if (place.equals(n)){ // if the location is what you are looking for
          foundPlace = true;
          if(newLoc.getName().equals("statue of liberty") || player.getLocation().getName().equals("statue of liberty")){
            if(player.getInventory().contains(boat)&&player.getParty().contains(homeless_man)&&(newLoc.getName().equals("ferry")||player.getLocation().getName().equals("ferry"))){  
              player.move(newLoc);
              System.out.println(newLoc.getDescription());
            }else{
              System.out.println("Sorry you do not have access to this location, you need the boat keys or the homeless man to go that location. ");
            }
            //you want to go to or from contral park
          }else if (newLoc.getName().equals("central park")||player.getLocation().getName().equals("central park")){
            //if you want to go to or from police station or hotel, you need a car
        if (player.getInventory().contains(Pcar)||player.getInventory().contains(Hcar)){
              player.move(newLoc);
              System.out.println(newLoc.getDescription());
            }else{
              System.out.println("Sorry you do not have access to this place, you need a car/van to access this place.");
            }
      
          }else if (newLoc.getName().equals("ferry")||player.getLocation().getName().equals("ferry")){
            if (((player.getLocation().getName().equals("hotel")||newLoc.getName().equals("hotel"))&& player.getInventory().contains(Hcar))||(((player.getLocation().getName().equals("penn station")||newLoc.getName().equals("penn station"))&&player.getInventory().contains(train)))){
              player.move(newLoc);
              System.out.println(newLoc.getDescription());
            }else{
              System.out.println("Sorry you do not have access to this place");
            }
          
        }else if (newLoc.getName().equals("penn station")||newLoc.getName().equals("apartment")||newLoc.getName().equals("hotel")||newLoc.getName().equals("convenience store")||newLoc.getName().equals("police station")){
            player.move(newLoc);
            System.out.println(newLoc.getDescription());
          }else{
            System.out.println("Sorry you do not have access to this place");
          }
          
        }
      }
      if (!foundPlace){
        System.out.println("Sorry the location you asked to go is unreachable at this moment.");
      }
    }
  }

   /**
    * Allows player to take npc and add them to party
    * @param words, command to take NPC
    */
  public void bring(String [] words){
    if (words.length >= 3) {
      boolean isNPC = false;
	    String npc = words[1] + " " + words[2]; //the npc should be the second thing typed
      for(NPC myNPC : player.getParty()){
        if(myNPC.getNPCname().equals(npc)){
          System.out.println("You already have " + npc + " in your party.");
          isNPC = true;
          break;
        }
      }
      
      for(NPC myNPC : player.getLocation().getLocNPC()){
        if(myNPC.getNPCname().equals(npc)){
          player.addNPC(myNPC, player.getLocation());
          isNPC = true;
          break;
        }
      }
    //the user has already brought the npc
      
      if(isNPC == false){
        System.out.println(npc + " is not near you.");
      }
		}else { 
			System.out.println("Who do you want to bring?");
		}
  }

    /**
    * Allows player to eat and regain health
    * @param words, command to eat
    */
  public void eat(String[] words){
    if (words.length >= 2) {
			String item = words[1];
      if(words.length==3){
        item+=" " + words[2];
      }
      boolean haveItem = false;
      for(Item myItem : player.getInventory()){
        if(myItem.getName().equals(item)){
            player.eat(myItem);
            haveItem = true;
          if (myItem.getPower()== -1){
            if(Math.random() < 0.4){
              System.out.println("Your food tastes gross! You examine it closer and see clumps of black mold growing on it. What terrible luck! You get food poisoning and loose 5 life points.");
              player.setHealth(player.getHealth()-5);
            }
          break;
          }
        }
      }
      if(haveItem == false){
        System.out.println("You don't have a " + item);
      }
		} else {
			System.out.println("What item do you want to eat?");
		}
  }

  /**
    * Allows player to approach an NPC
    * @param words, command to approach an NPC
  */
  public void approach(String[] words){
    //ArrayList<NPC> = 
    if(words.length > 2){
      String myNpc = words[1]+ " " + words[2];
      boolean isNPC = false;
      NPC toApproach = null;
    //looking for npcs in location
      for(NPC npc : player.getLocation().getLocNPC()){
        if(npc.getNPCname().equals(myNpc)){
          toApproach = npc;
          isNPC = true;
        }
      }
      if(!isNPC){
        for(NPC npc2 : player.getParty()){
          if(npc2.getNPCname().equals(myNpc)){
            toApproach = npc2;
            isNPC = true;
          }
        }
      }
      if(toApproach == null){
        System.out.println("Sorry, there is no NPC called " + words[1] + " " + words[2] + ". You can only approach NPCs using the format 'approach [npc name]'");
      }
      else if(toApproach != null){
        if(toApproach.getIsEvil()){
          //toApproach.attacksUser(player);
           int userHealth = player.getHealth() - toApproach.getPower();
           player.setHealth(userHealth);
          System.out.println("Oh no! You approach the "+ toApproach.getNPCname() + " but they are evil. They lunge forward and attack you. You lost " + toApproach.getPower() + " lifepoints. You now have " + userHealth  + " lifepoints left.");
        }else{     
          System.out.println(toApproach.getResponse());
          if(toApproach.getNPCname().equals("english major")){
            player.getLocation().getLocNPC().remove(toApproach);
          }
        }
      } 
      if(Math.random() < 0.35){
        System.out.println("Oh no! Your movement has attracted a new robot to your location.");

        NPC  newRobot = new NPC("scary robot", 1, 3, false);
        player.getLocation().addNPC(newRobot);
        newRobot.attacksUser(player);
      }
    }
    else{
      System.out.println("please write their full name.");
    }
  }
  

  /**
    * Allows player to check inventory
    */
  public void checkInventory(){
    if (player.getInventory().isEmpty()){
      System.out.println("\nyour inventory is currently empty. ");
    }else{
      System.out.println("\nYour inventory contains: ");
      for (Item inventoryItem : player.getInventory()){
        System.out.println(inventoryItem.getName());
      }
    } 
  }
  /**
   * checks health of the user
   */
  public void checkHealth(){
    int health = player.getHealth();
    System.out.println("current health: " + health);
  }
  
   /**
   * checks health of the user
   */
  public void checkParty(){
    if (player.getInventory().isEmpty()){
      System.out.println("\nYou have no one with you currently. ");
    }else{
      System.out.println("The people that are currently with you are: ");
      for (NPC person : player.getParty()){
        System.out.println(person.getNPCname());
      }
    } 
    
  }

  /**
   * Stops game by manually killing the player
   */
  public void stopGame(){
    player.setHealth(-1);
  }
  
  /**
    * looks at map item and current neighbors of the place you are in. 
    */
  public void lookMap(){
    if (player.getInventory().contains(map)){
      System.out.print("You examine the map and find the locations that are near you are:  \n");
      for (Location neighbor:player.getLocation().getNeighbors()){
        System.out.println(neighbor.getName());
      }
    }else{
      System.out.println("You do not have the map with you.");
    }
  }

  /**
    * Prints out the commands
    */
  public void help(){
    System.out.println("Please use the following commands to interact with the game:\nlook around \nexamine [item] \ntake [item] \ndrop [item] \ngo to [place] \nattack [person] with [item] \nbring [person] \neat [food] \napproach [person] \nabandon [person] \ncheck inventory \ncheck health \ncheck party \nend game \nhelp \n");
  }
}
