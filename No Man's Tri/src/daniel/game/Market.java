/**
 * 
 */
package daniel.game;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * @author Daniel
 * This class provides the market mechanics for the game
 */
public class Market {
	Hashtable<String,Item> globalMarket;
	List<Item> localMarket;
	public Market(){
		globalMarket = fetchGlobalMarket();
		createLocalMarket();
	}
	/**
	 * Fetches a permanent list of all available resources in the world. Could be later refactored to generate the list
	 * from an XML file or by creating a new class containing methods for finding and retriving all the items in the game using
	 * a hashtable. The programming here is pretty scrappy right now
	 * @return
	 */
	private Hashtable<String,Item> fetchGlobalMarket() {
		Hashtable<String, Item> allItems = new Hashtable<String,Item>();
		//Uses all resources from No Man's Sky, according to here http://nomanssky.gamepedia.com/Resource
		
		//Oxides
		allItems.put("Iron",new Item("Iron",10,"A common oxide, found in all sorts of creations"));
		allItems.put("Zinc",new Item("Zinc",40,"An uncommon metal, found in many electronic components and defensive devices"));
		allItems.put("Titanium",new Item("Titanium",60,"An uncommon metal, found in many electronic components and defensive devices"));
		
		//Silicates
		allItems.put("Heridium",new Item("Heridium",30,"A common silicate, often used in vital elements for space exploration"));
		allItems.put("Platinum",new Item("Platinum",50,"An uncommon silicate, used in many blueprints"));

		//Isotopes
		allItems.put("Carbon",new Item("Carbon",6,"A common isotope, found in nearly everything"));
		allItems.put("Thamium9",new Item("Thamium9",20,"An uncommon isotope, and a powerful energy source"));
		allItems.put("Plutonium",new Item("Plutonium",40,"A rare isotope, used as a potent energy source"));
		
		//Neutrals
		allItems.put("Gold",new Item("Gold",200,"A rare neutral, sold widely and found in many electronics"));
		allItems.put("Nickel",new Item("Nickel",137,"A common neutral, worth a good amount of money and used in armor plating"));
		allItems.put("Iridium",new Item("Iridium",96,"An uncommon neutral, a lustrous transition metal favored by traders"));
		allItems.put("Copper",new Item("Copper",110,"An uncommon neutral, commonly found in electronics"));
		allItems.put("Aluminium",new Item("Aluminium",165,"A rare neutral, frequnetly used in construction of space crafts and weapons"));
		allItems.put("Emeril",new Item("Emeril",275,"A rare neutral, it emits a small amount of radiation. Used in colonial stations"));		

		//Precious
		allItems.put("Omegon",new Item("Omegon",309,"Dark matter element. A hugely powerful, largely unknown and entirely untested substance. It is extremely rare."));
		allItems.put("Radnox",new Item("Radnox",302,"Mysterious and valuable chemical resource."));
		allItems.put("Murrine",new Item("Murrine",302,"Valuable commodity known for it's charming qualities."));
		allItems.put("Calium",new Item("Calium",288,"Calium is a rare substance, and can be found on extremely hostile planets."));
		
		//Other items
		allItems.put("SuspensionFluid",new Item("Suspension Fluid",1100,"Non-reactive and pressure-resistant liquid. Vital to the manufacture of starship and exosuit technologies."));
		allItems.put("Electron Vapor", new Item("Electron Vapor",4950,"Captured cloud of ionised electrons. A fundamental component of many technologies, and often used in the creation of antimatter."));
		allItems.put("Antimatter", new Item ("Antimatter",5232,"Captured cloud of ionised electrons. A fundamental component of many technologies, and often used in the creation of antimatter."));
		allItems.put("Warp Cell", new Item("Warp Cell",46750,"Warp Cells are used to charge starship Hyperdrives and to enable Faster Than Light (FTL) warp speeds."));
		//Recipies
		
		
			//Recipe for suspension fluid, 50x Carbon
		List<Item> suspenList = new ArrayList<Item>();
		for(int i = 0; i<50;i++){
			suspenList.add(allItems.get("Carbon"));
			
		}
			// Add the recipe
		allItems.put("SuspensionFluidBlueprint",new Blueprint("Suspension Fluid",1100,"Non-reactive and pressure-resistant liquid. Vital to the manufacture of starship and exosuit technologies.", suspenList,allItems.get("SuspensionFluid")));
			
		
			//Recipe for electron vapor , 1x Suspension Fluid and 100x Plutonium
		List<Item> vaporList = new ArrayList<Item>();
		for(int i = 0; i<100;i++){
			vaporList.add(allItems.get("Plutonium"));
		}
		
		vaporList.add(allItems.get("SuspensionFluid"));
//			 Add the recipe
		allItems.put("ElectronVaporBlueprint",new Blueprint("Electron Vapor",4950,"Captured cloud of ionised electrons. A fundamental component of many technologies, and often used in the creation of antimatter.",vaporList,allItems.get("Electron Vapor")));
		
		
		
		// recipe for Antimatter, 1x Electron Vapor, 50x Heridium, 20x Zinc
		List<Item> antiList = new ArrayList<Item>();
		for(int i = 0; i<50;i++){
			antiList.add(allItems.get("Heridium"));
		}
		for(int i = 0; i<20;i++){
			antiList.add(allItems.get("Zinc"));
		}
		antiList.add(allItems.get("Electron Vapor"));
		
			// Add the recipe
		allItems.put("AntimatterBlueprint",new Blueprint("Antimatter",5232,"Captured cloud of ionised electrons. A fundamental component of many technologies, and often used in the creation of antimatter.",vaporList,allItems.get("Antimatter")));
		
			
		
			// Recipe for Warp Cell
		List<Item> warpList = new ArrayList<Item>();
		for(int i = 0; i<100;i++){
			warpList.add(allItems.get("Thamium9"));
		}
		warpList.add(allItems.get("Antimatter"));
		allItems.put("WarpCellBlueprint",new Blueprint("Warp Cell",46750,"Warp Cells are used to charge starship Hyperdrives and to enable Faster Than Light (FTL) warp speeds.",antiList,allItems.get("Warp Cell")));

		



		return allItems;
	}
	
	public Hashtable<String,Item> getGlobalMarket() {
		return globalMarket;
	}
	public List<Item> getLocalMarket() {
		return localMarket;
	}
	/**
	 * Creates a new market for each locale. Simply grabs an item out of the global market database and generates
	 * it using a range of values
	 * @return
	 */
	public List<Item> createLocalMarket(){
		List<Item> localMarket = new ArrayList<Item>();
		Random rand = new Random();
		List<Item> globMark = new ArrayList<Item>(globalMarket.values());
		for(Item i : globMark){
			if(i.getPrice()<=rand.nextInt(330)&&!(i instanceof Blueprint)) // Just checking to make sure the store is not populated with any blueprints
			{
				localMarket.add(i);
			}
		}
		return localMarket;
	}
	

}
