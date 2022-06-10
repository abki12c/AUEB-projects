package gr.aueb.shop_manager.model;

public class ProductOrder {

    private Integer amount;
    private boolean delivered;
    private Product product;
    private Preorder preorder;

    public ProductOrder(Integer amount, boolean delivered) {
        this.amount = amount;
        this.delivered = delivered;
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
}
