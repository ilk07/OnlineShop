package hw;
import java.util.ArrayList;

public class PrintService {
    public void printMsg(String msg){
        System.out.println(msg);
    }

    public void printArrayList(ArrayList arrayList){
        for (Object object : arrayList) {
            System.out.println(object);
        }
    }

    public void printShopActions(Shop shop){
        System.out.println("Выберите действие");
        for (int i = 0; i < shop.getActions().size(); i++) {
            System.out.println(i + 1 + ". " + shop.getActions().get(i));
        }
    }



}
