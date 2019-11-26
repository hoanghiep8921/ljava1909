//public class Application {
//
//    public static void main(StringAndArray[] args) {
//        int number1 = Integer.MAX_VALUE;
//        int number2 = Integer.MAX_VALUE;
//        System.out.println(number1+number2);
//        int max = number1 > number2 ? number1 : number2;
//        boolean check = number1 > 0 ? false : true;
//
//        char a = 'A';
//        StringAndArray b = "test string";
//
//        System.out.println("Hello World");
//
//        System.out.println(b + number1);
//        System.out.println(number1 + number2 + b);
//
//        int accountA = 5000;
//        int accountB = 2000;
//
//        int money = 500;
//
//        if(money > accountA ){
//
//        }else if(money < 0){
//
//        }else if(accountA < 0 || accountB < 0){
//
//        }else {
//            accountA -= money;
//            accountB += money;
//            System.out.println();
//        }
//
//
//        System.out.println(checkNT(7));
//        sumNumber(1998);
//    }
//
//    public static boolean checkNT(int number){
//        if(number < 2){
//            return false;
//        }
//        for(int i = 2 ; i < number ; i++ ){
//            if(number % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void sumNumber(int number){
//        int currentNumber = number;
//        int sum = 0;
//        while (number > 0){
//            int unit = number % 10;
//            sum += unit ;  //sum = sum + unit;
//            number = number / 10;
//        }
//        System.out.println("Tổng của số "+ currentNumber + " là : " + sum);
//    }
//}
