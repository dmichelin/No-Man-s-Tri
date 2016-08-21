/**
 * 
 */
package daniel.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Daniel
 * This class provides the market mechanics for the game
 */
public class Market {
	List<Item> globalMarket;
	List<Item> localMarket;
	public Market(){
		globalMarket = fetchGlobalMarket();
		createLocalMarket();
	}
	/**
	 * Fetches a permanent list of all available resources in the world. Could be later refactored to generate the list
	 * from an XML file
	 * @return
	 */
	private List<Item> fetchGlobalMarket() {
		List<Item> globalMarket = new ArrayList<Item>();
		//Uses all resources from No Man's Sky, according to here http://nomanssky.gamepedia.com/Resource
		globalMarket.add(new Item("Gold",300,"A rare neutral, sold widely and found in many electronics"));
		globalMarket.add(new Item("Iron",10,"A common oxide, found in all sorts of creations"));
		globalMarket.add(new Item("Zinc",40,"An uncommon metal, found in many electronic components and defensive devices"));
		globalMarket.add(new Item("Titanium",60,"An uncommon metal, found in many electronic components and defensive devices"));
		globalMarket.add(new Item("Heridium",30,"A common silicate, often used in vital elements for space exploration"));
		globalMarket.add(new Item("Platinum",50,"An uncommon silicate, used in many blueprints"));
		



		return globalMarket;
	}
	
	/**
	 * Creates a new market for each locale. Simply grabs an item out of the global market database and generates
	 * it using a range of values
	 * @return
	 */
	private List<Item> createLocalMarket(){
		List<Item> localMarket = new ArrayList<Item>();
		Random rand = new Random();
		for(Item i : globalMarket){
			if(i.getPrice()<=rand.nextInt(300)){
				localMarket.add(i);
			}
		}
		return localMarket;
	}
	
	

}
