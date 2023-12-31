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

	public River(String name, String... locations) {
		super(locations);
		this.name = name;
	}

	@Override
	public void render() {
		System.out.print("Rendering name: \"" + name + "\", ");
		super.render();
	}
}
