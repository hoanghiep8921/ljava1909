package freejava;

public class ChildStudent extends Student {
    private String address;

    public String getAddress() {
        System.out.println(this.money);
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int minusMoney(){
        this.money = this.money - 1000;
        return this.money;
    }
}
