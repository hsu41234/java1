import java.util.Random;
import java.util.Scanner;

class DumplingShop {
    private int porkDumplings;
    private int beefDumplings;
    private int vegetableDumplings;

    public DumplingShop(int porkDumplings, int beefDumplings, int vegetableDumplings) {
        this.porkDumplings = porkDumplings;
        this.beefDumplings = beefDumplings;
        this.vegetableDumplings = vegetableDumplings;
    }

    public synchronized boolean sellDumplings(String type, int quantity) {
        int availableDumplings = 0;
        switch (type) {
            case "豬肉水餃":
                availableDumplings = porkDumplings;
                break;
            case "牛肉水餃":
                availableDumplings = beefDumplings;
                break;
            case "蔬菜水餃":
                availableDumplings = vegetableDumplings;
                break;
        }
        if (availableDumplings >= quantity) {
            switch (type) {
                case "豬肉水餃":
                    porkDumplings -= quantity;
                    break;
                case "牛肉水餃":
                    beefDumplings -= quantity;
                    break;
                case "蔬菜水餃":
                    vegetableDumplings -= quantity;
                    break;
            }
            return true;
        }
        return false;
    }
}

class Customer implements Runnable {
    private static final int MIN_QUANTITY = 10;
    private static final int MAX_QUANTITY = 50;

    private String name;
    private DumplingShop shop;

    public Customer(String name, DumplingShop shop) {
        this.name = name;
        this.shop = shop;
    }

    private String getRandomDumplingType() {
        String[] types = {"豬肉水餃", "牛肉水餃", "蔬菜水餃"};
        Random random = new Random();
        int index = random.nextInt(types.length);
        return types[index];
    }

    private int getRandomQuantity() {
        Random random = new Random();
        return random.nextInt(MAX_QUANTITY - MIN_QUANTITY + 1) + MIN_QUANTITY;
    }

    @Override
    public void run() {
        String dumplingType = getRandomDumplingType();
        int quantity = getRandomQuantity();
        boolean sold = shop.sellDumplings(dumplingType, quantity);
        if (sold) {
            System.out.println(name + " 買了 " + dumplingType + " x" + quantity);
        } else {
            System.out.println(name + " 想買 " + dumplingType + " x" + quantity + "，但已經售完了");
        }
    }
}

public class A1113358_0512 {
    public static void main(String[] args) {
        int porkDumplings = 5000;
        int beefDumplings = 3000;
        int vegetableDumplings = 1000;

        DumplingShop shop = new DumplingShop(porkDumplings, beefDumplings, vegetableDumplings);
        Scanner scanner = new Scanner(System.in);

        while (porkDumplings > 0 || beefDumplings > 0 || vegetableDumplings > 0) {
            System.out.print("請輸入顧客數量：");
            int numCustomers = scanner.nextInt();
            if (numCustomers == 0) {
                break;
            }

            Thread[] threads = new Thread[numCustomers];
            for (int i = 0; i < numCustomers; i++) {
                threads[i] = new Thread(new Customer("顧客 " + (i + 1), shop));
                threads[i].start();
            }

            for (int i = 0; i < numCustomers; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}