package org.aktansanhal.service;

import org.aktansanhal.model.abstracts.Person;
import org.aktansanhal.model.abstracts.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SystemManagement {
    private List<Person> customers;
    private List<Transaction> orders;

    public SystemManagement() {
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addCustomer(Person customer) {
        customers.add(customer);
    }

    public void addOrder(Transaction order) {
        orders.add(order);
    }

    public List<Person> getAllCustomers() {
        return customers;
    }

    public List<Person> getCustomersWithNameContainingC() {
        return customers.stream()
                .filter(customer -> customer.getName().contains("C"))
                .collect(Collectors.toList());
    }

    public double getTotalAmountOfOrdersInJune() {
        return orders.stream()
                .filter(order -> order.getCustomer().getRegistrationDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public List<Transaction> getAllOrders() {
        return orders;
    }

    public List<Transaction> getOrdersWithAmountAbove1500() {
        return orders.stream()
                .filter(order -> order.getAmount() > 1500)
                .collect(Collectors.toList());
    }

    public double getAverageAmountOfOrdersAbove1500() {
        return orders.stream()
                .filter(order -> order.getAmount() > 1500)
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0);
    }

    public List<String> getCustomersWithOrdersBelow500() {
        return orders.stream()
                .filter(order -> order.getAmount() < 500)
                .map(order -> order.getCustomer().getName())
                .collect(Collectors.toList());
    }

    public List<String> getCustomersInSectorWithAverageBelow750() {
        return customers.stream()
                .filter(customer -> customer.getRegistrationDate().getMonth() == LocalDate.of(2023, 6, 1).getMonth())
                .filter(customer -> getAverageOrderAmountForCustomer(customer) < 750)
                .map(Person::getSector)
                .distinct()
                .collect(Collectors.toList());
    }

    private double getAverageOrderAmountForCustomer(Person customer) {
        return orders.stream()
                .filter(order -> order.getCustomer().equals(customer))
                .mapToDouble(Transaction::getAmount)
                .average()
                .orElse(0);
    }

}
