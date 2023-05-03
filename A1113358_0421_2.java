import java.util.*;

public class A1113358_0421_2{
    public static void main (String [] argv){
        String x;
        System.out.print("請輸入日期(YYYY/MM/DD或MM/DD/YYYY):");
        Scanner input = new Scanner(System.in);
        x=input.nextLine();
        //System.out.println(x.matches("[0-9]{4}[/]{1}[0-1]{1}[0-9]{1}[/]{1}[0-3]{1}[0-9]{1}"));
        //System.out.println(x.matches("[0-1]{1}[0-9]{1}[/]{1}[0-3]{1}[0-9]{1}[/]{1}[0-9]{4}"));
        if(x.matches("[0-9]{4}[/]{1}[0-1]{1}[0-9]{1}[/]{1}[0-3]{1}[0-9]{1}") == true || x.matches("[0-1]{1}[0-9]{1}[/]{1}[0-3]{1}[0-9]{1}[/]{1}[0-9]{4}") == true){
            System.out.println("輸入格式正確");
        }else{
            System.out.println("輸入格式錯誤");
        }
    }
}