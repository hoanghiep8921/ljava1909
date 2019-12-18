package exception;

import java.io.NotActiveException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
//        int[] arr = new  int[10];
//        System.out.println(arr[10]);
//        System.out.println("Lỗi rồi bạn ơi");

        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Nhập số muốn chia đi :");
//            int number = scanner.nextInt();
//            //lỗi chia cho 0
//            System.out.println(1 / number);
//
//            //lỗi index vượt quá mảng
//            int[] arr = new  int[10];
//            System.out.println(arr[10]);
            sum(0);
        }
        catch (ArithmeticException e){
            System.out.println("Có lỗi rồi");
        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("Lỗi truy xuất vượt quá độ dài của mảng");
        }
        catch (Exception e){
            System.out.println("Bắt lỗi tất cả ");
        }
        finally {
//            System.out.println("Có lỗi rồi");
            System.out.println("Đã xử lý xong khối try - catch");
        }

        System.out.println("Kết thúc chưong trình");


        System.out.println("____DEMO TRANSFER MONEY___");
        try {
            Account accountA = new Account("00001", 0, "HIEP1");
            Account accountB = new Account("00002", 10, "HIEP2");
            accountA.credit(1000);
            accountA.debit(500);
            accountA.transfer(accountB,200);
        }catch (AmountLessThanZeroException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }catch (AmountGreaterThanBalanceException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }catch (BalanceDifferentZeroException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }catch (NameNotBlankException e){
            System.out.println(e.getCode());
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Thực hiện giao dịch không thành công");
        }

    }

    public static void sum(int number) throws Exception {
        System.out.println("Before throw exception");
        if(number < 0){
            throw new MyException("Lỗi của tôi");
        }
        else{
            throw new NotActiveException("Exception");
        }
//        System.out.println("After throw exception");
    }
}
