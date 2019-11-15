package freejava.demoKickBall;

public class Run {
    public static void main(String[] args) {
//        Person messi = new Person("Messi",100);
//
//        Person ronaldo = new Person("ronaldo",150);
//
//        Ball b = new Ball(1,0);
//
//        System.out.println("Messi sút bóng");
//        messi.kick(b);
//
//        System.out.println("Ronaldo sút bóng");
//        ronaldo.kick(b);


//        System.out.println(person.getFore() +" --- " + person.getName());

        Boxer boxer1 = new Boxer(60,100,10,"BillGate",5);
        Boxer boxer2 = new Boxer(50,100,8,"Billadel",10);

        int i = 1;
        if(boxer1.getAttackSpeed() > boxer2.getAttackSpeed()){
            i=2;
        }else{
            i = 1;
        }


        while(boxer1.getHp() > 0 && boxer2.getHp() > 0 ){
            if(i%2 == 0){
                boxer1.hit(boxer2);
            }else{
                boxer2.hit(boxer1);
            }
            i++;
        }

    }
}
