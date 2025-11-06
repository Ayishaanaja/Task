package Interface;
interface Drawable {
 void draw();
}

class Circle implements Drawable {
 double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 @Override
 public void draw() {
     System.out.println("Drawing a Circle with radius: " + radius);
 }
}

//Main class to test the shape
public class Shapes {
 public static void main(String[] args) {
     Circle c = new Circle(6.0);
     c.draw();
 }
}
