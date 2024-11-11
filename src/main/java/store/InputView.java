package store;

import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private boolean checkOrder(String[] input){
        for(int i = 0; i < input.length; i++){
            String regex = "\\\\[\\\\w+-\\\\d+\\\\]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input[i]);
            return !matcher.matches();
        }
        return true;
    }

    private boolean checkItem(String[] tmp){
        if(tmp.length != 2){
            return false;
        }
        if(tmp[1].isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(tmp[1]);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    //구매 함수들
    public void getOrder(List<Order> orders) {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-1],[감자칩-1])");
        String input = Console.readLine();
        String[] items = input.split(",");
        checkOrder(items);
        for(String item : items){
            item = item.replace("[","").replace("]","");
            String[] temp = item.split("-");
            checkItem(temp);
            try{
                orders.add(new Order(temp[0],Integer.parseInt(temp[1])));
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.\n");
                getOrder(orders);
            }

        }
    }

    // 프로모션 함수들
    public void checkPromotion(){
        //프로모션 적용이 적절히 되었는지 여부 확인
    }



    // 맴버십 할인 함수들
    // Input이 Y 또는 N 인지 확인
    private boolean checkInput(String input){
        if(input.equals("Y")||input.equals("N")){
            return true;
        }
        return false;
    }

    // 맴버십 할인을 받는지 여부 확인. input은 전부 대문자로 변환. 잘못된 입력이 발생하면 재귀적으로 다시 입력받음.
    public boolean getMembership(){
        System.out.println("맴버십 할인을 받으시겠습니까? (Y/N)");
        String input = Console.readLine().toUpperCase();

        try{
            if(!checkInput(input)){
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e){
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.\n");
            getMembership();
        }

        if (input.equals("Y")){
            return true;
        }
        return false;
    }

    // 추가구매 여부 확인.
    public boolean addAmount(){
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
        String input = Console.readLine().toUpperCase();

        try{
            if(!checkInput(input)){
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e){
            System.out.println("[ERROR] 잘못된 입력입니다. 다시 입력해 주세요.\n");
            addAmount();
        }

        if (input.equals("Y")){
            return true;
        }
        return false;
    }
}
