package rental;

import java.util.ArrayList;
import java.util.List;

public class RentalShop {
    private List<Vehicle> fleet = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void rent(String id, Customer customer, int days) {
        Vehicle selected = null;

        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(id)) {
                selected = vehicle;
                break;
            }
        }

        if (selected == null) {
            throw new IllegalArgumentException(
                    "Vehicle " + id + " not found");
        }

        if (!selected.isAvailable()) {
            throw new IllegalStateException(
                    selected.getName() + " is already rented");
        }

        if (days <= 0) {
            throw new IllegalArgumentException(
                    "Days must be greater than zero");
        }

        Rental rental = new Rental(selected, customer, days);
        selected.setAvailable(false);
        customer.addRental(rental);

        System.out.printf("%s rented %s for %d days = %.2f%n",
                customer.getName(), selected.getName(),
                days, rental.getTotalRent());
    }

    public void giveBack(String id) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getId().equals(id)) {
                vehicle.setAvailable(true);
                return;
            }
        }

        throw new IllegalArgumentException(
                "Vehicle " + id + " not found");
    }

    public void showAvailable() {
        System.out.println("Available vehicles:");

        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailable()) {
                System.out.println("  " + vehicle.getName());
            }
        }
    }
}