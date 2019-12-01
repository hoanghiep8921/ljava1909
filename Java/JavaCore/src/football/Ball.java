package football;

public class Ball {
    float m;
    float distance;

    public Ball(float m, float distance) {
        this.m = m;
        this.distance = distance;
    }

    void move(float distance){
        this.distance += distance;
        System.out.println("Vị trí của quả bóng là :" + this.distance);
    }
}
