package challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Layer<T extends Mappable> {

	private List<Mappable> elements;

	public Layer() {
		this.elements = new ArrayList<>();
	}

	public Layer(List<Mappable> elements) {
		this.elements = new ArrayList<>(elements);
	}

	public void addElements(Mappable... elements) {
		this.elements.addAll(Arrays.asList(elements));
	}

	public void renderLayer() {
		for (Mappable e : elements) {
			e.render();
		}
	}
}
