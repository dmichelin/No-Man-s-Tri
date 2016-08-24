/**
 * 
 */
package daniel.game;

import java.util.List;
import java.util.Random;
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
	private boolean shouldGeneratePlanet;
	private Market market;
	private List<Item> localMarket;
	
	public Game(){
		playerInput = new Scanner(System.in);
		player = new Player();
		distanceTravelled = 0;
		planetsTravelledTo =1;
		planetGenerator = new PlanetGenerator();
		shouldGeneratePlanet = true;
		market = new Market();
		localMarket = market.getLocalMarket();
	}
	public void run(){
		boolean gameNotEnded = true;
		while(gameNotEnded)
		{
			clearScreen();
			createWorld();
			showStatus();
			gameNotEnded = handleInput();
			
		}
	}
	/**
	 * Method to clear the console. Current implementation works, but is not ideal.
	 * I believe right now it is Windows OS dependent
	 */
	public static void clearScreen(){
		System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}
	/**
	 * Displays the players attributes
	 */
	private void showStatus(){
		System.out.println("");
		System.out.println("Health: "+player.getHealth());
		System.out.println("Money: "+player.getMoney());
		System.out.println("Currently On: "+ currentPlanet.getName()+". It is a "+currentPlanet.getType()+" planet");
		System.out.println("Distance Travelled: "+ distanceTravelled + " Light Years");
		if(player.getEquippedItem()!=null)
		{
			System.out.println("Equipped item: "+ player.getEquippedItem().getName());
		}
	}
	
	
	/** Handles player input
	 * 
	 * @return
	 */
	private boolean handleInput(){
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.println("");
		System.out.println("Travel to new planet: t");
		System.out.println("Show inventory: s");
		System.out.println("Mine a resource: m");
		System.out.println("Equip an item from inventory: e");
		System.out.println("Access the Galactic Market: g");
		System.out.println("Quit game: q");
		System.out.println("");
		
		
		switch(playerInput.next().toLowerCase()){
			// Simply travels to a different planet
			case "t":
				shouldGeneratePlanet = true;
				return true;
				
			// Lists the player's inventory if it is not empty, does not cause a generation of a new planet
			case "s":
				List<Item> inventory = player.getInventory();
				if(!inventory.isEmpty())
				{
					System.out.println("");
					for(Item i : inventory){
						System.out.println(i.getName());
					}
				}else{
					System.out.println("Your inventory is empty");
				}
				shouldGeneratePlanet = false;
				return true;
				
			// Quits the game	
			case "q":
				return false;
				
			// Gives the player a random item	
			case "m":
				player.addItem(new Item("The finest shard of gold",1,"The finest shard of gold to have ever existed"));
				shouldGeneratePlanet = false;
				return true;
			// Allows a player to access their inventory and equip something
			case "e":
				List<Item> inventory1 = player.getInventory();
				if(!inventory1.isEmpty())
				{
					System.out.println("");
					int count = 0;
					for(Item i : inventory1){
						System.out.println(count + " - " + i.getName());
						count++;
					}
					System.out.println("What would you like to equip?");
					player.setEquippedItem(player.getInventory().get(playerInput.nextInt()));
				}else{
					System.out.println("Your inventory is empty");
				}
				shouldGeneratePlanet = false;
				return true;
			// Displays all available resources from the local market
			case "g":
				clearScreen();
				for(Item i: localMarket){
					System.out.println(i.getName() + " - $"+i.getPrice());
				}
				shouldGeneratePlanet = false;
				return true;
			// Provides crafting functionality for the player
			case "c":
				player.addBlueprint((Blueprint)market.globalMarket.get("AntimatterBlueprint"));
				System.out.println("What would you like to craft? Enter the number of the item you want to create");
				int i = 0;
				for(Blueprint b : player.getKnownBlueprints()){
					System.out.println(i + " - " + b.getName() + " " + b.getDescription());
				}
				int response = playerInput.nextInt();
				if(player.getKnownBlueprints().size()>response){
					if(player.addItem(player.getKnownBlueprints().get(response).craft(player))){
						System.out.println("Item crafted");
					}else System.out.println("Item not crafted");
				}else System.out.println("You entered a number outside of available responses");
				shouldGeneratePlanet = false;
				return true;
				
		}
		
		return false;
	}
	/**
	 * Handles creating the environment for the player
	 */
	private void createWorld(){
		//shouldGeneratePlanet is either true or false depending on what the user inputs during handleInput();
		if(shouldGeneratePlanet){
			Random distanceGenerator = new Random();
			currentPlanet = planetGenerator.generatePlanet(planetsTravelledTo);
			distanceTravelled+=distanceGenerator.nextInt(500) ; // Creates a random distance length travelled
			planetsTravelledTo++;
			localMarket = market.createLocalMarket();
		}
		
	}

}
