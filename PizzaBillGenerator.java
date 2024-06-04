
import java.util.Scanner;

class Pizza {

    public boolean isVeg;
    public boolean extraCheese;
    public boolean extraToppings;
    public boolean takeAway;

    public Pizza(boolean isVeg) {
        this.isVeg = isVeg;
        this.extraCheese = false;
        this.extraToppings = false;
        this.takeAway = false;
    }

    public void addExtraCheese() {
        this.extraCheese = true;
    }

    public void addExtraToppings() {
        this.extraToppings = true;
    }

    public void selectTakeaway() {
        this.takeAway = true;
    }

    public double costOfItems() {
        double cost = isVeg ? 300 : 400;
        if (extraCheese) {
            cost += 100;
        }
        if (extraToppings) {
            cost += 100;
        }
        if (takeAway) {
            cost += 20;
        }
        return cost;
    }

}




class DeluxePizza extends Pizza {

    public DeluxePizza(boolean isVeg) {
        super(isVeg);
        this.extraCheese = true; 
        this.extraToppings = true; 
    }
    
}




public class PizzaBillGenerator {
    public static void main(String a[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("MyPizza");
        System.out.println("----------------");
        System.out.println("Select which pizza would you like to order:");
        System.out.println("1. Normal Veg");
        System.out.println("2. Normal Non-Veg");
        System.out.println("3. Deluxe Veg");
        System.out.println("4. Deluxe Non-Veg");
        int pizzaType = scanner.nextInt();

        Pizza pizza;
        switch (pizzaType) {
            case 1:
                pizza = new Pizza(true);
                break;
            case 2:
                pizza = new Pizza(false);
                break;
            case 3:
                pizza = new DeluxePizza(true);
                break;
            case 4:
                pizza = new DeluxePizza(false);
                break;
            default:
                System.out.println("Selected default : Normal Veg.");
                pizza = new Pizza(true);
                break;
        }

        System.out.println("Would you like to add extra cheese? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.addExtraCheese();
        }

        System.out.println("Would you like to add extra toppings? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.addExtraToppings();
        }

        System.out.println("Would you like to  take away? (yes/no)");
        if (scanner.next().equalsIgnoreCase("yes")) {
            pizza.selectTakeaway();
        }
        
        System.out.println("\n");
        System.out.println("---------------------------------------------------------");
        System.out.println("Your Total bill is: " + pizza.costOfItems() + " rupees.");
        System.out.println("---------------------------------------------------------");
        System.out.println("\n");
        System.out.println("Enjoy your PIZZA.....Thank you for visiting");
        

        scanner.close();
    }
}

