package challenge;

public abstract class Line implements Mappable {

	protected double[][] locations;

	public Line(double[][] locations) {
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
		System.out.println("LINE " + locations());
	}
}
