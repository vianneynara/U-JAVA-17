public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(50, true);
        System.out.println("init page: " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(5);
        System.out.printf("To be printed: %d. total pages printed: %d %n",
                pagesPrinted, printer.getPagesPrinted());


        pagesPrinted = printer.printPages(11);
        System.out.printf("To be printed: %d. total pages printed: %d %n",
                pagesPrinted, printer.getPagesPrinted());


    }
}
