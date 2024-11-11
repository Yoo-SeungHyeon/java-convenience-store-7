package store;

import java.util.List;

public class OutputView {

    public void showItems(List<Item> items) {
        System.out.println("안녕하세요. W편의점입니다.\n현재 보유하고 있는 상품입니다.\n");

        for (Item item : items) {
            System.out.println("- "+item.getItem());
        }
        System.out.println(" ");
    }

    public void giveReceipt(List<Order> orders){
        System.out.println("==============W 편의점================");
        System.out.println("상품명\t\t\t수량\t\t금액");
        for (Order order : orders) {
            if(order.getItemName().length()>2){
                System.out.println(order.getItemName()+"\t\t\t"+order.getQuantity()+"\t\t"+order.getPrice());
                continue;
            }
            System.out.println(order.getItemName()+"\t\t\t\t"+order.getQuantity()+"\t\t"+order.getPrice());
        }
        System.out.println("=============증\t정===============");
        // for
        System.out.println("====================================");
        System.out.println("총구매액" + "\t\t\t" + 10);
        System.out.println("행사할인");
        System.out.println("멤버십할인");
        System.out.println("내실돈");
        System.out.println("  ");
    }
}
