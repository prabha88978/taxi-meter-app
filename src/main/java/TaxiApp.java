import controller.Owner;

import java.util.Scanner;

public class TaxiApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestedDistance = scanner.nextInt();
        Owner owner = new Owner();

        String costs = owner.calculate(requestedDistance);

        System.out.println(costs);

    }
}
