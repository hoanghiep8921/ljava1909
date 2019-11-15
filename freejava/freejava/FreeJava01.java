package freejava;

public class FreeJava01 {

    public static void main(String[] args) {
        int number1 = 20;
        int number2 = 40;
        int maxInt = Integer.MAX_VALUE;
        System.out.println((long)maxInt + maxInt);
        System.out.println(number1 + number2);
        System.out.println("Hello World");

        transfer(1000,2000,500);

        Student student = new Student();
        //student.name = "abc";
        student.getName();
    }

    public static void transfer(int account1,int account2,int money){
        if(account1 < money){
            System.out.println("Không thể chuyển tiền");
            return;
        }
        account1 = account1 - money;
        account2 = account2 +money;
        System.out.println("SỐ tiền của tài khoản 1 là :" + account1);
        System.out.println("SỐ tiền của tài khoản 2 là :" + account2);
    }

}
