public class Car {
    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;
    public Car(String colour, int maxFuel, String model) {
        this.colour = colour;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = new Engine();
    }
    public void startEng() {
        if (fuel <= 0) {
            System.out.println("No fuel. Refuel please");
            return;
        }
        engine.turnon();
        System.out.println("Engine is running");
    }
    public void stopEng() {
        engine.turnoff();
        System.out.println("Engine is off");
    }
    public void refuel() {
        refuel(maxFuel - fuel);
    }
    public void refuel(int amount) {
        if (amount <= 0) {
            System.out.println("No fuel");
            return;
        }
        fuel = Math.min(fuel + amount, maxFuel);
        System.out.println("Car is refueled, fuel level: " + fuel);
    }
    public void drive(int distance) {
        if (!engine.isOn()) {
            System.out.println("Start engine");
            return;
        }
        double maxDistance = fuel / engine.getFuelConsumption();
        if (distance > maxDistance) {
            System.out.println("Refuel");
            return;
        }

        fuel -= distance * engine.getFuelConsumption();
        mileage += distance;
        System.out.println("Car passed " + distance + " km Mileage: " + mileage + " km.");
    }
    public void info() {
        System.out.println("info:");
        System.out.println("Colour: " + colour);
        System.out.println("Fuel level: " + fuel);
        System.out.println("MaxFuel Level: " + maxFuel);
        System.out.println("Model: " + model);
        System.out.println("Mileage: " + mileage + " км");
        System.out.println("Engine status: " + (engine.isOn() ? "on" : "off"));
        System.out.println("Fuel consumption: " + engine.getFuelConsumption());
    }
    private class Engine {
        private boolean isOn;
        private int fuelConsumption;
        public Engine() {
            this.isOn = false;
            this.fuelConsumption = 40; // default fuel consumption rate
        }
        public void turnon() {
            isOn = true;
        }
        public void turnoff() {
            isOn = false;
        }
        public boolean isOn() {
            return isOn;
        }
        public double getFuelConsumption() {
            return fuelConsumption;
        }
    }
}
