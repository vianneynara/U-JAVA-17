package challenge;

public class Park extends Point {

	private String name;

	public Park(String name) {
		this.name = name;
	}

	public Park(String name, double[] location) {
		super(location);
		this.name = name;
	}

	public Park(String name, String location) {
		super(location);
		this.name = name;
	}

	@Override
	public void render() {
		System.out.print("Render " + name + " ");
		super.render();
	}
}
