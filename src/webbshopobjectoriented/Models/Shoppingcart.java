
package webbshopobjectoriented.Models;

public class Shoppingcart {
    private int id;
    private Order order;
    private Shoes shoes;
    private int quantity;

    public Shoppingcart(int id, Order order, Shoes shoes, int quantity) {
        this.id = id;
        this.order = order;
        this.shoes = shoes;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
