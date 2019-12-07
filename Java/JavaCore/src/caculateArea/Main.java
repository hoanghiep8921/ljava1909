package caculateArea;

import com.sun.javafx.geom.ShapePair;

public class Main {
    public static void main(String[] args) {
        Triangle tamgiac = new Triangle(10,20,3);
        System.out.println(tamgiac.h);
        System.out.println(tamgiac.area());
        Square square = new Square(10,4);
        System.out.println(square.area());
        Trapeze trapeze = new Trapeze(10,20,30,4);
        System.out.println(trapeze.area());
        Rectangle rectangle = new Rectangle();
        rectangle.area();
        rectangle.toString();

        Shape shape = new Triangle(10,10,10);
        TestA test = new TestB();
        TestA testa = new TestA();

    }
}
