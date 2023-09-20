import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

	private String name;
	private String weapon;
	private int hitPoints;
	private int strength;

	public Player(String name, int hitPoints, int strength) {
		this.name = name;
		this.hitPoints = hitPoints;
		this.strength = strength;
		this.weapon = "Sword";
	}

	/* Getters */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	/* Interface methods */

	@Override
	public List<String> write() {
		List<String> data = new ArrayList<>();
		data.add(getName());
		data.add(String.valueOf(getHitPoints()));
		data.add(String.valueOf(getStrength()));
		data.add(getWeapon());
		return data;
	}

	@Override
	public void read(List<String> data) {
		if (data != null && data.size() > 0) {
			setName(data.get(0));
			setHitPoints(Integer.parseInt(data.get(1)));
			setStrength(Integer.parseInt(data.get(2)));
			setWeapon(data.get(3));
		}
	}

	@Override
	public String toString() {
		return "Player{" +
			"name='" + name + '\'' +
			", hitPoints=" + hitPoints +
			", strength=" + strength +
			", weapon='" + weapon + '\'' +
			'}';
	}
}
