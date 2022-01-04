import java.util.*;

public class ScorableItems{

    private Map<String, Integer> items; //Map of items as keys and scores as values

    public ScorableItems() {
        this.items = new HashMap<>();
        init();
    }

    private void init() {				//26 items with scores: 
        items.put("lamp", 10);
        items.put("lamp x2", 20);
        items.put("Diamond", 30);
        items.put("Snake trap", -10);
        items.put("Fire pit", -15);
        items.put("Treasure Box", 40);
        items.put("Arrow", 5);
        items.put("Gold Rock", 16);
        items.put("Secret Dust", 12);
        items.put("Planet Mineral", 19);
        items.put("Boost", 13);
        items.put("Alien hair", -18);
        items.put("Alien skin", -10);
        items.put("Alien blood", -40);
        items.put("FREE A ALIEN BABY", 20);
        items.put("Fire Wood", 6);
        items.put("Water", 8);
        items.put("Ropes", 4);
        items.put("Space Ship Fuel", 22);
        items.put("Compass", 45);
        items.put("Night Vision Goggles", 20);
        items.put("Shield", 20);
        items.put("Black Hole", -100);
        items.put("Spikes", -12);
        items.put("Serpants", -16);
        items.put("Poison", -13);

    }
    
    public void displayCurrentItems(){ //Displays all the items 
        Set<String> things = items.keySet();
        Iterator<String> iterate = things.iterator();

        System.out.println("These are the available prizes: ");
        while(iterate.hasNext()){
            String key = iterate.next();
            System.out.println(key + ": " + items.get(key));
        }

    }
    public Integer getPrize(String key){  //Just tells what the points are for each item
        Integer points = items.get(key);
        items.remove(key);
        return points;
    }
    
    public Integer itemsSize() {  //Returns the total number of items
    	return items.size();
    }
    
    public Set<String> itemsKeySet() {  //Returns a set of the items: Basically returning the "things" from first method
    	return items.keySet();
    }


}