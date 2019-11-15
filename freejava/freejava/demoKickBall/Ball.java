package freejava.demoKickBall;

//b.getPostion();
//b.setPossiotn();

public class Ball {
    private int m;
    private int position;


    public Ball(int m, int position) {
        this.m = m;
        this.position = position;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int move1(int distance){
        position = position + distance;
        return position;
    }

    public void move2(int distance){
        position += distance;
        System.out.println(position);
    }
}
