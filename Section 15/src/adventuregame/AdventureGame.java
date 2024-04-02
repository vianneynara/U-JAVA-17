package adventuregame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AdventureGame {
	/**
	 * Data from CSV file to be extracted.
	 * */
	private static final String LOCATIONS = """
		road,at the end of the road, W: hill, E:well house,S:valley,N:forest
		hill,on top of hill with a view in all directions,N:forest, E:road
		well house,inside a well house for a small spring,W:road,N:lake,S:stream
		valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
		forest,at the edge of a thick dark forest,S:road,E:lake
		lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
		stream,near a stream with a rocky bed,W:valley, N:well house
		""";

	/**
	 * This enum represents the compass directions with their string representation (with ordinal).
	 * */
	private enum Compass {
		N, S, E, W;

		private static final String[] directions = {
			"North", "South", "East", "West"
		};

		public String getString() {
			return directions[this.ordinal()];
		}
	}

	/**
	 * This record represents a location with description and mapping corresponding to the compass.
	 * */
	private record Location(String description, Map<Compass, String> nextLocations) {
	}

	/**
	 * Directions loader helper.
	 * */
	private Map<Compass, String> loadDirections(String nextLocations) {
		Map<Compass, String> directions = new HashMap<>();
		for (String location : nextLocations.split(",")) {
			String[] parts = location.split(":", 2);
			Arrays.asList(parts).replaceAll(String::trim);
			directions.put(Compass.valueOf(parts[0]), parts[1]);
		}
		return directions;
	}

	/**
	 * Location loader helper.
	 * */
	private Map<String, Location> loadLocations(String data) {
		Map<String, Location> mappedLocations = new HashMap<>();
		for (String line : data.split("\\R")) {
			// limits the split to 3 parts AND trim every element
			String[] parts = line.split(",", 3);
			Arrays.asList(parts).replaceAll(String::trim);

			// loads the third part as directions map
			Map<Compass, String> nextLocations = loadDirections(parts[2]);
			Location location = new Location(parts[1], nextLocations);
			mappedLocations.put(parts[0], location);
		}
		// print the loaded locations
//		mappedLocations.forEach((k, v) -> System.out.printf("%s:%s%n", k, v));

		return mappedLocations;
	}

	private String lastLocation;
	private Map<String, Location> adventureMap = new HashMap<>();

	/**
	 * Create default instance.
	 * */
	public AdventureGame() {
		this(null);
	}

	/**
	 * Create instance with custom locations. Sets the adventure map with the loaded locations.
	 * */
	public AdventureGame(String customLocations) {
		if (customLocations != null && !customLocations.isBlank()) {
			adventureMap = loadLocations(customLocations);
		} else {
			adventureMap = loadLocations(LOCATIONS);
		}
	}

	// methods

	private void visit(Location location) {
		System.out.printf("=== You're standing %s ===%n", location.description);
		System.out.println("\tFrom this point, you can go to:");
		location.nextLocations.forEach((k, v) -> {
			System.out.printf("\t> %-6s -> %s%n", k.getString(), v);
		});
		System.out.print("Available directions are " + location.nextLocations.keySet() + "(Q to quit): ");
	}

	public void move(String direction) {
		var nextLocations = adventureMap.get(lastLocation).nextLocations;
		var compass = Compass.valueOf(direction);
		if (!nextLocations.containsKey(compass)) {
			System.out.println("Invalid direction.");
		} else {
			play(nextLocations.get(compass));
		}
	}

	public void play(String location) {
		if (!adventureMap.containsKey(location)) {
			System.out.println("Invalid location.");
		} else {
			Location nextLocation = adventureMap.get(location);
			lastLocation = location;
			visit(nextLocation);
		}
	}

	public boolean locationAvailable(String location) {
		try {
			Compass.valueOf(location);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return adventureMap.get(lastLocation).nextLocations.containsKey(Compass.valueOf(location));
	}
}
