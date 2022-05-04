import java.util.*;

/** 
 * Class that contains attributes of a player
 *
 * Contains variety of methods to use items, take NPCS, move to locations, and to also attack
 * 
 * @author Ramsha, Ying, Zoe
 * @version Spring 2022
 */ 
public class User{
  /** Stores location of user */
  private Location location;
  /** Stores inventory of user */
	private HashSet<Item> inventory = new HashSet<Item>(); //inventory of items user has
  /** Stores party of user */
  private HashSet<NPC> party = new HashSet<NPC>();
  /** Stores time remaining in game */
  private int timeLeft = 30; //time remaining
  /** Stores health of user */
  private int myHealth = 40; //user's health 
  
  /**
	 * Constructor to initialize User
	 * 
   * @param startingLocation, starting location of the user
	 */
  public User(Location startingLocation){
    this.location = startingLocation; 
  }

  /** @return the players location */
	public Location getLocation() {
		return this.location;
	}
  /**@return the players inventory */
  public HashSet<Item> getInventory(){
    return this.inventory;
  }

  /** @return the User's NPC party */
  public HashSet<NPC> getParty(){
    return this.party;
  }   
  /** @return the players health */
  public int getHealth(){
    return myHealth;
  }

  /** @param health, the players health */
  public void setHealth(int health){
    this.myHealth = health;
  }

  /**
   * moves the user to a new location
   *
   * @param newLocation; new locaiton of the User
   */
  public void move(Location newLocation){
    this.location = newLocation;
  }
     

  /**
   * lists out all items present in the current location
   */
  public void look(){
    if (!getLocation().getLocItem().isEmpty()){
      System.out.println("You look around. You notice a few items around you: " );
      for (Item LItem:getLocation().getLocItem()){
        String ItemName = LItem.getName();
        System.out.println(ItemName);
      }
    }
   
    if (!getLocation().getLocNPC().isEmpty()){
      System.out.println("You notice a few people around you too: ");
      for (NPC person :  getLocation().getLocNPC()){
        String NPCname = person.getNPCname();
        System.out.println(NPCname);
      }
    }
    
  }

  /**
	 * Method that will be used to add an object to
	 * your inventory. Object must be in location you are in.
	 * 
	 * @param item, item to add to inventory
	 */
	public void pickUp(Item item, Location myLoc) {
		// check whether object is in room you are in
		Location currentLoc = myLoc;
		//Item toAdd = null;
		if (currentLoc.getLocItem().contains(item)) { // item is in location
			//toAdd = currentLoc.getLocItem().get(item);
			currentLoc.getLocItem().remove(item);
			this.inventory.add(item);
			System.out.println("You successfully picked up " + item.getName());
		} else {
			System.out.println("Sorry, there is no " + item.getName() + "   here");
		}
	}

  /**
	 * Remove an object from your inventory. Places object in location you are in.
	 * 
	 * @param item, item to add to inventory
	 */
	public void drop(Item item, Location myLoc) {
		//Item toAdd = null;
		if (this.inventory.contains(item)) { // user is holding item
			myLoc.addItem(item);
			this.inventory.remove(item);
			System.out.println("You successfully dropped " + item.getName());
		} else {
			System.out.println("You feel silly for trying to drop a " + item.getName() + " when you don't have one");
		}
	}

  /**
	 * Method that will be used to eat an item. Object must be in location you are in.
	 * 
	 * @param item, item to eat
	 */
  public void eat(Item item){
		if (this.getInventory().contains(item)) { // user is holding the item
			if(item.getPower() == -1){
        System.out.println("You successfully ate " + item.getName() + ". You gain 3 life points!");
        this.inventory.remove(item);
        setHealth(this.getHealth() + 3);
      }

      else{
        System.out.println("You put the " + item.getName() + " in your mouth, but quickly realize it is inedible, and spit it back into your hand.");
      }
		} else {
			System.out.println("You need to pick up " + item.getName() + "   before you can try and eat it!");
		}
  }

  /**
	 * Method that will be used to add an NPC member to party
	 * NPC must be in location you are in.
	 * 
	 * @param item, item to add to inventory
	 */
	public void addNPC(NPC member , Location myLoc) {
		// sets current location to wherever you are currently in
		Location currentLoc = myLoc;
		//if the current location has that NPC member, add NPC to party and remove them from the current location
		if (currentLoc.getLocNPC().contains(member)) { // item is in location
			//toAdd = currentLoc.getLocItem().get(item);
			currentLoc.getLocNPC().remove(member);
			this.party.add(member);
			System.out.println(member.getNPCname() + " has joined your party!");
		} else {
			System.out.println(member.getNPCname() + " does not exist");
		}
	}
  
  /**
	 * Remove NPC from your party. Drops NPC in location you are in.
	 * 
	 * @param NPC, NPC to to drop at location
	 */
	public void abandonNPC(NPC member, Location myLoc) {
		if (getParty().contains(member)) {
			getLocation().addNPC(member);
			this.party.remove(member);
			System.out.println("You succcessfully removed " + member.getNPCname() + " from your party.");
		} else {
			System.out.println(member.getNPCname() + "is not in your party");
		}
	}
  
  
  /**
	 * Allows user to attack an NPC with an item
	 * 
	 * @param item, item to attack with
   * @param item, NPC to attack 
	 */
  public void attack(Item myItem, NPC toAttack){
    toAttack.setIsEvil(true);
    if(myItem.getPower() == 0){
      System.out.println("You realize with horror that your " + myItem.getName() + " is broken and useless. You used it one too many times");

    }

    else if(myItem.getPower() == 10){
      inventory.remove(myItem);
      System.out.print("You shove the chip into " + toAttack.getNPCname() + "'s neck. He falls down, apparently dead!\n");
      getLocation().removeNPC(toAttack);
        }

    //if the power is 5, have it be a gun?  
    else if(myItem.getPower() == 5){
      //myItem.setPower(myItem.getPower()-1);
      //The robot or NPC is nearly dead, gun take off 3 life points
      if(toAttack.getStrength() <= 3){
        System.out.println("You aim and fire your " + myItem.getName() + " at your foe's chest. They collapse to the ground, dead.");
        getLocation().removeNPC(toAttack);
      }
       //you can't kill the NPC yet 
      else{
        //Remove 3 strength point from NPC
        toAttack.setStrength(toAttack.getStrength()-myItem.getPower());
        System.out.println("You hurt your foe. Their health is now: " + toAttack.getStrength());
        toAttack.attacksUser(this);
        
      }
      
    }
      
    else if(myItem.getPower() > 0){
      myItem.setPower(myItem.getPower()-1);
      //The robot or NPC is nearly dead
      if(toAttack.getStrength() == 1){
        System.out.println("You hurt your foe with " + myItem.getName() + ". They collapse to the ground, dead.");
        getLocation().removeNPC(toAttack);
      }
       //you can't kill the NPC yet 
      else{
        //Remove 1 strength point from NPC
        toAttack.setStrength(toAttack.getStrength()-1);
        System.out.println("You hit your foe with " + myItem.getName() + ". They flinch in pain.");
        //this.inventory.remove(myItem);
        System.out.println();
        toAttack.attacksUser(this);
      }
    }

    else if(myItem.getPower() == -1){
      System.out.println("You chuck your " + myItem.getName() + " at " + toAttack.getNPCname() + ". Alas, your food is too squishy to cause them any harm. It bounces off their head onto the ground.");
      getLocation().addItem(myItem);
			this.inventory.remove(myItem);
      System.out.println();
      toAttack.attacksUser(this);
    }
  }    
}