interface Shape {
    double PI = 3.14;
    void area();
    void perimeter();
}

class Circle implements Shape {
    int radius = 5;

    public void area() {
        System.out.println("Area of Circle: " + (PI * radius * radius));
    }

    public void perimeter() {
        System.out.println("Perimeter of Circle: " + (2 * PI * radius));
    }
}

class Rectangle implements Shape {
    int length = 4, breadth = 6;

    public void area() {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle: " + (2 * (length + breadth)));
    }
}

class Square implements Shape {
    int side = 5;

    public void area() {
        System.out.println("Area of Square: " + (side * side));
    }

    public void perimeter() {
        System.out.println("Perimeter of Square: " + (4 * side));
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Shape c = new Circle();
        c.area();
        c.perimeter();

        Shape r = new Rectangle();
        r.area();
        r.perimeter();

        Shape s = new Square();
        s.area();
        s.perimeter();
    }
}
