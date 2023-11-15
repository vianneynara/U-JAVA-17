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
			for (int i = this.locations.length - 1, j = 0; i < tempArray.length; i++, j++) {
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
		for (double[] location : locations) {
			sb.append('[').append(location[0]).append(", ").append(location[1]).append(']');
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
