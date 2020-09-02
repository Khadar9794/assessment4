package com.dxctraining.customermgt.customer.entities;


import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    public Customer() {

    }

    public Customer(String name) {
         this.name= name;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer that = (Customer) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
