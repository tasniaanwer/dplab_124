
import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Beverage beverage = null;


        System.out.println("Choose your beverage:");
        System.out.println("1. Espresso\n2. Latte\n3. Cappuccino");
        int beverageChoice = scanner.nextInt();

        switch (beverageChoice) {
            case 1:
                beverage = new Espresso();
                break;
            case 2:
                beverage = new Latte();
                break;
            case 3:
                beverage = new Cappuccino();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }


        System.out.println("Add condiments (Enter numbers separated by commas):");
        System.out.println("1. Milk\n2. Whipped Cream\n3. Sugar\n4. No more condiments");
        scanner.nextLine();
        String condimentInput = scanner.nextLine();

        // Step 8: Process all chosen condiments in one go
        String[] condiments = condimentInput.split(",");
        for (String condimentChoice : condiments) {
            switch (condimentChoice.trim()) {
                case "1":
                    beverage = new Milk(beverage);
                    break;
                case "2":
                    beverage = new WhippedCream(beverage);
                    break;
                case "3":
                    beverage = new Sugar(beverage);
                    break;
                case "4":
                    // No more condiments, so skip
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }


        System.out.println("Your order: " + beverage.getDescription());
        System.out.println("Total cost: $" + beverage.cost());

        scanner.close();
    }
}