import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Player {
	
	private LightSaber lightsaber;
	private ScorableItems items = new ScorableItems();
	private Integer score = 0;
	private Integer locationId = 0;
	private Planet currentLocation;
	private Map<Integer, Planet> moves;
	private Set<String> inventory;

	public Player() {
		this.moves = new HashMap<>();
		this.lightsaber = new LightSaber();
		this.inventory = new HashSet<>();
		
	}
	
	public Planet getLocation() {
		
		return currentLocation;
		
	}
	
	public Integer getLocationId() {
		return locationId;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void changeScore(int num) {
		score+=num;
	}

	public void move(Integer move, Planet planet) {
		moves.put(move, planet);
		
	}
	
	public void setLocation(Integer locationId, Planet planet) {
		this.locationId = locationId;
		this.currentLocation = planet;
	}
	
	public String applyItem() {
		Integer size = items.itemsSize(); //size of the inventory is applied to the integer size: Total number of items. Items is just the list of all the items
		Random random = new Random(); //A random number is generated: INDEX FOR THE ITEMS LIST: *NOT THE SCORE*
		Integer number = random.nextInt(size); //"number is the random number 
		Set<String> i = items.itemsKeySet();  //i is the set of all the available items in the game
		List<String> itemsList = new ArrayList<>(i);  //just creating an array list instead of a set: Not sure why but list allows duplication
		String item = itemsList.get(number);  //returns the items at position "number"
		score = score + items.getPrize(item); //getPrize gives the points for the item and that is being added to the current score
		
		inventory.add(item); //This creates a list of items won by the player

		return item;  //The entirety of the method returns the item we just got
		
	}
	
	public void displayInventory(){ //Displays the items obtained by the player
        Iterator<String> i = inventory.iterator();

        System.out.println("Items in the inventory: ");
        while(i.hasNext()){
            String item = i.next();
            System.out.print(item+", ");
            
        }

     
   } 
	
	public Set<String> getInventory() {
   	 return inventory;
   	 
    }
	
	
	


}
