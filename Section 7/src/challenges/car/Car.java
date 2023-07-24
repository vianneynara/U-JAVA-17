package challenges.car;

public class Car {

    private static String make;
    private static String model;
    private static String color = "White";
    private static int door;
    private static boolean isConvertible;
    public void setMake(String make) {
        if (make == null) make = "Unknown";
        switch (make.toLowerCase()) {
            case "holden", "porche", "tesla" -> this.make = make;
            default -> this.make = "Unsupported";
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public void setConvertible(boolean isConvertible) {
        this.isConvertible = isConvertible;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoor() {
        return door;
    }

    public boolean isIsConvertible() {
        return isConvertible;
    }

    public String getMake() {
        return make;
    }

    public void describeCar() {
        System.out.println("Maker: " + make +
                "\nModel: " + model +
                "\nColor: " + color +
                "\nDoors: " + door +
                "\nIs convertible? " + (isConvertible ? "Yes" : "No")
        );
    }
}
