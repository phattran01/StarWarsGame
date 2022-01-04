
public class Planet {

	private final String name;
	private final Boolean hostile;

	public Planet(String name, Boolean hostile) {
		this.name = name;
		this.hostile = hostile;
	}

	public String getName() {
		return name;
	}

	public Boolean getHostile() {
		return hostile;
	}

}
