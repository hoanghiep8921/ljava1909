package freejava.demoKickBall;

public class Person {
    private String name;
    private int fore;

    Person(String name, int fore){
        this.name =name;
        this.fore = fore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFore() {
        return fore;
    }

    public void setFore(int fore) {
        this.fore = fore;
    }

    public void kick(Ball ball){
        int S = fore * ball.getM();
        int distanceAfterKick = ball.move1(S);
        System.out.println(distanceAfterKick);

        ball.move2(S);
    }
}
