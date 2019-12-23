package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Bank {
    private List<Account> accountList;

    public Bank(List<Account> accountList) {
        this.accountList = accountList;
    }


    public void printListAccount(){
        System.out.println("In ra danh sách tài khoản :");
        //c1
        for(Account a : accountList){
            System.out.println(a.toString());
        }
        //c2
//        for(int i = 0; i < accountList.size() ;i++){
//            System.out.println(accountList.get(i).toString());
//            //accountList[i]
//        }
    }

    public void addNewAccount(Account newAccount){
        //c1
//        for(Account a : accountList){
//            //check trùng số tài khoản
//            if(a.getId() == newAccount.getId()){
//                System.out.println("Đã trùng số tài khoản");
//                return;
//            }
//        }

        //c2 : phải dùng equals và hashCode
        if(accountList.contains(newAccount)){
            System.out.println("Đã trùng số tài khoản");
            return;
        };
        accountList.add(newAccount);
        System.out.println("Đã thêm tài khoản thành công " +newAccount.getName());
    }

    public void sortListAccountByBalance(){
        //c1 : Lưu ý dùng comparable
        //Collections.sort(accountList);

        //c2 : dung comparator
        accountList.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if(o1.getBalance() > o2.getBalance()){
                    return -1;
                }
                if(o1.getBalance() < o2.getBalance()){
                    return 1;
                }
                return 0;
            }
        });

        System.out.println("Danh sách tài khoản khi sắp xếp là : ");
        for(Account a : accountList){
            System.out.println(a.toString());
        }
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
