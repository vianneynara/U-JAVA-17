package challenge;

public interface Mappable {

	void render();

	static double[] stringToLatLon(String coordinates) {
		final String[] spliited = coordinates.split(",");
		if (spliited.length == 2) {
			double[] converted = new double[2];
			for (int i = 0; i < 2; i++) {
				try {
					converted[i] = Double.parseDouble(spliited[i].trim());
				} catch (NumberFormatException e) {
					throw new IllegalArgumentException("Error parsing '" + spliited[i] + "' as a double value.");
				}
			}
			return converted;
		} else {
			throw new IllegalArgumentException("The passed string is not properly formatted!");
		}
	}
}
