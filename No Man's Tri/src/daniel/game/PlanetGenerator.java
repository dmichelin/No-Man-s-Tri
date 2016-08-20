package daniel.game;

import java.util.Random;

public class PlanetGenerator {
	String[] planetTypes;
	String[] descriptions;
	String[] middleNames;
	String[] finalNames;
	
	public PlanetGenerator(){
		planetTypes = new String[]{
				
				//Beginning planet types
				"Barren", "Rocky", "Desert","Wooded"
				// Later planet types
				,"Xenopogenic","Anthropogenic","Volcanous", "Archipelagic",
				// Even later planet types
				"Indescribable", "Infernous"
				};
		middleNames = new String[]{"Babylon","Perseus", "Washington", "Vishnu", "Ghandi", "Jackson", "Abd-Allah", "Prometheus"};
		finalNames = new String[]{"Prime", "Omega", "Tau", "Alpha", "Beta"};
	}
	public Planet generatePlanet(int planetsTravelledTo){
		Random gen = new Random();
		String name = generatePlanetName();
		return new Planet(name,planetTypes[gen.nextInt(Math.min(planetsTravelledTo,planetTypes.length))]);
	}
	/**
	 * Generates a name for a planet
	 * @return Returns a planet name
	 */
	public String generatePlanetName(){

		Random gen = new Random();
		// Creates a prefex for the planet in the form of a number
		int number = gen.nextInt(30);
		// Grabs a name out of a list
		String middle = middleNames[gen.nextInt(middleNames.length)];
		String end = "";
	
			// Grabs a name out of a list
			end = finalNames[gen.nextInt(finalNames.length)];
		// Returns the three names put together
		return number + " " + middle + " " + end;
		
	}
}
