package challenge;

public class Main {

	public static void main(String[] args) {
		Layer<Mappable> map = new Layer<>();

		Park tamanLawang = new Park("Taman Lawang");
		tamanLawang.setLocation("-6.200932666954709, 106.82700622668004");

		River sungaiCiliwung = new River("Sungai Ciliwung");
		sungaiCiliwung.setLocations(
			"-6.120834319309722, 106.82905592593758",
			"-6.163546852013936, 106.83819079271895",
			"-6.167417470197154, 106.83162125021221");
		sungaiCiliwung.setLocations("-6.170343170532965, 106.83234340738224");

		Park tamanWadukPluit = new Park("Taman Waduk Pluit");
		tamanWadukPluit.setLocation("-6.105178688086008, 106.79637151829542");

		map.addElements(tamanLawang, sungaiCiliwung, tamanWadukPluit);
		map.renderLayer();
	}
}
