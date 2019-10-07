package Model;
public class Location {

    private String name;
    private int capacity;
    private boolean available;
    private String address;

    public Location(String name, int capacity, boolean available, String address) {
        this.name = name;
        this.capacity = capacity;
        this.available = available;
        this.address = address;
        checkForName();
        checkForCapacity();
        checkForAdress();
    }

    public Location() {
    }

    public void loadDataFromCSVString(String line) {
        String[] columns = line.split(",");
        this.name = columns[0];
        this.capacity = Integer.parseInt(columns[1]);
        this.available = Boolean.parseBoolean(columns[2]);
        this.address = columns[3];
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

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String toCSVFileSave() {
        return name + "," + capacity + "," + available + "," + address + "\n";
    }
}