package store;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import  camp.nextstep.edu.missionutils.DateTimes;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 창고를 구현하고 기본값 입력
        Inventory inventory = new Inventory();
        inventory.addPromotion(new Promotion("탄산2+1",2,1,"2024-01-01","2024-12-31"));
        inventory.addPromotion(new Promotion("MD추천상품",1,1,"2024-01-01","2024-12-31"));
        inventory.addPromotion(new Promotion("반짝할인",1,1,"2024-11-01","2024-11-30"));

        inventory.addItem(new Item("콜라",1000,10,null));
        inventory.addItem(new Item("콜라",1000,10,"탄산2+1"));
        inventory.addItem(new Item("콜라",1000,10,null));
        inventory.addItem(new Item("사이다",1000,8,"탄산2+1"));
        inventory.addItem(new Item( "사이다",1000,7,null));
        inventory.addItem(new Item("오렌지주스",1800,9,"MD추천상품"));
        inventory.addItem(new Item("탄산수",1200,5,"탄산2+1"));
        inventory.addItem(new Item("물",500,10,null));
        inventory.addItem(new Item("비타민워터",1500,6,null));
        inventory.addItem(new Item("감자칩",1500,5,"반짝할인"));
        inventory.addItem(new Item("감자칩",1500,5,null));
        inventory.addItem(new Item("초코바",1200,5,"MD추천상품"));
        inventory.addItem(new Item("초코바",1200,5,null));
        inventory.addItem(new Item("에너지바",2000,5,null));
        inventory.addItem(new Item("정식도시락",6400,8,null));
        inventory.addItem(new Item("컵라면",1700,1,"MD추천상품"));
        inventory.addItem(new Item("컵라면",1700,10,null));
        while(true){
            List<Order> orders = new ArrayList<>();

            OutputView outputView = new OutputView();
            outputView.showItems(inventory.getItems());

            InputView inputView = new InputView();
            inputView.getOrder(orders);
            // 창고 재고 관리
            try{
                if(!inventory.checkItemName(orders)){
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e){
                System.out.println("[ERROR] 없는 상품입니다 다시 입력해 주세요.");
                inputView.getOrder(orders);
            }

            inventory.promotionCheck(orders);

            for(Order order : orders){
                order.changePrice(inventory.getItemPrice(order));
            }
            // 프로모션 재고 관리
            
            inputView.getMembership();

            outputView.giveReceipt(orders);

            if(!inputView.addAmount()){
                System.out.println(" ");
                break;
            }
        }


    }
}
