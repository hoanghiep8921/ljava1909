package tranferMoney;

public class Main {
    public static void main(String[] args) {
        Account a = new Account(1,"Hiep",5000.0f);
        a.test1(1);
        a.test1(1.0f);
        a.test1(1,2);

        System.out.println("__________");
        Account b = new Account(2,"JVever",0.0f);
        b.credit(1000);
        a.debit(500);
        a.transferTo(b,2000);


        System.out.println("________");
        Date now = new Date(55,100,-1999);
        System.out.println(now.toString());
    }
}
