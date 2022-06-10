package gr.aueb.shop_manager.model;

import java.time.LocalDate;
import java.util.Set;

public class Purchase {


    private LocalDate purchaseDate;
    private LocalDate deliveryDate;
    private PaymentType payment;
    private Customer customer;
    private Set<PurchasedProduct> purchasedProducts;

    public Purchase(LocalDate purchaseDate, LocalDate deliveryDate, PaymentType payment) {
        this.purchaseDate = purchaseDate;
        this.deliveryDate = deliveryDate;
        this.payment = payment;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PaymentType getPayment() {
        return payment;
    }

    public void setPayment(PaymentType payment) {
        this.payment = payment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
