import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Movie movie = new ScienceFiction("Star Wars");
//        movie.watchMovie();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("""
                    • Adventure
                    • Comedy
                    • Science Fiction
                    (enter q to quit)
                    Enter your movie type ?\s""");
            String type = in.nextLine();
            if ("Qq".contains(type)) break;
            System.out.print("Enter movie title: "); String title = in.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();

            System.out.println("_ ".repeat(10));
        }
    }
}
