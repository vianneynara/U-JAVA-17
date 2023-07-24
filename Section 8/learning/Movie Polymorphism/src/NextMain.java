public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        Movie comedyMovie = (Comedy) comedy;
        comedyMovie.watchMovie();

        // diffs
        ((Comedy) comedy).watchComedy();
        System.out.println(comedy.getClass().getSimpleName());

        // var type solves assigned object type at runtime
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie();

        // var type solves assigned object type at runtime
        var tlou = new Adventure("tlou");
        tlou.watchMovie();

        // casting using instanceof
        Object unknownObject = Movie.getMovie("S", "wasted");
        System.out.println(unknownObject.getClass().getName());
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            System.out.println("TRUEE!");
            System.out.println("Casting new c Comedy object...");

            Comedy c = (Comedy) unknownObject;
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction scifi) {
            scifi.watchScienceFiction();
        }
    }
}
