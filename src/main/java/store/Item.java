package store;

public class Item {
    private String name;
    private int price;
    private int quantity;
    private String promotion;

    public Item(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getItem(){
        if (promotion == null){
            return name + " " + price + "원 " + quantity;
        }
        return name + " " + price + "원 " + quantity + "개 " + promotion;
    }

    public String getItemName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}
