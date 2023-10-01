sealed class Shape permits Ball, Cylinder, Pyramid {
    private double volume;
    public Shape(double volume) {
        this.volume = volume;
    }
    public double getVolume() {
        return volume;
    }
    public void print() {
        System.out.println(volume);
    }
}
final class Ball extends Shape {
    private double radius;
    public Ball(double radius) {
        super((4.0 / 3) * Math.PI * Math.pow(radius, 3));
        this.radius = radius;
    }
    @Override
    public void print() {
        System.out.println(getVolume());
    }
}
non-sealed class Cylinder extends Shape {
    private double height;
    private double radius;
    public Cylinder(double height, double radius) {
        super(Math.PI * Math.pow(radius, 2) * height);
        this.height = height;
        this.radius = radius;
    }
    @Override
    public void print() {
        System.out.println(getVolume());
    }
}
sealed class Pyramid extends Shape permits ColourPyramid {
    private double height;
    private double area;
    public Pyramid(double height, double area) {
        super(area * height / 3);
        this.height = height;
        this.area = area;
    }
    @Override
    public void print() {
        System.out.println(getVolume());
    }
}
final class ColourPyramid extends Pyramid {
    private String colour;
    public ColourPyramid(double height, double area, String colour) {
        super(height, area);
        this.colour = colour;
    }
    @Override
    public void print() {
        System.out.println(colour);
        super.print();
    }
}
public class Main {
    public static void main(String[] args) {
        Shape ball = new Ball(10);
        Shape cylinder = new Cylinder(2, 7);
        Shape pyramid = new Pyramid(6, 11);
        Shape colourPyramid = new ColourPyramid(6, 18, "red");
        Shape[] shapes = {ball, cylinder, pyramid, colourPyramid};
        for (Shape shape : shapes) {
            shape.print();
            if (shape instanceof Ball b) {
                System.out.println(b.getVolume());
            } else if (shape instanceof Cylinder c) {
                System.out.println(c.getVolume());
            } else if (shape instanceof Pyramid p) {
                System.out.println(p.getVolume());
            }
        }
    }
}
