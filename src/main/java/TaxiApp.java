import controller.Calculator;
import taxi.model.*;

import java.util.Scanner;

public class TaxiApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int requestedDistance = scanner.nextInt();
        String mobileNumber = scanner.next();
        Customer customer = new Customer(mobileNumber);
        AppUsers appUsers = new AppUsers();
        Calculator calculator = new Calculator();
        String costs = null;
        try {
            costs = calculator.calculate(appUsers, customer, requestedDistance);
        } catch (InvalidAmountException e) {
            e.printStackTrace();
        }
        System.out.println(costs);
    }
}