package org.aktansanhal.model.abstracts;



public abstract class Transaction {

    private Person customer;
    private double amount;

    public Transaction(Person customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

