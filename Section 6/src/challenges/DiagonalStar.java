package challenges;

public class DiagonalStar {
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
            return;
        }
        for (int col = 1; col <= number; col++) {
            for (int row = 1; row <= number; row++) {
                if ((col == 1) || (col == number) || (row == 1) || (row == number) || (col == row) || (col == (number - row + 1))) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSquareStar(8);
    }
}
