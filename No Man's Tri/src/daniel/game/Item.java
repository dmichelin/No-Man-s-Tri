package daniel.game;

public abstract class Item {
	// Item attribute
	private float price;
	private String name;
	
	public abstract void use();

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
}
