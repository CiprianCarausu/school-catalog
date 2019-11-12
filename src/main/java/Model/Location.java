package Model;

public class Location implements Comparable<Location> {

    private String name;
    private int capacity;
    private boolean isAvailable;
    private String address;

    public Location(String name, int capacity, boolean isAvailable, String address) {
        this.name = name;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        this.address = address;
        checkForName();
        checkForCapacity();
        checkForAdress();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int compareTo(Location o) {
        return this.capacity - o.capacity;
    }

    private void checkForName() {
        if (this.name.length() > 5) {
            throw new IllegalArgumentException("The name is more than 5 characters.");
        }
        if ("".equals(name)) {
            throw new IllegalArgumentException("Please enter the name");
        }
    }

    private void checkForCapacity() {
        if (capacity < 50 || capacity > 300) {
            throw new IllegalArgumentException("The capacity is not between 50 and 300 seats");
        }
    }

    private void checkForAdress() {
        if ("".equals(address)) {
            throw new IllegalArgumentException("Please complete Adress section");
        }
    }
}