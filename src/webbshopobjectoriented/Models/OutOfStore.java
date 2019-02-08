
package webbshopobjectoriented.Models;

import java.util.Date;

public class OutOfStore {
    private int id;
    private Shoes shoes;
    private Date dateOfRunningOutOfStore;

    public OutOfStore(int id, Shoes shoes, Date dateOfRunningOutOfStore) {
        this.id = id;
        this.shoes = shoes;
        this.dateOfRunningOutOfStore = dateOfRunningOutOfStore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Date getDateOfRunningOutOfStore() {
        return dateOfRunningOutOfStore;
    }

    public void setDateOfRunningOutOfStore(Date dateOfRunningOutOfStore) {
        this.dateOfRunningOutOfStore = dateOfRunningOutOfStore;
    }
}
