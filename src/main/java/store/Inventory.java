package store;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<Item>();
    private List<Promotion> promotions = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public List<Item> getItems() {
        return items;
    }

    private List<String> itemsList(){
        List<String> itemList = new ArrayList<>();
        for(Item item : items){
            itemList.add(item.getItemName());
        }
        return itemList;
    }

    public boolean checkItemName(List<Order> orders) {
        List<String> itemsList = itemsList();
        for(Order order : orders){
            if(!itemsList.contains(order.getItemName())){
                return false;
            }
        }
        return true;
    }

    public int getItemPrice(Order order){
        for(Item item : items){
            if(item.getItemName().equals(order.getItemName())){
                return item.getPrice();
            }
        }
        return 0;
    }

    public void promotionCheck(List<Order> order){
    }
}
