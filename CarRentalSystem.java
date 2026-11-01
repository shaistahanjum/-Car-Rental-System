
import java.util.ArrayList;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Rental> rentals;
    private int nextCustomerId;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        rentals = new ArrayList<>();
        nextCustomerId = 1;

        cars.add(new Car("C001", "Toyota", "Camry", 2500));
        cars.add(new Car("C002", "Honda", "Civic", 2000));
        cars.add(new Car("C003", "Mahindra", "Thar", 3500));
        cars.add(new Car("C004", "Hyundai", "Creta", 2200));
        cars.add(new Car("C005", "Maruti", "Swift", 1500));
    }

    public void displayCars() {
        System.out.println("\n========== CAR LIST ==========");
        for (Car car : cars) {
            car.displayInfo();
        }
    }

    public void rentCar(String carId, String customerName,
                        int days) {
        if (customerName == null || customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        if (days <= 0) {
            System.out.println("Rental days must be greater than zero.");
            return;
        }

        Car selectedCar = null;

        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar == null) {
            System.out.println("Car ID not found.");
            return;
        }

        if (!selectedCar.isAvailable()) {
            System.out.println("Sorry, this car is already rented.");
            return;
        }

        String customerId = String.format("CU%03d",
                nextCustomerId++);
        Customer customer = new Customer(customerId,
                customerName.trim());

        Rental rental = new Rental(selectedCar, customer, days);

        selectedCar.rent();
        rentals.add(rental);

        System.out.println("\nCar rented successfully!");
        rental.displayRentalInfo();
    }

    public void returnCar(String carId) {
        Rental activeRental = null;

        for (Rental rental : rentals) {
            if (rental.getCar().getCarId()
                    .equalsIgnoreCase(carId)) {
                activeRental = rental;
                break;
            }
        }

        if (activeRental == null) {
            System.out.println(
                "No active rental found for this car ID."
            );
            return;
        }

        activeRental.getCar().returnCar();
        rentals.remove(activeRental);

        System.out.println("Car returned successfully!");
        System.out.println("Car: "
                + activeRental.getCar().getBrand() + " "
                + activeRental.getCar().getModel());
        System.out.println("Thank you, "
                + activeRental.getCustomer().getName() + "!");
    }

    public void displayActiveRentals() {
        System.out.println("\n====== ACTIVE RENTALS ======");

        if (rentals.isEmpty()) {
            System.out.println("No active rentals.");
            return;
        }

        for (Rental rental : rentals) {
            rental.displayRentalInfo();
            System.out.println("----------------------------");
        }
    }
}
