/**
 * 
 */
package daniel.game;

/**
 * @author Daniel
 * This is where the game actually launches. Contained in this 
 */
public class Main {

	
	public static void main(String[] args) {
		Game.clearScreen();
		System.out.println(" _   _        ___  ___            _       _____    _ ");
		System.out.println("| \\ | |       |  \\/  |           ( )     |_   _|  (_)");
		System.out.println("|  \\| | ___   | .  . | __ _ _ __ |/ ___    | |_ __ _ ");
		System.out.println("| . ` |/ _ \\  | |\\/| |/ _` | '_ \\  / __|   | | '__| |");
		System.out.println("| |\\  | (_) | | |  | | (_| | | | | \\__ \\   | | |  | |");
		System.out.println("\\_| \\_/\\___/  \\_|  |_/\\__,_|_| |_| |___/   \\_/_|  |_|");
		System.out.println("Pretending to start game...");
		
		// emulates a game actually loading up, pauses at title screen
//		try {
//		    Thread.sleep(5000);
//		} catch(InterruptedException ex) {
//		    Thread.currentThread().interrupt();
//		}
		
		// Starts the actual game
		Game game = new Game();
		game.run();

	}

}
