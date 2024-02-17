package theatre;

public class BookingAgent {

	public static void main(String[] args) {

		int rows = 10;
		int totalSeats = 100;
		Theatre rodgersNYC = new Theatre("Rodgers", rows, totalSeats);

		rodgersNYC.printSeatMap();

		bookSeat(rodgersNYC, 'B', 6);
		bookSeat(rodgersNYC, 'B', 6);
		bookSeat(rodgersNYC, 'A', 1);
		bookSeat(rodgersNYC, 'A', 2);
		bookSeat(rodgersNYC, 'Z', 2);
	}

	private static void bookSeat(Theatre theatre, char row, int seatNumber) {
		boolean response = theatre.reserveSeat(row, seatNumber);
		if (response) {
			System.out.println("Seat " + row + seatNumber + " booked!");
		} else {
			System.out.println("Seat " + row + seatNumber + " is already booked!");
		}

		theatre.printSeatMap();
	}
}
