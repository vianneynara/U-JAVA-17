package challenge;

public class River extends Line {

	private String name;

	public River(String name) {
		this.name = name;
	}

	public River(String name, double[][] locations) {
		super(locations);
		this.name = name;
	}

	@Override
	public void render() {
		System.out.print("Render " + name + " ");
		super.render();
	}
}
