package org.aktansanhal.model.concretes;

import org.aktansanhal.model.abstracts.Person;
import org.aktansanhal.model.abstracts.Transaction;

public class Order extends Transaction {

    public Order(Person customer, double amount) {
        super(customer, amount);
    }
}