package caculateArea;

public abstract class Shape {
    protected int h;
    protected int a;
    protected int numberSide;

    abstract float area();
    abstract void printData();
    public void test(){
        System.out.println(h+a);
    }
}
