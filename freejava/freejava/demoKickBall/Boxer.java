package freejava.demoKickBall;

public class Boxer {
    private int weight;
    private int hp;
    private int force;
    private String name;
    private int attackSpeed;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public void hit(Boxer boxer){
        int damage = force + attackSpeed;
        boxer.setHp(boxer.getHp() - damage);
        System.out.println("Thằng bị đấm " + boxer.getName() + " còn " +boxer.getHp());
        System.out.println("Thằng được đấm " + this.getName() + " còn " +this.getHp());
    }

}
