package cs210Project;
import java.util.*;
public class GroceryStoreApplication {
	//Cart class to create objects
public static class Cart{
	public int CartNO;
	public Stack<String> itemName = new Stack();
	public Stack<Double> itemPrice = new Stack();
	public Cart() {
		CartNO = 0;
	}
}//end Cart class
static Scanner input = new Scanner(System.in);
public static void main (String [] args) {
	Queue<Cart> customers = new Queue<>();//queue of type Cart obj
	double GrandTotal = 0;
	Queue<Double> donations = new Queue<>();
	double DonationsTotal = 0;
	
	int choice;
	do {
		DisplayFeatures();
		choice = input.nextInt();
		System.out.println("---------------------");
			switch (choice) {
			case 1:
				System.out.print("Enter Number of Items in Customer's Cart: ");
				int itemsNum = input.nextInt();
				Cart cart = new Cart();//create new obj
				cart.CartNO++;
				for(int k = 1; k <= itemsNum; k++) {
					System.out.println("Enter Item [ " + k + " ]'s Info: ");
					System.out.print("Item's Name: ");
					String itemName = input.next();
					System.out.print("Item's Price: ");
					double itemPrice = input.nextDouble();
					cart.itemName.push(itemName);
					cart.itemPrice.push(itemPrice);
				}
				customers.enqueue(cart);//enqueue obj
				System.out.println("---------------------");
				System.out.println("Your Bill is: ");
				System.out.println("---------------------");
				double total = 0;
				System.out.println("Kindly Pay For The Following Items: ");
				System.out.println("");
				System.out.println("---------------------");
				while(! cart.itemName.isEmpty()  &&  ! cart.itemPrice.isEmpty()) {//traversing
					total = total + cart.itemPrice.peek();
					System.out.println(cart.itemName.pop() + " ->->->->->->->->->->->-> " + cart.itemPrice.pop());
					System.out.println("");
				}
				System.out.println("The Total is: " + total + "SR");
				System.out.println("Thank You For Shopping With Us ! ");
				GrandTotal = GrandTotal + total;
				System.out.println("");
				System.out.println("Next Customer Please. ");
				break;
			case 2:
				System.out.println("Total Number of Earnings is: " + GrandTotal + "SR");
				break;
			case 3:
				System.out.println(customers.size() + " Customers Have Visited Muheet Altowfeer. ");
				break;
			case 4:
				System.out.print("Enter The Amount of Money You Would Like To Donate: ");
				double don = input.nextDouble();
				System.out.println("Thank You For Donating " + don + "SR");
				donations.enqueue(don);
				break;
			case 5:
				System.out.println(donations.size() + " Donations Have Been Made!");
				break;
			case 6:
				while(!donations.isEmpty()) {
					DonationsTotal = DonationsTotal + donations.deQueue();	
				}
				System.out.println("The Total of Donations Money is: " + DonationsTotal + "SR");	
				break;
			case 7:
				System.out.println("You Have Exited the System.");
				System.exit(0);
				break;
				default:
					System.out.printf("Invalid Choice! /n Try Again.");
			}
		}while(choice != 7);//end DoWhile Loop O(n)
	}//end MainMethod
public static void DisplayFeatures() {
	System.out.println("---------------------");
	System.out.println("Wlecome To Muheet Altowfeer System!");
	System.out.println("1.) Check Out.");
	System.out.println("2.) Find Out Total Number of Earnings.");
	System.out.println("3.) Find Out Number of Customers Who Visited.");
	System.out.println("4.) Donate to Charities.");
	System.out.println("5.) Find Out Number of Donations Made.");
	System.out.println("6.) Find Out Total Amount of Money that Was Donated.");
	System.out.println("7.) Exit System.");
	System.out.print("Enter Your Request: ");
	return;
	}//endDisplayFeaturesMethod
}//endGroceryStoreApplication