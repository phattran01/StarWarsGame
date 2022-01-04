import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

	private World world;
	private Player player;
	private Boolean forward;
	Map<Integer, Planet> options;
	List<String> defeatedVillains;
	private int totalSteps;


	public Game() {

		this.world = new World();
		this.player = this.world.getPlayer();
		this.options = new HashMap<>();
		
		defeatedVillains = new ArrayList<>();


	}

	public Boolean intro() { //displays a message for each option and returns T or F

		System.out.println("Do you want to play colossal cave adventure? (Star Wars Edition) Yes or No?");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.nextLine();

		if (userInput.toUpperCase().equals("YES")) {
			System.out.println("You chose to play the game!\n");
			return true;

		} else if (userInput.toUpperCase().equals("NO")) {
			System.out.println("You're missing out");
			System.exit(0);
		}
		return false;

	}

	public void forwardBackward() { //displays a message and assigns forward true or false

		System.out.println("Would you like to move forward or backward? Enter score to view score.");
		Scanner scanner = new Scanner(System.in);
		String selection = scanner.nextLine().toUpperCase();
		totalSteps+=1;
		if(selection.equals("SCORE")) {
			System.out.println("Score: " + player.getScore()+"\n");
			System.out.println("Would you like to move forward or backward?");
			selection = scanner.nextLine().toUpperCase();
		}
		if (selection.equals("FORWARD")) {
			forward = true;
			System.out.println("\nYou have chosen to move forward!\n");
		} else {
			forward = false;
			System.out.println("\nYou have chosen to move backward!\n");
		}

	}

	public void displayOptions() {

		Map<Integer, Planet> planets = world.getPlanets(); //different than the options Map above. //World Method
		//The above returns a map of locationID and planets that is already a member of the world that is a member of this game. 
		//Then that planets map is assigned to the variable planets here
		
		Integer locationId = player.getLocationId(); //Player method
		int i = 1;

		if (forward) {
			
			
			if (locationId < 7) {
				Planet forwardOne = planets.get(locationId + 1); //returns the next planet
				options.put(locationId + 1, forwardOne);
				System.out.println((locationId + 1) + ". Move forward to " + forwardOne.getName());
				i++;
			}

			if (locationId < 6) {
				Planet forwardTwo = planets.get(locationId + 2);
				options.put(locationId + 2, forwardTwo);
				System.out.println((locationId + 2) + ". Move forward to " + forwardTwo.getName());
				i++;

			}

			

		} else {

			if (locationId < 0) { //shouldn't this be locationId>0 
				Planet backwardOne = planets.get(locationId - 1);
				options.put(locationId - 1, backwardOne);
				System.out.println((locationId - 1) + ". Move backward to " + backwardOne.getName());
				i++;
			}

			if (locationId > 1) {
				Planet backwardTwo = planets.get(locationId - 2);
				options.put(locationId - 2, backwardTwo);
				System.out.println((locationId - 2) + ". Move backward to " + backwardTwo.getName());
				i++;
			}

		}

		if (i == 1) {
			System.out.println("You cannot move in that direction!");
			forwardBackward();
		}

	}

	public void move() { //The move method just sets the locationId and planet value to the new location
		System.out.println("Where would you like to go?");
		Scanner scanner = new Scanner(System.in);
		Integer selection = Integer.parseInt(scanner.nextLine());
		Planet planet = options.get(selection);
		player.move(selection, planet);
		player.setLocation(selection, planet);
	}

	public String tryLuck() { //Basically if the condition is met, we get an item and the score is added for that item!
		Random random = new Random();
		Double number = random.nextDouble(); 
		if (number > .2) {
			String item = player.applyItem(); //apply items does everything: randomly picks an item from the list and adds it's score: It ultimately returns the item picked
			return item;
		} else {
			return "No item";
		}
	}

	public void welcomeTo() { //just calls try luck and displays everything
		Planet planet = player.getLocation();
		System.out.println("Welcome to " + planet.getName() + "!");
		String item = tryLuck();
		if (!item.equals("No item")) {
			System.out.println("You got " + item + ". Your score is now " + player.getScore() + ".\n");
		} else {
			System.out.println("Looks like you didn't get anything!\n");
		}
	}



	public void fightMonster() { 
		int locationId = player.getLocationId();
		int score = player.getScore();	
		Set<String> inventory = player.getInventory();
		List<String> villainNames = new ArrayList<>();

		
		if((locationId==1)||(locationId==3)&&(!defeatedVillains.contains("Kylo Ren"))) {
			
			Villain vil = VillainFactory.getInstance(Villains.KYLO_REN); 
			vil.appear();
			totalSteps+=1;
			fight(inventory, vil, score);
		}
			
		if((locationId==2)||(locationId==5)&&(!defeatedVillains.contains("Darth Bane"))) {
			
			Villain vil = VillainFactory.getInstance(Villains.DARTH_BANE); 
			vil.appear();
			totalSteps+=1;
			fight(inventory, vil, score);
		}
			
			
		if((locationId==0)||(locationId==4)&&(!defeatedVillains.contains("Emperor Palpatine"))) {
				
				Villain vil = VillainFactory.getInstance(Villains.EMPEROR_PALPATINE); 
				vil.appear();
				totalSteps+=1;
				fight(inventory, vil, score);
		}
			
			
		if((locationId==6)||(locationId==7)&&(!defeatedVillains.contains("Darth Vadar"))) {
				
				Villain vil = VillainFactory.getInstance(Villains.DARTH_VADAR); 
				vil.appear();
				totalSteps+=1;
				fight(inventory, vil, score);
		}
			

	}	
		
	
	public void fight(Set<String> inventory, Villain vil, int score) {
		String villainName = vil.getname();
		boolean endFight = false;
		//inventory.add("Poison");
 
		if(vil.weaknesses(inventory)) {
        	player.changeScore(50);
    	    defeatedVillains.add(villainName);
        	endFight=true;
        } 
 
    	if(!endFight && vil.scoreToWin(score)) {
    		player.changeScore(30);
    	    defeatedVillains.add(villainName);
    		endFight = true;
    	}
 
 
        if(!endFight && vil.scoreToLose(score)) {
        	player.changeScore(-30);
        	endFight = true;
        }
 
 
        if(!endFight) {
        	if(vil.fightVillain(score, inventory)){
        		defeatedVillains.add(villainName);
        		player.changeScore(50);
        		endFight = true;
            }
        	else {
        		player.changeScore(-50);
        	}
        }
	}
	
	
	public void checkScore() {
		Integer score = player.getScore();
		if (score >= 100) {
			System.out.println("You've won!\nThe total amount of steps you took was "+ totalSteps + ". Play again for a better score!");
			System.exit(0);
		} else if (score <= -100) {
			System.out.println("You've lost!");
			System.exit(0);
		}
	}
	
}
