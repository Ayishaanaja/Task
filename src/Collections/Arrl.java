package Collections;

import java.util.ArrayList;

public class Arrl {
    public static void main(String[] args) {
        ArrayList cart = new ArrayList();

        cart.add("Laptop");
        cart.add("Headphones");
        cart.add("Mouse");
        cart.add("USB Cable");
        cart.add("Laptop"); 

        cart.remove(2);

        cart.set(2, "Wireless Charger");

        System.out.println("Shopping Cart Items: " + cart);
    }
}