package org.aktansanhal;

import org.aktansanhal.model.concretes.Customer;
import org.aktansanhal.model.concretes.Order;
import org.aktansanhal.model.abstracts.Person;
import org.aktansanhal.model.abstracts.Transaction;
import org.aktansanhal.service.SystemManagement;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SystemManagement management = new SystemManagement();


        // Müşteri oluşturma
        Person customer1 = new Customer("Müşteri A", LocalDate.of(2023, 6, 1), "Sektor1");
        Person customer2 = new Customer("Müşteri B", LocalDate.of(2023, 6, 1), "Sektor2");
        Person customer3 = new Customer("Müşteri C", LocalDate.of(2023, 5, 1), "Sektor3");
        Person customer4 = new Customer("Müşteri D", LocalDate.of(2023, 6, 1), "Sektor4");
        Person customer5 = new Customer("Müşteri E", LocalDate.of(2023, 6, 1), "Sektor5");


        // Sipariş oluşturma
        Transaction order1 = new Order(customer1, 1000);
        Transaction order2 = new Order(customer2, 2000);
        Transaction order3 = new Order(customer3, 500);
        Transaction order4 = new Order(customer4, 700);
        Transaction order5 = new Order(customer5, 300);

        // Müşteri ve siparişleri yönetim sistemine ekleme
        management.addCustomer(customer1);
        management.addCustomer(customer2);
        management.addCustomer(customer3);
        management.addCustomer(customer4);
        management.addCustomer(customer5);

        management.addOrder(order1);
        management.addOrder(order2);
        management.addOrder(order3);
        management.addOrder(order4);
        management.addOrder(order5);


        System.out.println("---------------------------------------------------------------------------------");
        // Tüm müşterileri listeleme
        List<Person> allCustomers = management.getAllCustomers();
        System.out.println("Tüm müşteriler:");
        for (Person customer : allCustomers) {
            System.out.println(customer.getName());
        }
        System.out.println("---------------------------------------------------------------------------------");
        // 'C' harfi içeren müşterileri listeleme
        List<Person> customersWithNameContainingC = management.getCustomersWithNameContainingC();
        System.out.println("\n'C' harfi içeren müşteriler:");
        for (Person customer : customersWithNameContainingC) {
            System.out.println(customer.getName());
        }
        System.out.println("---------------------------------------------------------------------------------");
        // Haziran ayında kayıt olan müşterilerin faturalarının toplam tutarı
        double totalAmountInJune = management.getTotalAmountOfOrdersInJune();
        System.out.println("\nHaziran ayında kayıt olan müşterilerin faturalarının toplam tutarı: \n" + totalAmountInJune);

        System.out.println("---------------------------------------------------------------------------------");

        // Sistemdeki tüm faturaları listeleme
        List<Transaction> allOrders = management.getAllOrders();
        System.out.println("\nTüm faturalar:");
        for (Transaction order : allOrders) {
            System.out.println("Müşteri: " + order.getCustomer().getName() + ", Tutar: " + order.getAmount());
        }

        System.out.println("---------------------------------------------------------------------------------");

        // 1500 TL üzerindeki faturaları listeleme
        List<Transaction> ordersWithAmountAbove1500 = management.getOrdersWithAmountAbove1500();
        System.out.println("\n1500 TL üzerindeki faturalar:");
        for (Transaction order : ordersWithAmountAbove1500) {
            System.out.println("Müşteri: " +order.getCustomer().getName() + ", Tutar: " + order.getAmount());
        }

        System.out.println("---------------------------------------------------------------------------------");
        // 1500 TL üzerindeki faturaların ortalaması
        double averageAmountAbove1500 = management.getAverageAmountOfOrdersAbove1500();
        System.out.println("\n1500 TL üzerindeki faturaların ortalaması: \n" + averageAmountAbove1500);


        System.out.println("---------------------------------------------------------------------------------");
        // 500 TL altındaki faturalara sahip müşterilerin isimleri
        List<String> customersWithOrdersBelow500 = management.getCustomersWithOrdersBelow500();
        System.out.println("\n500 TL altındaki faturalara sahip müşteriler:");
        for (String customerName : customersWithOrdersBelow500) {
            System.out.println(customerName);
        }

        System.out.println("---------------------------------------------------------------------------------");
        // Haziran ayında faturalarının ortalaması 750 altı olan firmaların sektörleri
        List<String> sectorsWithAverageBelow750 = management.getCustomersInSectorWithAverageBelow750();
        System.out.println("\nHaziran ayında faturalarının ortalaması 750 altı olan firmaların sektörleri:");
        for (String sector : sectorsWithAverageBelow750) {
            System.out.println(sector);
        }

        System.out.println("---------------------------------------------------------------------------------");


    }
}