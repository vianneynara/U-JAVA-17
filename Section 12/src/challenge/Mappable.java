package challenge;

public interface Mappable {

	void render();

	static double[] stringToLatLon(String coordinates) {
		final String[] spliited = coordinates.split(",\\s");
		if (spliited.length == 2) {
			double[] converted = new double[2];
			for (int i = 0; i < 2; i++) {
				converted[i] = Double.parseDouble(spliited[i]);
			}
			return converted;
		} else {
			throw new IllegalArgumentException("The string passed is not properly formatted!");
		}
	}
}
