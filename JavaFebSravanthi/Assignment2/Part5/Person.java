package Assignment2.Part5;

public class Person {

    // all fields are private — no one can access them directly
    private String name;
    private int    age;
    private String email;
    private double salary;

    // constructor to create a person
    Person(String name, int age, String email, double salary) {
        this.name   = name;
        this.age    = age;
        this.email  = email;
        this.salary = salary;
    }

    // --- GETTERS ---
    public String getName()   { return name;   }
    public int    getAge()    { return age;    }
    public String getEmail()  { return email;  }
    public double getSalary() { return salary; }

    // --- SETTERS with validation ---

    public void setName(String name) {
        this.name = name; // no validation needed for name
    }

    public void setAge(int age) {
        // age must be between 0 and 120
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age! Age must be between 0 and 120. Keeping old value: " + this.age);
        }
    }

    public void setEmail(String email) {
        // email must have an @ symbol
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email! Must contain '@'. Keeping old value: " + this.email);
        }
    }

    public void setSalary(double salary) {
        // salary can't be negative
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary! Salary can't be negative. Keeping old value: " + this.salary);
        }
    }

    // print all details
    public void displayInfo() {
        System.out.println("\n--- Person Details ---");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Email  : " + email);
        System.out.println("Salary : $" + salary);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        // create a person with valid details
        Person p = new Person("Kavya", 25, "kavya@gmail.com", 55000.0);

        System.out.println("=== Original Details ===");
        p.displayInfo();

        System.out.println("=== Trying Invalid Values ===\n");

        // try setting invalid age
        p.setAge(-5);

        // try setting invalid salary
        p.setSalary(-1000);

        // try setting invalid email
        p.setEmail("notvalid");

        System.out.println("\n=== Details After Invalid Attempts ===");
        p.displayInfo(); // old values should still be there

        System.out.println("=== Trying Valid Values ===\n");

        // now set valid values
        p.setAge(28);
        p.setSalary(70000);
        p.setEmail("kavya@outlook.com");

        System.out.println("\n=== Final Details ===");
        p.displayInfo(); // updated values should show now
    }
}