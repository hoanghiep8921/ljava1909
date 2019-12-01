package football;

public class Person {
    String name;
    float force;


    public Person(String name, float force) {
        this.name = name;
        this.force = force;
    }

    void kick(Ball ball){
        float s = force * ball.m;
        ball.move(s);
    }
}
