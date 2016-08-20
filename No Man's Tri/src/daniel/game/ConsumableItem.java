package daniel.game;

public class ConsumableItem extends Item {

	public ConsumableItem(String name, float price, String description) {
		super(name, price, description);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isUseable(){
		return true;
	}
	
	@Override
	public boolean isConsumable(){
		return true;
	}
}
