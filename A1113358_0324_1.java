import java.util.Scanner;

public class A1113358_0324_1 {
    private static class Animal {
        private String name;
        private double height;
        private double weight;
        private double speed;

        public Animal(String name, double height, double weight, double speed) {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.speed = speed;
        }

        public void show() {
            System.out.println("Name: " + name);
            System.out.println("Height: " + height + " cm");
            System.out.println("Weight: " + weight + " kg");
            System.out.println("Speed: " + speed + " km/h");
        }

        public double distance(int time, double acceleration) {
            return time * acceleration * speed;
        }

        public double distance(int time) {
            return time * speed;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Animal[] animals = new Animal[3];

        animals[0] = new Animal("貓", 120, 200, 80);
        animals[1] = new Animal("狗", 550, 1200, 60);
        animals[2] = new Animal("豬", 75, 50, 120);

        for (Animal animal : animals) {
            animal.show();
        }

        Scanner scanner = new Scanner(System.in);

        for (Animal animal : animals) {
            System.out.print("Enter time (minutes) for " + animal.getName() + ": ");
            int time = scanner.nextInt();

            System.out.print("Enter acceleration for " + animal.getName() + ": ");
            double acceleration = scanner.nextDouble();

            double distance = animal.distance(time, acceleration);
            System.out.println(animal.getName() + " runs " + distance + " km.");
        }
    }
}