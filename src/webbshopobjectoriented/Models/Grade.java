
package webbshopobjectoriented.Models;

import java.util.Date;

public class Grade {
    private int id;
    private String comment;
    private String gradeName;
    private int gradeRate;
    private Shoes shoes;
    private Customer customer;
    private Date dateOfGrading;
    private Date updatedGradingDate;

    public Grade(int id, String comment, String gradeName, int gradeRate, Shoes shoes, Customer customer, Date dateOfGrading, Date updatedGradingDate) {
        this.id = id;
        this.comment = comment;
        this.gradeName = gradeName;
        this.gradeRate = gradeRate;
        this.shoes = shoes;
        this.customer = customer;
        this.dateOfGrading = dateOfGrading;
        this.updatedGradingDate = updatedGradingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public int getGradeRate() {
        return gradeRate;
    }

    public void setGradeRate(int gradeRate) {
        this.gradeRate = gradeRate;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfGrading() {
        return dateOfGrading;
    }

    public void setDateOfGrading(Date dateOfGrading) {
        this.dateOfGrading = dateOfGrading;
    }

    public Date getUpdatedGradingDate() {
        return updatedGradingDate;
    }

    public void setUpdatedGradingDate(Date updatedGradingDate) {
        this.updatedGradingDate = updatedGradingDate;
    }
}
