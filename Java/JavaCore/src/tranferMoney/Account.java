package tranferMoney;

import java.util.Objects;

public class Account {
    private int id;
    private String name;
    private float balance;

    public Account(int id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(int id) {
        this.id = id;
    }

    public Account() {
    }

    public void credit(int amount){
        if(amount < 0)return;
        this.balance += amount;
        System.out.println("Số dư trong tài khoản"+this.getName()+ " là : " + this.balance);
    }

    public void debit(int amount){
        if(amount < 0 || amount > this.balance ) return;
        this.balance -= amount;
        System.out.println("Số dư trong tài khoản"+this.getName()+ " là : " + this.balance);
    }

    public void transferTo(Account anotherAccount,int amount){
        if(amount < 0 || amount > balance)return;
        balance -= amount;
        float newBalance = anotherAccount.getBalance() + amount;
        anotherAccount.setBalance(newBalance);
        System.out.println("SỐ dư hiện tại của " + anotherAccount.getName() + " là " + anotherAccount.getBalance());
        System.out.println("SỐ dư hiện tại của " + this.getName() + " là " + this.getBalance());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void test1(int i){
        System.out.println("test one parameter");
    }

    public void test1(float i){
        System.out.println("test one parameter");
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void test1(int i, int j){
        System.out.println("test two parameter");
    }

    //@Override
//    public boolean equals(Account account){
//        if(account.getName() == this.getName())
//            return true;
//        else
//            return false;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Account account = (Account) o;
//        return id == account.id &&
//                Float.compare(account.balance, balance) == 0 &&
//                Objects.equals(name, account.name);
//    }

}
