package intros;

import java.util.ArrayList;
import java.util.List;

record Affiliation(String name, String type, String countryCode) {

	@Override
	public String toString() {
		return name + " (" + type + " in " + countryCode + ") ";
	}
}

public class Team<T extends Player, S> {

	private String teamName;
	private List<T> teamMembers = new ArrayList<>();
	private int totalWins;
	private int totalLosses;
	private int totalTies;
	private S affiliation;

	public Team(String teamName) {
		this.teamName = teamName;
	}

	public Team(String teamName, S affiliation) {
		this.teamName = teamName;
		this.affiliation = affiliation;
	}

	public void addTeamMember(T player) {

		if (!teamMembers.contains(player)) {
			teamMembers.add(player);
		}
	}

	public void listTeamMembers() {
		System.out.print(teamName + " Roster:");
		System.out.println(affiliation == null ? "" : "intros.Affiliation: " + affiliation);
		for (T m : teamMembers) {
			System.out.println(m.name());
		}
	}

	public int ranking() {
		return (totalLosses * 2) + totalTies + 1;
	}

	public String setScore(int ourScore, int theirScore) {

		String message = "lost to";
		if (ourScore > theirScore) {
			totalWins++;
			message = "beat";
		} else if (ourScore < theirScore) {
			totalLosses++;
		} else {
			totalTies++;
			message = "tied";
		}

		return message;
	}

	@Override
	public String toString() {
		return teamName + " (Ranked " + ranking() + ")";
	}
}
