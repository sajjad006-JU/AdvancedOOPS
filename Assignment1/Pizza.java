// 6. Create a program for ordering Pizza. The user should mention the size of the Pizza and the 
// toppings he/she wants. A user may ask for any toppings. Implement this using (i) variable arguments 
// concept and (ii) command line arguments.
// Sajjad Ahmed Shaaz, 002410501093

public class Pizza {
    char size; // S, M, L
    String[] toppings;

    Pizza(char size, String... toppings) {
        this.size=size;
        this.toppings=toppings;
    }

    void displayOrder() {
        System.out.println("Pizza Size: "+size);
        System.out.print("Toppings: ");
        for (int i=0; i<toppings.length; i++) {
            System.out.print(toppings[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide pizza size and toppings as command line arguments.");
            return;
        }

        char size = args[0].charAt(0);
        String[] toppings = new String[args.length - 1];
        // System.arraycopy(args, 1, toppings, 0, args.length - 1);

        for (int i = 1; i < args.length; i++) {
            toppings[i - 1] = args[i];
        }

        Pizza pizzaOrder = new Pizza(size, toppings);
        pizzaOrder.displayOrder();
    }
}
