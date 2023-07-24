public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        pagesPrinted = 0;
        this.tonerLevel = ((tonerLevel >= 0) && (tonerLevel <= 100)) ? tonerLevel : -1;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
        int addedToner = tonerLevel + tonerAmount;
        if ((addedToner < 0) || (addedToner > 100) || (tonerAmount < 1)) {
            return -1;
        }
        tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pages) {
        int printingPages = (duplex) ? ((pages / 2) + (pages % 2)) : pages;
        if (duplex) System.out.println("Printer is printing in duplex mode");
        pagesPrinted += printingPages;
        return printingPages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
