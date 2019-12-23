package exercise;

import java.util.Objects;

public class Account {
    private String id;
    private String name;
    private float balance;

    public Account(String id, String name, float balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

//    @Override
//    public int compareTo(Object account) {
//        Account a =  (Account) account;
//        if(this.getBalance() > a.getBalance()){
//            return 1;
//        }
//        if(this.getBalance() < a.getBalance()){
//            return -1;
//        }
//        return 0;
//
//    }
}
