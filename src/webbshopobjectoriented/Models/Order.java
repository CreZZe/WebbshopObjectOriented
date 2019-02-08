
package webbshopobjectoriented.Models;

import java.util.Date;

public class Order {
    private int id;
    private Date orderDate;
    private Date lastUpdatedDate;
    private Customer customer;
    private boolean sent;

    public Order(int id, Date orderDate, Customer customer, boolean sent) {
        this.id = id;
        this.orderDate = orderDate;
        this.customer = customer;
        this.sent = sent;
    }
    
    public Order(int id, Date orderDate, Date lastUpdatedDate, Customer customer, boolean sent) {
        this.id = id;
        this.orderDate = orderDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.customer = customer;
        this.sent = sent;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public boolean getIfSent() {
        return sent;
    }

    public void setIfSent(boolean sent) {
        this.sent = sent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
