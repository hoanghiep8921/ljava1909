package boxing;

public class Main {
    public static void main(String[] args) {
        Boxer boxer1 = new Boxer("BillGate",10);
        Boxer boxer2 = new Boxer("Bin La Đen",15);

        int round = 0;
        if(boxer1.damage < boxer2.damage ){
            round = 2;
        }else{
            round = 1;
        }

        while(boxer1.hp >= 0 && boxer2.hp >= 0 ){
            boxer1.randomCrit();
            boxer1.randomMissRate();

            boxer2.randomCrit();
            boxer2.randomMissRate();

            if(round % 2 == 0 ){
                boxer1.hit(boxer2);
            }else{
                boxer2.hit(boxer1);
            }
            round++;

        }
    }

}
