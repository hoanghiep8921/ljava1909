package caculateArea;

public class Trapeze extends Shape {
        private int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
        this.b = b;
    }

    public Trapeze(int h, int a , int b , int numberSide) {
        this.b = b;
        this.a = a;
        this.h = h;
        this.numberSide = numberSide;
    }

    @Override
    float area() {
        int s = (a+b)*h/2;
        return s;
    }

    @Override
    void printData() {

    }
}
