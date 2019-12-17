package exception;

public class Account {
    private String id;
    private float balance;
    private String name;

    public Account(String id, float balance, String name) throws BalanceDifferentZeroException, NameNotBlankException {
        if(name.isEmpty()){
            throw new NameNotBlankException();
        }
        if(balance != 0){
            throw new BalanceDifferentZeroException();
        }
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public void credit(int amount) throws AmountLessThanZeroException {
        if(amount < 0){
//            CreditException creditException = new CreditException();
//            creditException.setCode("03");
//            creditException.setMessage("Số tiền nạp vào tài khoản phải lớn hơn 0");
            throw new AmountLessThanZeroException();
        }
        this.balance += amount;
    }

    public void debit(int amount) throws AmountGreaterThanBalanceException {
        if(amount < 0 || amount > balance){
            throw new AmountGreaterThanBalanceException();
        }
        this.balance -= amount;
    }

    public void transfer(Account anotherAccount,int amount) throws
            AmountLessThanZeroException, AmountGreaterThanBalanceException {
        if(amount < 0){
            throw new AmountLessThanZeroException();
        }
        if(amount > balance){
            throw new AmountGreaterThanBalanceException();
        }
        this.balance -= amount;
        anotherAccount.setBalance(anotherAccount.getBalance() + amount);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
