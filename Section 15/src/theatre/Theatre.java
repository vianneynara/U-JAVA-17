package theatre;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

	class Seat implements Comparable<Seat> {
		/**
		 * The {@link #seatNumber} will be formatted as follows the example 'A005':
		 * <ul>
		 *     <li> 'A' is the row number </li>
		 *     <li> '005' is the seat number </li>
		 * </ul>
		 * */
		private String seatNumber;
		private boolean reserved;

		public Seat(char rowChar, int seatNumber) {
			this("%c%03d".formatted(rowChar, seatNumber));
		}

		public Seat(String seatNumber) {
			this(seatNumber.toUpperCase(), false);
		}

		public Seat(String seatNumber, boolean reserved) {
			this.seatNumber = seatNumber;
			this.reserved = reserved;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public boolean reserve() {
			if (!reserved) {
				reserved = true;
				return true;
			} else {
				return false;
			}
		}

		public void unReserve() {
			reserved = false;
		}

		@Override
		public int compareTo(Seat o) {
			return this.seatNumber.compareTo(o.seatNumber);
		}

		@Override
		public String toString() {
			return seatNumber;
		}
	}

	private String name;
	private int rows;
	private int seatsPerRow;
	private NavigableSet<Seat> seats;

	public Theatre(String name, int rows, int totalSeats) {
		this.name = name;
		if (rows < 1 || rows > 26) {
			throw new IllegalArgumentException("The number of rows must be between 1 and 26");
		}
		this.rows = rows; // 1 ~ 26 | A ~ Z
		this.seatsPerRow = totalSeats / rows;

		Comparator<Seat> sorter = Comparator.comparing(Seat::getSeatNumber);
		this.seats = new TreeSet<>(sorter);

		// create the seats
		for (int i = 0; i < totalSeats; i++) {
			// gets the alphabetical row number
			char seatRow = (char) ((int) 'A' + i / seatsPerRow);

			// gets the seat number
			int seatInRow = i % seatsPerRow + 1;
			seats.add(new Seat(seatRow, seatInRow));
		}
	}

	public int getSize() {
		return seats.size();
	}

	public void printSeatMap() {
		String separator = "-".repeat(90);
		System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n",
			separator, name);

		int idx = 0;
		for (Seat s : seats) {
			System.out.printf("%-8s%s",
				s.seatNumber + ((s.reserved) ? "●" : ""),
				(idx++ + 1) % seatsPerRow == 0 ? "\n" : "");
		}
		System.out.println(separator);
	}

	public boolean reserveSeat(char row, int seatNumber) {
		return reserveSeat("%c%03d".formatted(row, seatNumber));
	}

	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = new Seat(seatNumber);
		Seat queriedSeat = seats.floor(requestedSeat);
		if (queriedSeat != null && queriedSeat.seatNumber.equals(seatNumber)) {
			if (!queriedSeat.reserved) {
				queriedSeat.reserved = true;
				return true;
			} else {
				return false;
			}
		} else {
			System.out.println("Seat not found!");
			return false;
		}
	}
}
