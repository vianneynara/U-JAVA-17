import java.util.ArrayList;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main
{
    public static void main(String... args) {
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apple", "PRODUCE", 6);
        groceryArray[2] = new GroceryItem("oranges", "PRODUCE", 5);

        //System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yoghurt"); // this will only work if the ArrayList is not specified

        ArrayList<GroceryItem> groceryList = new ArrayList<>(); // declare with type list
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("milk"));
        groceryList.add(new GroceryItem("apple", "PRODUCE", 4));
        groceryList.add(0, new GroceryItem("apple", "PRODUCE", 2));

        groceryList.remove(1); // remove milk

        System.out.println(groceryList);
    }
}
