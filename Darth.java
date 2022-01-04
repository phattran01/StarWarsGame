import java.util.ArrayList;
import java.util.Set;

public class Darth extends Villain{
	
	public Darth(String name, int maxScore, int minScore, String i1, String i2) {
		super(name, maxScore, minScore, "Alien hair", "Alien skin", "Alien blood", "");
		items = new ArrayList<String>();
		items.add(i1); //Difficulty increases with a bane; Common weaknesses
		items.add(i2);
	}
	
	
	public void appear() {
		System.out.println("You encounter a Darth Villain");
	}
	
	
	public boolean scoreToWin(int currentScore){
		return false;
	}

	public boolean scoreToLose(int currentScore){
		return false;
	}
	
	public boolean fightVillain(int currentScore, Set<String> inventory) {
		return true;	
	}
	
	
	public boolean weaknesses(Set<String> inventory) {
		return true;
	
	}
	
}
