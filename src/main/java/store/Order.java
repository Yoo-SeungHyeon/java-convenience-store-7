package store;

public class Order {
    private String itemName;
    private int quantity;
    private int price;

    public Order(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
