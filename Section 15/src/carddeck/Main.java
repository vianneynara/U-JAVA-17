package carddeck;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Card[] cardArray = new Card[13];
		Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
		Arrays.fill(cardArray, aceOfHearts);
		Card.printDeck(Arrays.asList(cardArray), "Ace of Hearts", 4);

		List<Card> cards = new ArrayList<>(52);
		Collections.fill(cards, aceOfHearts);
		System.out.println(cards);
		System.out.println("cards.size() = " + cards.size());

		List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
		Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

		Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
		List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
		Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

		Collections.addAll(cards, cardArray);
		Collections.addAll(cards, cardArray);
		Card.printDeck(cards, "Card collection with Aces added", 2);
//		System.out.println("cards.size() = " + cards.size());

		Collections.copy(cards, kingsOfClubs);
		Card.printDeck(cards, "Card collection with Kings copied", 2);

		cards = List.copyOf(kingsOfClubs);
		Card.printDeck(cards, "List copy of Kings", 1);

		List<Card> deck = Card.getStandardDeck();
		Card.printDeck(deck);

		Collections.shuffle(deck);
		Card.printDeck(deck, "Shuffled Deck", 4);

		Collections.reverse(deck);
		Card.printDeck(deck, "Reversed Deck", 4);

		var sorter = Comparator.comparing(Card::rank)
			.thenComparing(Card::suit);
		Collections.sort(deck, sorter);
		Card.printDeck(deck, "Sorted Deck", 13);

		Collections.reverse(deck);
		Card.printDeck(deck, "Reversed Deck", 13);

		List<Card> kings = new ArrayList<>(deck.subList(4, 8));
		Card.printDeck(kings, "Kings in deck", 1);

		List<Card> tens = new ArrayList<>(deck.subList(16, 20));
		Card.printDeck(tens, "Tens in deck", 1);

		int subListIndex = Collections.indexOfSubList(deck, tens);
		System.out.println("subListIndex = " + subListIndex);
		System.out.println("Contains = " + deck.containsAll(tens));

		// comparing collections if found in another collection
		boolean disjoint1 = Collections.disjoint(kings, tens);
		System.out.println("disjoint1 = " + disjoint1);

		// comparing collections if found in another collection
		boolean disjoint2 = Collections.disjoint(deck, tens);
		System.out.println("disjoint2 = " + disjoint2);

		// binary search
		Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);

		deck.sort(sorter);
		int foundIdx = Collections.binarySearch(deck, tenOfHearts, sorter);
		System.out.println("foundIdx = " + foundIdx);

		// not sorted, use indexOf
		System.out.println("foundIdx = " + deck.indexOf(tenOfHearts));
		System.out.println("deck.get(foundIdx) = " + deck.get(foundIdx));

		Card tenOfClubs = Card.getNumericCard(Card.Suit.CLUB, 10);
		Collections.replaceAll(deck, tenOfClubs, tenOfHearts);
		Card.printDeck(deck.subList(32, 36), "Tens row", 1);

		Collections.replaceAll(deck, tenOfHearts, tenOfClubs);
		Card.printDeck(deck.subList(32, 36), "Tens row", 1);

		if (Collections.replaceAll(deck, tenOfHearts, tenOfClubs)) {
			System.out.println("Replaced");
		} else {
			System.out.println("Not replaced");
		}

		System.out.println("Ten of clubs cards = " + Collections.frequency(deck, tenOfClubs));
		System.out.println("Best card = " + Collections.max(deck, sorter));
		System.out.println("Worst card = " + Collections.min(deck, sorter));

		var sortBySuit = Comparator.comparing(Card::suit)
			.thenComparing(Card::rank);
		deck.sort(sortBySuit);
		Card.printDeck(deck, "Sorted by suit", 4);

		List<Card> copied = new ArrayList<>(deck.subList(0, 13));
		Collections.rotate(copied, 2);
		System.out.println("Unrotated: " + deck.subList(0, 13));
		System.out.println("Rotated 2: " + copied);

		copied = new ArrayList<>(deck.subList(0, 13));
		Collections.rotate(copied, -2);
		System.out.println("Unrotated: " + deck.subList(0, 13));
		System.out.println("Rotated -2: " + copied);

		copied = new ArrayList<>(deck.subList(0, 13));
		System.out.println("Before: " + copied);
		for (int i = 0; i < copied.size() / 2; i++) {
			Collections.swap(copied, i, copied.size() - 1 - i);
		}
		System.out.println("Manual reverse: " + copied);

		copied = new ArrayList<>(deck.subList(0, 13));
		Collections.reverse(copied);
		System.out.println("Collections.reverse: " + copied);
	}
}
