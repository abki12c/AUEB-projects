package gr.aueb.shop_manager.model;

import java.time.LocalDate;
import java.util.Set;

public class Preorder {

    private LocalDate preorderDate;
    private LocalDate deliveryDate;
    private PaymentType payment;
    private Set<ProductOrder> productOrders;

    public Preorder(LocalDate preorderDate, LocalDate deliveryDate, PaymentType payment) {
        this.preorderDate = preorderDate;
        this.deliveryDate = deliveryDate;
        this.payment = payment;
    }

    public LocalDate getPreorderDate() {
        return preorderDate;
    }

    public void setPreorderDate(LocalDate preorderDate) {
        this.preorderDate = preorderDate;
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
}
