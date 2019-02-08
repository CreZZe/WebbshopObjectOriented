
package webbshopobjectoriented;

import java.util.HashMap;
import java.util.Scanner;
import webbshopobjectoriented.Models.Customer;
import webbshopobjectoriented.Models.Order;
import webbshopobjectoriented.Models.Shoes;

public class WebbshopObjectOriented {

    public static void main(String[] args) {
        Controller ctr = new Controller();
        InputHandler handler = new InputHandler();
        
        Scanner scan = new Scanner(System.in);
        
        HashMap<Integer, Customer> customers = ctr.printAndGetCustomers();
        String customer = scan.nextLine();

        if (handler.formatCustomerChecker(customers, ctr.getCustomerId(customer))) {
            System.out.println("Du valde " + customer);
            HashMap<Integer, Shoes> productList = ctr.printAndGetProducts();
            String product = scan.nextLine();
            
            if (handler.formatProductChecker(productList, ctr.getProductId(product))) {
                System.out.println("Du valde " + product);
                HashMap<Integer, Order> orders = ctr.printAndGetOrders(customer);
                String order = scan.nextLine();
                
                System.out.println(ctr.AddProductToCart(orders, customer, product, order));                
            }
        }
        else
            System.out.println("Din kund finns inte med i vår databas.");
    }
}
