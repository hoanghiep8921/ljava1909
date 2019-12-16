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


        System.out.println("________");
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        System.out.println( 1 == 1);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        System.out.println(a.equals(b));

        Account c = new Account(1,"Hiep",0.0f);

        Account d = new Account(1,"Hiep",0.0f);

        System.out.println("So sánh 2 account :" + d.equals(c));

    }
}
