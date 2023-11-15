package challenge;

public abstract class Point implements Mappable {

	protected double[] location;

	public Point() {}

	public Point(double[] location) {
		this.location = location;
	}

	public Point(String location) {
		this.location = Mappable.stringToLatLon(location);
	}

	// Setters

	public void setLocation(String location) {
		this.location = Mappable.stringToLatLon(location);
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	private String location() {
		return "([" + location[0] + ", " + location[1] + "])";
	}

	@Override
	public void render() {
		if (location != null) {
			System.out.println("POINT " + location());
		} else {
			System.out.println("POINT <COORDINATES NOT SET> ");
		}
	}
}
