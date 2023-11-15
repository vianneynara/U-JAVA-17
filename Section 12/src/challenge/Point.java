package challenge;

public abstract class Point implements Mappable {

	protected double[] location;

	public Point(double[] location) {
		this.location = location;
	}

	private String location() {
		return "([" + location[0] + ", " + location[1] + "])";
	}

	@Override
	public void render() {
		System.out.println("POINT " + location());
	}
}
