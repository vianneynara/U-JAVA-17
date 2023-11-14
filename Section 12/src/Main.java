interface Player {}

record BaseballPlayer(String name, String position) implements Player {};
record FootballPlayer(String name, String position) implements Player {};

public class Main {

	public static void main(String[] args) {

		BaseballTeam phillies1 = new BaseballTeam("Phillies");
		BaseballTeam astros1 = new BaseballTeam("Astros");
		scoreResult(phillies1, 3, astros1, 4);

		SportsTeam phillies2 = new SportsTeam("Phillies");
		SportsTeam astros2 = new SportsTeam("Astros");
		scoreResult(phillies2, 3, astros2, 4);

		Team<BaseballPlayer> phillies = new Team<>("Phillies");
		Team<BaseballPlayer> astros = new Team<>("Astros");
		scoreResult(phillies, 3, astros, 4);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		phillies.listTeamMembers();

		Team<FootballPlayer> afc = new Team<>("AFC");
		var tex = new FootballPlayer("Tex", "Center half forward");
		afc.addTeamMember(tex);
//		var guthrie = new BaseballPlayer("D Guthrie", "Center half forward");
//		afc.addTeamMember(guthrie);
		var rori = new FootballPlayer("F Rori", "Midfield");
		afc.addTeamMember(rori);
		afc.listTeamMembers();
	}

	public static void scoreResult(BaseballTeam team1, int t1_score,
								   BaseballTeam team2, int t2_score) {
		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s \n", team1, message, team2);
	}

	public static void scoreResult(SportsTeam team1, int t1_score,
								   SportsTeam team2, int t2_score) {
		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s \n", team1, message, team2);
	}

	public static void scoreResult(Team team1, int t1_score,
								   Team team2, int t2_score) {
		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s \n", team1, message, team2);
	}
}
