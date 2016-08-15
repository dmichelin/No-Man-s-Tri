/**
 * 
 */
package daniel.game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author Daniel
 *
 */
public class Game {
	private Player player;
	private Scanner playerInput;
	int planetsTravelledTo;
	int distanceTravelled;
	private Planet currentPlanet;
	private PlanetGenerator planetGenerator;
	
	public Game(){
		playerInput = new Scanner(System.in);
		player = new Player();
		distanceTravelled = 0;
		planetGenerator = new PlanetGenerator();
	}
	public void run(){
		// emulates a game actually loading up, pauses at title screen
		try {
		    Thread.sleep(5000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		clearScreen();
		currentPlanet = planetGenerator.generatePlanet(planetsTravelledTo);
		showStatus();
	}
	/**
	 * Method to clear the console. Current implementation works, but is not ideal
	 */
	private void clearScreen(){
		for(int i = 0; i < 50; i++){
			System.out.println("");
		}
	}
	/**
	 * Displays the players attributes
	 */
	private void showStatus(){
		System.out.println("Health: "+player.getHealth());
		System.out.println("Money: "+player.getMoney());
		System.out.println("Currently On: "+ currentPlanet.getName()+". It is a "+currentPlanet.getType()+" planet");
		System.out.println("Distance Travelled: "+ distanceTravelled + " Light Years");
	}
	
	

}
