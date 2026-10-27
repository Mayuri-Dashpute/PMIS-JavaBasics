package rental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> history = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        history.add(rental);
    }

    public List<Rental> getHistory() {
        return history;
    }
}