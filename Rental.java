
public class Rental {
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return car.calculatePrice(days);
    }

    public void displayRentalInfo() {
        System.out.println("Customer ID: "
                + customer.getCustomerId());
        System.out.println("Customer Name: "
                + customer.getName());
        System.out.println("Car: "
                + car.getBrand() + " " + car.getModel());
        System.out.println("Rental Days: " + days);
        System.out.printf("Total Price: Rs. %.2f%n",
                getTotalPrice());
    }
}

