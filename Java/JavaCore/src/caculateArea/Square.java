package caculateArea;

public class Square extends Shape {

    public Square(int h,int numberSide) {
        this.h = h;
        this.numberSide = numberSide;
    }

    @Override
    float area() {
        int s = h*h;
        return s;
    }

    @Override
    void printData() {

    }
}
