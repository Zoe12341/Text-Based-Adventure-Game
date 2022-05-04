
import java.util.*; 
/**
  * Starts playing game 
  */
class Main {
  public static void main(String[] args) {
    boolean keepPlaying = true;
    while(keepPlaying){
      RobotInvasion firstInvasion = new RobotInvasion();
    firstInvasion.setUp();
    firstInvasion.playGame();
      Scanner sc = new Scanner(System.in);
      System.out.println("Do you want to play  the game again?");
      String input = sc.nextLine();
			input = input.toLowerCase();
      if(input.equals("no") || input.equals("n")){
        keepPlaying = false;
      }
      else if(input.equals("yes") || input.equals("y")){
        System.out.println("Ok. Here we go again...");
      }
      else{
        System.out.println("Sorry, I don't recognize that command. I guess this means you don't want to play again.");
        keepPlaying = false;
      }
    }
  }
}