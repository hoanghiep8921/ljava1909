package boxing;

import java.util.Random;

public class Boxer {

    String name;
    int hp = 100;
    int damage;
    int missRate;
    int crit;

    public Boxer(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    void randomCrit(){
        Random random = new Random();
        this.crit = random.nextInt(10);
    }
    void randomMissRate(){
        Random random = new Random();
        this.missRate = random.nextInt(100);

    }

    void hit(Boxer boxer){
        if(boxer.missRate > 50){
            System.out.println(this.name + " đã đấm xí hụt " + boxer.name );
            System.out.println("___");
            return;
        }
        int totalDamage = damage + crit;
        boxer.decreaseHp(totalDamage);
        System.out.println(this.name + " Máu của người đấm là" + this.hp);
        System.out.println(boxer.name + " Máu của người đấm là" + boxer.hp);
        System.out.println("_______");
    }

    void decreaseHp(int damage){

        this.hp -= damage;
    }
}
