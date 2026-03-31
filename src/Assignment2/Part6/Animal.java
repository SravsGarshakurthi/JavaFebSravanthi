package Assignment2.Part6;

// superclass
class Animal {
    String name;
    String sound;
    int legs;

    Animal(String name, String sound, int legs) {
        this.name  = name;
        this.sound = sound;
        this.legs  = legs;
    }

    void speak() {
        System.out.println(name + " says " + sound);
    }
}

// Dog subclass
class Dog extends Animal {
    String breed;

    Dog(String name, String sound, int legs, String breed) {
        super(name, sound, legs); // calls Animal's constructor
        this.breed = breed;
    }

    @Override
    void speak() {
        System.out.println(name + " says " + sound + " and wags tail");
    }
}

// Bird subclass
class Bird extends Animal {
    boolean canFly;

    Bird(String name, String sound, int legs, boolean canFly) {
        super(name, sound, legs);
        this.canFly = canFly;
    }

    @Override
    void speak() {
        System.out.println(name + " says " + sound);
    }

    void fly() {
        if (canFly) {
            System.out.println(name + " is flying high!");
        } else {
            System.out.println(name + " cannot fly.");
        }
    }
}

// Fish subclass
class Fish extends Animal {
    String waterType;

    Fish(String name, String sound, int legs, String waterType) {
        super(name, sound, legs);
        this.waterType = waterType;
    }

    @Override
    void speak() {
        System.out.println(name + " says " + sound);
    }

    void swim() {
        System.out.println(name + " is swimming in " + waterType + " water!");
    }
}

// main class
class Inheritance {

    public static void main(String[] args) {

        // create one instance of each
        Dog  dog  = new Dog("Tommy",  "Woof", 4, "Labrador");
        Bird bird = new Bird("Kili",  "Tweet", 2, true);
        Fish fish = new Fish("Nemo",  "...",   0, "Salt");
        Animal animal = new Animal("Motu", "Roar", 4);

        System.out.println("=== Individual speak() calls ===");
        dog.speak();
        bird.speak();
        fish.speak();
        animal.speak();

        System.out.println("\n=== fly() and swim() ===");
        bird.fly();
        fish.swim();

        // Animal array storing all objects
        System.out.println("\n=== Looping through Animal array ===");
        Animal[] animals = new Animal[4];
        animals[0] = dog;
        animals[1] = bird;
        animals[2] = fish;
        animals[3] = animal;

        for (int i = 0; i < animals.length; i++) {
            animals[i].speak();
        }
    }
}