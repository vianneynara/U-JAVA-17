public class Main {
    public static void main(String[] args) {
        Car defaultCar = new Car("Esemka", "YTTA", 30);
        GasPoweredCar toyota = new GasPoweredCar("Toyota", "Venture X", 45);
        var tesla = new ElectricCar("Tesla", "Model Y", 40);
        tesla.setup(42);

        Car hyundai = Car.makeCar("Hyundai", "Ioniq A", "hybrid", 42);
        ((HybridCar) hyundai).setup(42, 6);

        carInformation(defaultCar);
        defaultCar.drive();

        carInformation(toyota);

        carInformation(tesla);

        carInformation(hyundai);
    }

    public static void carInformation(Car car) {
        System.out.printf("""
                %n<CAR INFORMATION>
                Manufacturer: %s
                Car Model   : %s
                Car KM/Litre: %d
                """,
                car.getManufacturer(), car.getModel(), car.getAvgKmPerLitre());
        if (car instanceof GasPoweredCar gasCar) {
            System.out.printf("""
                        • is ready  -> %b
                        • cylinders -> %s
                    """,
                    gasCar.isDoneSetup(),
                    ((gasCar.getCylinders() == 0) ? "not set up" : gasCar.getCylinders())
            );
        } else if (car instanceof ElectricCar eleCar) {
            System.out.printf("""
                        • is ready  -> %b
                        • battery   -> %s
                    """,
                    eleCar.isDoneSetup(),
                    ((eleCar.getBatterySize() == 0) ? "not set up" : eleCar.getBatterySize())
            );
        } else if (car instanceof HybridCar hybCar) {
            System.out.printf("""
                        • is ready  -> %b
                        • cylinder  -> %s
                        • battery   -> %s
                    """,
                    hybCar.isDoneSetup(),
                    ((hybCar.getCylinders() == 0) ? "not set up" : hybCar.getCylinders()),
                    ((hybCar.getBatterySize() == 0) ? "not set up" : hybCar.getBatterySize())
            );
        }
        System.out.printf("[data] class: %s, superclass: %s %n%n",
                car.getClass().getSimpleName(), car.getClass().getSuperclass().getSimpleName());
    }
}
