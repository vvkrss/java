import java.util.Random;
enum FoodType {
    EXPENSIVE, CHEAP
}
class Pet {
    protected String name;
    protected double weight;
    protected int age;
    protected String owner;
    public Pet(String name, double weight, int age, String owner) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.owner = owner;
    }
    public void say() {
        System.out.println("Pet said...");
    }
}
class Cat extends Pet {
    private FoodType foodType;
    private String breed;
    public Cat(String name, double weight, int age, String owner, String breed, FoodType foodType) {
        super(name, weight, age, owner);
        this.foodType = foodType;
        this.breed = breed;
    }
    @Override
    public void say() {
        System.out.println(name + " said myaaa");
    }
    public void walk() {
        System.out.println("Walk with " + owner + " and " + breed + " cat");
    }
    public void walk(String name) {
        System.out.println("Walk with " + name + " and " + breed + " cat");
    }
}
class Dog extends Pet {
    private String breed;
    private FoodType foodType;
    public Dog(String name, double weight, int age, String owner, String breed, FoodType foodType) {
        super(name, weight, age, owner);
        this.breed = breed;
        this.foodType = foodType;
    }
    @Override
    public void say() {
        System.out.println(name + " said gaaav");
    }
    public void walk() {
        System.out.println("Walk with " + owner + " and " + breed + " dog");
    }
    public void walk(String name) {
        System.out.println("Walk with " + name + " and " + breed + " dog");
    }
}
class Parrot extends Pet {
    private String country;
    private boolean documents;
    public Parrot(String name, double weight, int age, String owner, String country, boolean documents) {
        super(name, weight, age, owner);
        this.country = country;
        this.documents = documents;
    }
    @Override
    public void say() {
        System.out.println(name + " said .....");
    }
    public void fly() {
        Random random = new Random();
        int minutes = random.nextInt(60);
        System.out.println(name + " flew away but promised to return " + minutes + " minute");
    }
}
