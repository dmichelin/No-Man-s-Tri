/**
 * 
 */
package daniel.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel
 * This is where the player data resides. 
 */
public class Player {
	// Roleplaying elements
	private float money; // Default is 100
	private int health; // Default is 10
	private int maxHealth; // Default value is 10
	private List<Item> inventory; // Default value is 10
	private int maxInventorySize; // Default is 10
	private int distanceTravelled;
	
	/**
	 *  For constructing a player, default values are for name and age only
	 * @param name The player's name
	 * @param age The player's age
	 */
	public Player(){
		money = 100;
		health = 10;
		maxHealth = 10;
		maxInventorySize = 10;
		inventory = new ArrayList<Item>();
		
	}
	/**
	 *  Returns the amount of money that the player has
	 * @return
	 */
	public float getMoney() {
		return money;
	}
	
	public void setMoney(float money) {
		this.money = money;
	}
	/**
	 * Provides healing mechanic for one health
	 * @return
	 */
	public boolean heal(int numHealthToHeal){
		// healthpool is the theoretical total health of the player after the heal
		int healthPool = health+numHealthToHeal;
		// Checks to see if you can heal
		if (health == maxHealth){
			return false;
		}
		// Shrinks the amount to the maximum health of the player if you are healed more than your max health
		else if(healthPool > maxHealth){
			health = maxHealth;
			return true;
		}
		// Finally, if the user can heal the full amount
		else{
			health = healthPool;
			return true;
		}
	}
	/**
	 * 
	 * @param item
	 * @return
	 */
	public boolean addItem (Item item){
		
			// If the inventory cannot contain the item, return false
			if(inventory.size() >= maxInventorySize)
			{
				return false;
			}
			// Otherwise add the item
			else{
				inventory.add(item);
				return true;
			}
		}
	/**
	 * Provides access to inventory items
	 * @param item
	 * @return
	 */
	public Item getItem(Item item){
		for(Item i : inventory){
			if(i.getName().contentEquals(item.getName())){
				return i;
			}
		}
		return null;
	}
	/**
	 * Removes an item from an inventory
	 * @param item
	 * @return
	 */
	public boolean discardItem(Item item){
		for(Item i : inventory){
			if(i.getName().contentEquals(item.getName())){
				inventory.remove(i);
				return true;
			}
		}
		return false;
	}
	public int getHealth() {
		return health;
	}
	

}