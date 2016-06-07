package com.personal.jooq.skeleton.pojos;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by minhpham on 6/5/16.
 */
public class PAuthor implements Serializable{
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer yearOfBirth;
    private String address;

    public PAuthor() {
    }

    public PAuthor(PAuthor value) {
        this.id = value.id;
        this.firstName = value.firstName;
        this.lastName = value.lastName;
        this.dateOfBirth = value.dateOfBirth;
        this.yearOfBirth = value.yearOfBirth;
        this.address = value.address;
    }

    public PAuthor(
            Integer id,
            String firstName,
            String lastName,
            Date dateOfBirth,
            Integer yearOfBirth,
            String address
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorDao (");

        sb.append(id);
        sb.append(", ").append(firstName);
        sb.append(", ").append(lastName);
        sb.append(", ").append(dateOfBirth);
        sb.append(", ").append(yearOfBirth);
        sb.append(", ").append(address);

        sb.append(")");
        return sb.toString();
    }
}
