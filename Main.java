
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalSystem system = new CarRentalSystem();

        System.out.println("==================================");
        System.out.println("       CAR RENTAL SYSTEM");
        System.out.println("==================================");

        boolean running = true;

        while (running) {
            System.out.println("\n1. Display All Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. View Active Rentals");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    system.displayCars();
                    break;

                case "2":
                    system.displayCars();

                    System.out.print("\nEnter Car ID: ");
                    String carId = scanner.nextLine().trim();

                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Rental Days: ");
                    try {
                        int days = Integer.parseInt(
                                scanner.nextLine().trim());

                        system.rentCar(carId, customerName, days);
                    } catch (NumberFormatException e) {
                        System.out.println(
                            "Please enter a valid number of days."
                        );
                    }
                    break;

                case "3":
                    System.out.print("Enter Car ID to return: ");
                    String returnId = scanner.nextLine().trim();
                    system.returnCar(returnId);
                    break;

                case "4":
                    system.displayActiveRentals();
                    break;

                case "5":
                    running = false;
                    System.out.println(
                        "Thank you for using Car Rental System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please select 1 to 5."
                    );
            }
        }

        scanner.close();
    }
}

