import controller.Owner;
import taxi.model.Customer;

import java.util.Scanner;

public class TaxiApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestedDistance = scanner.nextInt();
        String mobileNumber = scanner.next();
        Owner owner = new Owner();
        Customer customer = new Customer(mobileNumber, requestedDistance);
        String costs = owner.calculate(customer);
        System.out.println(costs);
    }
}
