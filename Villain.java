import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Villain {
	
	String name;
	 int maxScore;
	 int minScore;
	 List<String> weaknesses;
	 List<String> items;
	
	 boolean won = true;

	Villain(String name, int maxScore, int minScore, String w1, String w2, String w3, String w4){
		this.name = name;
		this.maxScore = maxScore;
		this.minScore = minScore;
		this.weaknesses = new ArrayList<>();
		setWeaknesses(w1, w2, w3, w4);
	}
	
		

	
	public String getname() {
		return name;
	}
	
	public void appear() {
		System.out.println("You encounter a villain");
	}
	
	public int getmaxScore() {
		return maxScore;
	}
	
	public int getminScore() {
		return minScore;
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
	
	public void setWeaknesses(String w1, String w2, String w3, String w4) {
		weaknesses.add(w1);
		weaknesses.add(w2);
		weaknesses.add(w3);
		weaknesses.add(w3);

		
	}
	

}
