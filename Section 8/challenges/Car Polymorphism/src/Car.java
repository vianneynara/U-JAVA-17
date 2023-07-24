public class Car {
    private String manufacturer, model;
    protected int avgKmPerLitre;
    protected boolean doneSetup;
    private boolean engineState;

    public Car(String manufacturer, String model, int avgKmPerLitre) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.avgKmPerLitre = avgKmPerLitre;
        doneSetup = false;
        engineState = false;
    }

    public static Car makeCar(String manufacturer, String model, String type, int avgKmPerLitre) {
        return switch (type.toUpperCase().charAt(0)) {
            case 'G' -> new GasPoweredCar(manufacturer, model, avgKmPerLitre);
            case 'E' -> new ElectricCar(manufacturer, model, avgKmPerLitre);
            case 'H' -> new HybridCar(manufacturer, model, avgKmPerLitre);
            default -> new Car(manufacturer, model, avgKmPerLitre);
        };
    }

    public void startEngine() {
        System.out.println("Engine starting...");
        engineState = true;
    }

    public void stopEngine() {
        System.out.println("Engine stopping...");
        engineState = false;
    }

    public void drive() {
        runEngine();
        System.out.println("Car is being driven");
    }

    protected void runEngine() {
        System.out.println("Engine is running");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getAvgKmPerLitre() {
        return avgKmPerLitre;
    }

    public boolean isDoneSetup() {
        return doneSetup;
    }
}

class GasPoweredCar extends Car {
    private int cylinders;

    public GasPoweredCar(String manufacturer, String model, int avgKmPerLitre, int cylinders) {
        super(manufacturer, model, avgKmPerLitre);
        this.doneSetup = false;
        this.cylinders = cylinders;
    }

    public GasPoweredCar(String manufacturer, String model, int avgKmPerLitre) {
        super(manufacturer, model, avgKmPerLitre);
        this.doneSetup = false;
        this.cylinders = 6;
    }

    public int getCylinders() {
        return cylinders;
    }
}
    
class ElectricCar extends Car {
    private int batterySize;

    public ElectricCar(String manufacturer, String model, int avgKmPerLitre) {
        super(manufacturer, model, avgKmPerLitre);
        this.doneSetup = false;
    }

    public void setup(int batterySize) {
        this.batterySize = batterySize;
        doneSetup = true;
    }

    @Override
    public void startEngine() {
        if (!doneSetup) { System.out.println("Please set the car up first"); return; }

        System.out.println("Battery is powering up, engine starting...");
    }

    public int getBatterySize() {
        return batterySize;
    }
}

class HybridCar extends Car {
    private int batterySize;
    private int cylinders;
    private boolean isUsingBattery;

    public HybridCar(String manufacturer, String model, int avgKmPerLitre) {
        super(manufacturer, model, avgKmPerLitre);
        this.isUsingBattery = false;
        this.doneSetup = false;
    }

    public void setup(int batterySize, int cylinders) {
        this.batterySize = batterySize;
        this.cylinders = cylinders;
        doneSetup = true;
    }

    public String toggleBatteryMode() {
        if (!doneSetup) { System.out.println("Please set the car up first"); return "Car Not Set Up"; }

        if (isUsingBattery) {
            System.out.println("[!] Turning battery mode off");
            isUsingBattery = false;
            return "battery mode deactivated";
        } else {
            System.out.println("[!] Turning battery mode on");
            isUsingBattery = true;
            return "battery mode activated";
        }
    }

    @Override
    public void startEngine() {
        if (!doneSetup) { System.out.println("Please set the car up first"); return; }

        System.out.println("Engine starting...");
        if (isUsingBattery) System.out.println("...with battery mode");
    }

    public int getBatterySize() {
        return batterySize;
    }

    public int getCylinders() {
        return cylinders;
    }

    public boolean isUsingBattery() {
        return isUsingBattery;
    }
}
