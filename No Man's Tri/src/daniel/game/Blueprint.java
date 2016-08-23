package daniel.game;

import java.util.List;

public class Blueprint extends Item {
	
	private float price;
	private String name;
	private String description;
	List<Item> itemsRequired;
	Item output;
	
	public Blueprint(String name, float price, String description,List<Item> itemsNeeded, Item output) {
		super(name,price,description);
		this.price = price;
		this.name = name;
		this.description = description;
		this.itemsRequired= itemsNeeded;
		this.output = output;
		
	}
	
	@Override 
	public boolean isSellable(){
		return false;
	}
	
	public Item craft(Player player){
		List<Item> inventory = player.getInventory();
		for(Item i : itemsRequired){
			System.out.println(i.getName()+" is needed");
		}
		System.out.println(inventory.containsAll(itemsRequired));
		if(inventory.containsAll(itemsRequired)){
			inventory.removeAll(itemsRequired);
			System.out.println("Crafting item "+ getName());
			return output;
		}
		else{
			System.out.println("Could not craft");
			return null;
		}
	}
}
