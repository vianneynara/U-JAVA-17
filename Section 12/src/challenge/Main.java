package challenge;

public class Main {

	public static void main(String[] args) {
		Layer<Park> parkLayer = new Layer<>();

		Park tamanLawang = new Park("Taman Lawang");
		tamanLawang.setLocation("-6.2009, 106.8270");

		Park tamanWadukPluit = new Park("Taman Waduk Pluit");
		tamanWadukPluit.setLocation("-6.1051, 106.7963");

		parkLayer.addElements(tamanLawang, tamanWadukPluit);
		parkLayer.renderLayer();

		Layer<River> riverLayer = new Layer<>();

		River sungaiCiliwung = new River("Sungai Ciliwung");
		sungaiCiliwung.setLocations(
			"-6.1208, 106.8290",
			"-6.1635, 106.8381",
			"-6.1674, 106.8316");
		sungaiCiliwung.setLocations("-6.1703, 106.8323");

		riverLayer.addElements(sungaiCiliwung);
		riverLayer.renderLayer();
	}
}
