package tranferMoney;

public class Date {
    private int day;
    private int month;
    private int year;

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    public Date(int day, int month, int year) {
        if(month < 0 || month > 12){
            System.out.println("Tháng không hợp lệ");
            return;
        }

        if(month == 2 && isLeapYear()){
            if(day < 0 || day > 29){
                System.out.println("Năm nhuận tháng 2 chỉ có 29 ngày");
                return;
            }
        }

        if(month == 2 && !isLeapYear()){
            if(day < 0 || day >28){
                System.out.println("Tháng 2 chỉ có 28 ngày");
                return;
            }
        }

        if(month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12){
            if(day < 0 || day > 31 ){
                System.out.println("Ngày không hợp lệ");
                return;
            }
        }else{
            if(day < 0 || day > 30 ){
                System.out.println("Ngày không hợp lệ");
                return;
            }
        }
        if(year < 0)return;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isLeapYear(){
        if(this.year % 400 == 0 ||
                (this.year % 4  == 0 && this.year % 100 != 0)){
            return true;
        }
        return false;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
