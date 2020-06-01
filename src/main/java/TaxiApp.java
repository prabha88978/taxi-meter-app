import controller.Calculator;
import taxi.model.Customer;

import java.util.Scanner;

public class TaxiApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestedDistance = scanner.nextInt();
        String mobileNumber = scanner.next();
        Calculator calculator = new Calculator();
        Customer customer = new Customer(mobileNumber);
        String costs = calculator.calculate(customer, requestedDistance);
        System.out.println(costs);
    }
}