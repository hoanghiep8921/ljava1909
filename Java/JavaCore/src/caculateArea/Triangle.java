package caculateArea;

public class Triangle extends Shape{

    public Triangle(int h,int a,int numberSide) {
        this.h = h;
        this.a = a;
        this.numberSide = numberSide;
    }

    @Override
    float area() {
        int s = a*h/2;
        return s;
    }

    @Override
    void printData() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
