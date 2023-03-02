import java.util.*;

public class A1113358_0224_2{
    public static void main(String args[]){
        int num;
        System.out.println("請輸入攝氏溫度");
        Scanner input = new Scanner(System.in);
        num=input.nextInt();
        System.out.println("此攝氏溫度之華氏溫度為："+((num*9/5)+32));
    }
}