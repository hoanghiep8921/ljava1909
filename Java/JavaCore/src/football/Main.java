package football;

import boxing.Boxer;
import caculateArea.Triangle;

public class Main {
    public static void main(String[] args) {
        Person ro = new Person("Rô lan đô",10);
        System.out.println("Lực sút của cầu thủ " + ro.force);

        System.out.println("Tên cầu thủ là "+ ro.name);
        Person mess = new Person("Mét xi",20);

        Ball ball = new Ball(3.2f,0);
        System.out.println(ball.distance + " ___" +ball.m);

        ro.kick(ball);
        mess.kick(ball);

    }
}
