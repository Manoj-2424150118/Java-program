class Animal {
    String color = "White";
}

class Dog extends Animal {
    String color = "Black";

    void displayColor() {
        System.out.println("Dog color: " + color);
        System.out.println("Animal color: " + super.color); // using super
    }
}

public class SuperKeywordExample {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.displayColor();
    }
}
