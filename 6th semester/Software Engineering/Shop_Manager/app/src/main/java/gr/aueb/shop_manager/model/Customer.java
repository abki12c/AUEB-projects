package gr.aueb.shop_manager.model;

import java.time.LocalDate;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;
    private Address address;

    public Customer(String firstName, String lastName, String email,String street, String number, String city, String zipCode) {
        address = new Address(street, number, city, zipCode);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void buyProduct(String name, Integer amount , ProductType type, PaymentType payment, LocalDate buyDate,LocalDate deliveryDate){
        Product product = new Product(name,type);
        if(product.getStock() >= amount){
            createPurchase(buyDate,deliveryDate,payment, amount);
        }else{
            Integer am = amount - product.getStock();
            createPurchase(buyDate,deliveryDate,payment, product.getStock());
            createPreorder(buyDate,deliveryDate,payment, am);
        }
    }

    public void createPreorder(LocalDate preorderDate,LocalDate deliveryDate,PaymentType payment,Integer amount ){
    Preorder preorder = new Preorder(preorderDate,deliveryDate,payment);
    ProductOrder productOrder = new ProductOrder(amount, false);
    }

    public void createPurchase(LocalDate purchaseDate,LocalDate deliveryDate, PaymentType payment, Integer amount){
        Purchase purchase = new Purchase(purchaseDate, deliveryDate, payment);
        PurchasedProduct purchasedProduct = new PurchasedProduct(amount);
    }

    public void createOrder(LocalDate orderDate,LocalDate deliveryDate, PaymentType payment, Product product,Integer amount){
        Order order = new Order(orderDate,deliveryDate,payment);
        OrderLine orderLine = new OrderLine(amount,false,order,product);
        product.setReservedStock(amount);
    }
}
