
package webbshopobjectoriented;

import java.util.HashMap;
import webbshopobjectoriented.Models.Customer;
import webbshopobjectoriented.Models.Order;
import webbshopobjectoriented.Models.Shoes;
import webbshopobjectoriented.Repository.CustomerRepository;
import webbshopobjectoriented.Repository.OrderRepository;
import webbshopobjectoriented.Repository.ShoesRepository;
import webbshopobjectoriented.Repository.ShoppingcartRepository;

public class Controller {
    CustomerRepository cr = new CustomerRepository();
    ShoesRepository sr = new ShoesRepository();
    OrderRepository or = new OrderRepository();
    ShoppingcartRepository scr = new ShoppingcartRepository();
    
    public HashMap<Integer, Customer> printAndGetCustomers() {
        System.out.println("Printing customers..");
        
        HashMap<Integer, Customer> customerList = cr.getCustomers();
        
        customerList.forEach((k, v) -> System.out.println(v.getName() + " " + v.getCity()));
        
        return customerList;
    }
    
    public HashMap<Integer, Shoes> printAndGetProducts() {
        System.out.println("Printing products..");
        
        HashMap<Integer, Shoes> productList = sr.getProducts();
        
        productList.forEach((k, v) -> System.out.println("[" + v.getQuantity() + "] " + v.getName() + " " + v.getPrice() + " " + v.getSize() + " " + v.getColor() + " " + v.getLabel().getName() + " " + v.getCategory().getName()));

        return productList;
    }
    
    public HashMap<Integer, Order> printAndGetOrders(String cust) {
        System.out.println("Printing orders..");
        
        HashMap<Integer, Order> orders = or.getOrders(cust);        
        
        System.out.println("[0] Ny order");
        orders.forEach((k, v) -> {
            System.out.println("[" + k + "] " + v.getCustomer().getName() + " " + v.getOrderDate() + " " + v.getLastUpdatedDate());
        });

        return orders;
    }
    
    public String AddProductToCart(HashMap<Integer, Order> orders, String customer, String product, String order) {
        return scr.AddProductToCart(orders, customer, product, order);        
    }
    
    public int getCustomerId(String input) {
        return cr.getCustomerId(input);
    }
    
    public int getProductId(String input) {
        return sr.getProductId(input);
    }
}
