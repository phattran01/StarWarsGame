import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		Game game = new Game();
		
		game.intro();
		
		while (true) {
			game.checkScore();
			
			game.forwardBackward();
			
			game.displayOptions();
			
			game.move();
						
			game.welcomeTo();
			
			game.fightMonster();
			
		}


	}

}
