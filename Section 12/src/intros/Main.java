package intros;

interface Player {

	String name();

}

record BaseballPlayer(String name, String position) implements Player {}
record FootballPlayer(String name, String position) implements Player {}
record VolleyballPlayer(String name, String position) implements Player {}

public class Main {

	public static void main(String[] args) {

		var philly = new Affiliation("city", "Philadelphia, PA", "US");

		BaseballTeam phillies1 = new BaseballTeam("Phillies");
		BaseballTeam astros1 = new BaseballTeam("Astros");
		scoreResult(phillies1, 3, astros1, 4);

		SportsTeam phillies2 = new SportsTeam("Phillies");
		SportsTeam astros2 = new SportsTeam("Astros");
		scoreResult(phillies2, 3, astros2, 4);

		Team<BaseballPlayer, Affiliation> phillies = new Team<>("Phillies", philly);
		Team<BaseballPlayer, Affiliation> astros = new Team<>("Astros");
		scoreResult(phillies, 3, astros, 4);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		phillies.listTeamMembers();

		Team<FootballPlayer, Affiliation> afc = new Team<>("AFC");
		var tex = new FootballPlayer("Tex", "Center half forward");
		afc.addTeamMember(tex);
//		var guthrie = new intros.BaseballPlayer("D Guthrie", "Center half forward");
//		afc.addTeamMember(guthrie);
		var rori = new FootballPlayer("F Rori", "Midfield");
		afc.addTeamMember(rori);
		afc.listTeamMembers();

		Team<VolleyballPlayer, String> adelaide = new Team<>("Adelaide Storm", "City of Adelaide, South Australia, in AU");
		adelaide.addTeamMember((new VolleyballPlayer("N Roberts", "Setter")));
		adelaide.listTeamMembers();

		var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat");
		canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
		canberra.listTeamMembers();
		scoreResult(canberra, 0, adelaide, 1);

//		intros.Team<Integer> melbourneVM = new intros.Team<>("Melbourne Vipers");
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
