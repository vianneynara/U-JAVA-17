import java.util.ArrayList;
import java.util.List;

public class Team<T> {

	private String teamName;
	private List<T> teamMembers = new ArrayList<>();
	private int totalWins;
	private int totalLosses;
	private int totalTies;

	public Team(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(T player) {

		if (!teamMembers.contains(player)) {
			teamMembers.add(player);
		}
	}

	public void listTeamMembers() {
		System.out.println(teamName + " Roster:");
		System.out.println(teamMembers);
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
