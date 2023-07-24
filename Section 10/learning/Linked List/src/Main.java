import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    private static void divider() {
        System.out.println("\n" + "=".repeat(40) + "\n");
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");                    // this adds a data into the first index of LinkedList
        list.addLast("Hobart");                     // this adds a data into the last index of LinkedList

        // QUEUE method: THEY RETURN BOOLEAN VALUE
        list.offer("Melbourne");                    // same as .offerLast, adds to the first index
        list.offerFirst("Brisbane");                // same as .offer, i = 0, adds to the first index
        list.offerLast("Toowoomba");                // same as .offer, i = list.length - 1, adds to the last index

        // STACK method: PUSH RETURN BOOLEAN
        list.push("Alice Springs");                 // places data on the beginning index, shifts the rest to right
    }

    private static void removeElements(LinkedList<String> list) {
        list.remove(0);
        list.remove("Brisbane");

        System.out.println(list);

        String s1 = list.remove();                      // removes the first element and returns the element
        System.out.println(s1 + " was removed (.remove)");

        String s2 = list.removeFirst();                 // removes the first element and returns the element
        System.out.println(s2 + " was removed (.removeFirst)");

        String s3 = list.removeLast();                  // removes the last element and returns the element
        System.out.println(s3 + " was removed (.removeLast)");

        // Queue -> deQueueing poll methods
        String p1 = list.poll();                        // removes the first element and returns the element
        System.out.println(p1 + " was removed (.poll)");

        String p2 = list.pollFirst();                  // removes the first element and returns the element
        System.out.println(p2 + " was removed (.poll)");

        String p3 = list.pollLast();                   // removes the last element and returns the element
        System.out.println(p3 + " was removed (.poll)");

        System.out.println(list);

        // STACK
        // push(): places data on the beginning index, shifts the rest to right
        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();                         // removes the first element and returns the element
        System.out.println(p4 + " was removed (.poll)");
    }

    private static void gettingElements(LinkedList<String> list) {
        // retrieving values by index or the first or last index
        System.out.println("retrieved at i(4)   = " + list.get(4));
        System.out.println("retrieved at FIRST  = " + list.getFirst());
        System.out.println("retrieved at LAST   = " + list.getLast());

        // retrieving the index of the first key found in LinkedList
        System.out.println("Darwin is at i      = " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at i   = " + list.indexOf("Melbourne"));

        // QUEUE method: retrieval / on first in - first out
        // the first to out
        System.out.println("Element (.element)  = " + list.element());
        System.out.println(list);

        // STACK method: retrieval / on first in - first out
        System.out.println("Element (.peek)     = " + list.peek());
        System.out.println("Element (.peekFirst)= " + list.peekFirst());
        System.out.println("Element (.peekLast) = " + list.peekLast());
        System.out.println(list);
    }

    public static void printItinerary(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());

        for (int i = 1;  i < list.size(); i++) {
            System.out.println("--> From " + list.get(i - 1) + " to " + list.get(i));
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println(list);
    }


    public static void printItinerary2(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());

        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("From " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println(list);
    }

    public static void printItinerary3(LinkedList<String> list) {
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();

        ListIterator<String> iterator = list.listIterator(1);   // starts from the index 1
        // iterator.hasNext() returns true if there are still more elements to process
        while (iterator.hasNext()) {
            var town = iterator.next();
            System.out.println("From " + previousTown + " to " + town);
            previousTown = town;
        }

        System.out.println("Trip ends at " + list.getLast());
        System.out.println(list);
    }

    private static void testIterator(LinkedList<String> list) {
//        var iterator = list.iterator();
        var iterator = list.listIterator();

        /* Iterator moves forwards */
        while (iterator.hasNext()) {
//            System.out.println("[+] " + iterator.next());

            /* Removes Brisbane from the list */
            if (iterator.next().equals("Brisbane")) {
                iterator.remove();
                iterator.add("Lake Wivenhoe");
            }
        }

        /* Iterator moves backwards */
        while (iterator.hasPrevious()) {
            System.out.println("[-] " + iterator.previous());
        }
        System.out.println(list);

        /* Iterator cursor is placed on before index 3 */
        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.next());
    }

    public static void main(String[] args) {
//        LinkedList<String> placesToVisit = new LinkedList<>();
        // no need to provide type on the right side if the variable type is defined as var.
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        divider();

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

        gettingElements(placesToVisit);

        divider();
//        printItinerary3(placesToVisit);

        testIterator(placesToVisit);
    }
}
