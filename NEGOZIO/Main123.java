package NEGOZIO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main123 {


    public static void main(String[] args) {
        Product pt1 = new Product(123456789L, "Uno studio in rosso", "Book", 151.32);
        Product pt2 = new Product(987654321L, "Il segno dei quattro", "Book", 163.72);
        Product pt3 = new Product(234567890L, "Le avventure di Sherlock Holmes", "Book", 131.46);
        Product pt4 = new Product(876543210L, "Pannolini", "Baby", 47.99);
        Product pt5 = new Product(345678901L, "Biberon", "Baby", 12.29);
        Product pt6 = new Product(765432109L, "Passeggino", "Baby", 304.79);
        Product pt7 = new Product(456789012L, "Lego", "Boy", 438.02);
        Product pt8 = new Product(654321098L, "Destiny", "Boy", 25.69);
        Product pt9 = new Product(567890123L, "Pokemon", "Boy", 6.0);
        Customer cos1 = new Customer(1L, "Massimiliano", 1);


        List<Product> pippo1 = new ArrayList<>();
        pippo1.add(pt2);
        pippo1.add(pt4);
        pippo1.add(pt5);
        pippo1.add(pt6);
        pippo1.add(pt8);

        List<Product> pippo2 = new ArrayList<>();
        pippo2.add(pt3);
        pippo2.add(pt7);
        pippo2.add(pt9);
        pippo2.add(pt1);

        Order ord1 = new Order(1L, "In progress", LocalDate.now(), LocalDate.now().plusDays(3), pippo1, cos1);

        Order ord2 = new Order(2L, "In progress", LocalDate.now(), LocalDate.now().plusDays(5), pippo2, cos1);

        //********************ESERCIZIO NUMERO 1********************\\
        List<Product> pippoStream = pippo1.stream().filter(x -> x.category.equals("Book")).filter(x -> x.price > 100).toList();

        for (Product pt : pippoStream) {
            System.out.println("Prodotto Book superiore a 100€: " + pt.toString());
        }

        //********************ESERCIZIO NUMERO 2********************\\
        List<Order> pippoOrder = new ArrayList<>();
        pippoOrder.add(ord1);
        pippoOrder.add(ord2);
        List<Order> pippoOrderFilt = pippoOrder.stream().filter(y -> y.products.stream().anyMatch(product -> product.category.equals("Baby"))).toList();
        for (Order ord : pippoOrderFilt) {
            System.out.println("baby " + ord);
        }
        //********************ESERCIZIO NUMERO 3********************\\
        List<Product> pippoDiscountBoy = pippo1.stream().filter(z -> z.category.equals("Boy")).map(z -> {
            double discount = (z.getPrice() * 0.1);
            z.setPrice(z.getPrice() - discount);
            return z;
        }).toList();
        System.out.println("Prodotti scontati: " + pippoDiscountBoy);
    }
}
