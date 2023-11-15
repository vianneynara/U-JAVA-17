package challenge;

import java.util.Arrays;

public abstract class Line implements Mappable {

	protected double[][] locations;

	public Line() {}

	public Line(double[][] locations) {
		this.locations = locations;
	}

	// Setters

	public void setLocations(String... locations) {
		double[][] tempArray;
		if (this.locations != null) {
			tempArray = Arrays.copyOf(this.locations, this.locations.length + locations.length);
			// this loop appends the previous locations array with the new array starting from the last index + 1
			for (int i = this.locations.length, j = 0; i < tempArray.length; i++, j++) {
				tempArray[i] = Mappable.stringToLatLon(locations[j]);
			}
		} else {
			tempArray = new double[locations.length][];
			for (int i = 0; i < tempArray.length; i++) {
				tempArray[i] = Mappable.stringToLatLon(locations[i]);
			}
		}
		this.locations = tempArray;
	}

	public void setLocations(double[][] locations) {
		this.locations = locations;
	}

	private String locations() {
		StringBuilder sb = new StringBuilder("([");
		for (int i = 0; i < locations.length; i++) {
			sb.append('[').append(locations[i][0]).append(", ").append(locations[i][1]).append(']');
			if (i != locations.length - 1) {
				sb.append(", ");
			}
		}
		return sb.append("])").toString();
	}

	@Override
	public void render() {
		if (locations != null) {
			System.out.println("LINE " + locations());
		} else {
			System.out.println("LINE <COORDINATES NOT SET> ");
		}
	}
}
