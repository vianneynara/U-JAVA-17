package carddeck;

import java.util.HashSet;
import java.util.Set;

public class HashCardTest {

	public static void main(String[] args) {
		PlayingCard kingOfHearts = new PlayingCard("King", "Hearts");
		PlayingCard aceOfHearts = new PlayingCard("Ace", "Hearts");
		PlayingCard kingOfClubs = new PlayingCard("King", "Clubs");

		// puts in hashset
		Set<PlayingCard> deck = new HashSet<>();

		deck.add(kingOfHearts);
		deck.add(aceOfHearts);
		deck.add(kingOfClubs);

		System.out.println(deck);
		for (PlayingCard card : deck) {
			System.out.println(card + ": " + card.hashCode());
		}

	}
}
