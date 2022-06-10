package gr.aueb.shop_manager.model;

public class OrderLine {

    private Integer amount;
    private boolean delivered;
    private Product product;
    private Order order;

    public OrderLine(Integer amount, boolean delivered, Order order, Product product) {
        this.amount = amount;
        this.delivered = delivered;
        this.product = product;
        this.order = order;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
