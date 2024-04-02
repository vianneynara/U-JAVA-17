package adventuregame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		AdventureGame game = new AdventureGame();
		game.play("road");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String direction = scanner.nextLine().trim().toUpperCase().charAt(0) + "";
			if (direction.equals("Q")) {
				System.out.println("Thanks for playing!");
				break;
			} else if (game.locationAvailable(direction)) {
				game.move(direction);
			} else {
				System.out.print("Invalid direction. Please enter a valid direction: ");
			}
		}
	}
}
