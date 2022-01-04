import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class EmpPalp extends Villain {
	public EmpPalp() {
		// Sets villain name, max score, and min score
		super("Emperor Palpatin", 60, -60, "Diamond", "Fire pit", "Posion", "Alien blood");
		// Sets villain weaknesses
		
		// Sets items required to beat villain
		this.items = new ArrayList<String>();
		items.add("Shield");
		items.add("Arrows");
		items.add("Boost");
		items.add("Night Vision Goggles");

	}
		
	
	
	public void appear() {
		System.out.println(getname() + " has appeared before you");
	}
	
	public boolean scoreToWin(int currentScore){
		// If score is above indicated max score value, user automatically wins
		if(currentScore>(getmaxScore())) {
			System.out.println("You have over " + getmaxScore() + " points. " + getname() + " was scared away, you win!\n");
			return true;
		}
		return false;
	}

	public boolean scoreToLose(int currentScore){
		// If score is under indicated min score value, user automatically loses
		if(currentScore<(getminScore())) {
			System.out.println("Your score is lower than " +getminScore()+ ".That is too low to fight "+ getname() + ". 30 points lost.");
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean fightVillain(int currentScore, Set<String> inventory) {
		boolean won = false;
		// User can win if score is between two values, and user has 1 of three items indicated in items list
		System.out.println("You can use these items to defeat " + getname() + " only if your score "
				+ "\nis in between " + getminScore() + " and " + getmaxScore());
		for(String i:items) {
			System.out.print(i + "     ");
		}
		
		// Requests input from user for next game action
		System.out.println("\nEnter \"items\" to check your inventory"
				+ "\nWould you like to fight? (Yes/No). -50 points if you do not fight\n");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		
		if(currentScore<getmaxScore()&&currentScore>getminScore()) {
			
			// Displays users inventory if input is "items"
			if(choice.toUpperCase().equals("ITEMS")){
				for(String item:inventory) {
					System.out.println(item);
				}
				
				// Asks user if they want to fight after viewing items
				System.out.println("\nWould you like to fight? (Yes/No). -50 points if you do not fight\n");
				choice = scanner.nextLine();
			}
			
			// Checks to see if user has weakness item if user replies "yes" to play
			if(choice.toUpperCase().equals("YES")) {
				String item = "";
				for(String i:items) {
					if(inventory.contains(i)) {
						item=i;
						System.out.println("You have defeated " + getname() + " using " + item +".\n");
						won=true;
						break;
					}
				}
				if(!won) {
					System.out.println("You fought " + getname() + ". You did not have any of the items so he beat you.");
				}
			}
			else {
				System.out.println("You choose to not fight. Continuing on.\n");
			}
		}
		return won;
	}
	
	public boolean weaknesses(Set<String> inventory) {
		
		// Prints the enemy weaknesses
		System.out.println("\nYour enemy has the following weaknesses: ");
		for(String w:weaknesses) {
			System.out.print(w + "     ");
		}
		
		// Requests input from user for next game action
		System.out.println("\nEnter \"items\" to check your inventory"
				+ "\nWould you like to fight? (Yes/No)\n");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();
		
		// Displays users inventory if input is "items"
		if(choice.toUpperCase().equals("ITEMS")){
			for(String item:inventory) {
				System.out.println(item);
			}
			System.out.println("\nWould you like to fight? (Yes/No)\n");
			choice = scanner.nextLine();
		}
		
		// Checks to see if user has weakness item if user replies "yes" to play
		if(choice.toUpperCase().equals("YES")){
			for(String weakness:weaknesses) {
				if(inventory.contains(weakness)) {
					System.out.println("You have found " + getname() + "'s weakness. He is weak against "+weakness+". You have defeated " + getname() + " using "+weakness);
					return true;
				}
				else {
					System.out.println("You did not have any of " + getname() + "'s weaknesses. Continuing fight.\n");
					return false;
				}
			}
		}
		else {
			System.out.println("You chose not to use a weakness item. Continuing fight.\n");
		}
		
		return false;	
	}
}

