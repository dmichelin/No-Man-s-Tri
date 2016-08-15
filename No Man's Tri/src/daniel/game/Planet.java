package daniel.game;

import java.util.List;

public class Planet {
	private String name;
	private String type;
	private String description;
	private List<Item> minableItems;
	private List<Item> searchableItems;
	
	public Planet(String name, String type){
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public List<Item> getMinableItems() {
		return minableItems;
	}

	public List<Item> getSearchableItems() {
		return searchableItems;
	}

	

}
