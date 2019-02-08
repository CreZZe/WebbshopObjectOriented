
package webbshopobjectoriented;

import java.util.HashMap;
import webbshopobjectoriented.Models.Customer;
import webbshopobjectoriented.Models.Shoes;

public class InputHandler {
    public boolean formatCustomerChecker(HashMap<Integer, Customer> customers, int custId) {
        return customers.get(custId) != null;
    }
    
    public boolean formatProductChecker(HashMap<Integer, Shoes> productList, int prodId) {
        return productList.get(prodId) != null;
    }
}
