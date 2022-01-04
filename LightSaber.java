import java.util.Scanner;

public class LightSaber {
	
	private String saberColor;
	private Boolean darkSide;
	
	public LightSaber() {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Which color lightsaber do you want you can choose Red, Green or Blue?");
		saberColor = scanner.nextLine();
		
		if (saberColor.equals("Red")) {
			
			this.saberColor = "Red";
			this.darkSide = true;
			System.out.println("You chose the Red lightsaber. You're on the dark side!");
			
		} else if (saberColor.equals("Green")) {
			
			this.saberColor = "Green";
			this.darkSide = false;
			System.out.println("You chose the Green lightsaber. You're a Jedi!");
			
		} else if (saberColor.equals("Blue")) {
			
			this.saberColor = "Blue";
			this.darkSide = false;
			System.out.println("You chose the Blue lightsaber. You're a Jedi!");
		}
		
	}
	
	public String getColor() {
		return saberColor;
	}
	
	public Boolean getSide() {
		return darkSide;
	}

}
