package dev.yohpx;

import com.abc.first.Item;
// import com.abc.first.*;

public class Main {
    public static void main(String[] args) {
        Item firstItem = new Item("Burger");
        com.abc.first.Item secondItem = new Item("BUNGER");
        System.out.println(firstItem);
        System.out.println(secondItem);
    }
}
