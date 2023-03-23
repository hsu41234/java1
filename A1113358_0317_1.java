import java.util.Scanner;

public class A1113358_0317_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入 n: ");
        int n = scanner.nextInt();
        System.out.print("請輸入 m: ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        System.out.println("二維陣列的內容為:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
