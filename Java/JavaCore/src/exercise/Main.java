package exercise;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //demo static
//        DemoStatic demoStatic = new DemoStatic();
//        System.out.println(demoStatic.testAttribute);
//        demoStatic.test2();
//        System.out.println(DemoStatic.attribute);
//        DemoStatic.testStatic();

        ///
        List<Account> listAccount = new ArrayList<>();
        //Bank bank = new Bank(listAccount);
        Bank bank = new Bank(new ArrayList<>());
        Account newAccount = new Account("001","hiep",100);
        bank.addNewAccount(newAccount);
        Account newAccount2 = new Account("002","hung",500);
        bank.addNewAccount(newAccount2);

        Account newAccount3 = new Account("004","haha",50);
        bank.addNewAccount(newAccount3);

        bank.printListAccount();


        bank.sortListAccountByBalance();
    }
}
