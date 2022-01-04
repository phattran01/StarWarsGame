import java.util.HashMap;
import java.util.Map;

public class World {
	
	private static Map<Integer, Planet> planets = new HashMap<>();
	private Player player;
	
	public World() {
		
		this.player = new Player();
		
		planets.put(0, new Planet("Coruscant", true));
		planets.put(1, new Planet("Utapau", false));
		planets.put(2, new Planet("Mygeeto", false));
		planets.put(3, new Planet("Felucia", false));
		planets.put(4, new Planet("Kashyyyk", false));
		planets.put(5, new Planet("Cato Neimoidia", true));
		planets.put(6, new Planet("Saleucami", true));
		planets.put(7, new Planet("Mustafar", true));
		
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Map<Integer, Planet> getPlanets() {
		return planets;
	}
	
	public Planet getPlanet(Integer locationId) {
		return planets.get(locationId);
	}

}
