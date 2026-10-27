package rental;

public abstract class Vehicle implements Rentable {
    protected String id;
    protected String model;
    protected double dailyRate;
    protected boolean available;

    public Vehicle(String id, String model, double dailyRate) {
        this.id = id;
        this.model = model;
        this.dailyRate = dailyRate;
        this.available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return getClass().getSimpleName() + " " + model
                + " (" + id + ")";
    }
}
