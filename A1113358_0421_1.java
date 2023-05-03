import java.util.*;

public class A1113358_0224_1 {
    public static void main (String [] args){
        String email;
        System.out.print("請輸入電子郵件信箱: ");
        Scanner input = new Scanner(System.in);
        email = input.nextLine();

        if(email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")){
            System.out.println("輸入格式正確");
        }else{
            System.out.println("輸入格式錯誤");
        }
    }
}