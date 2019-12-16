package collection;

import java.util.Objects;

public class Student implements Comparable{
    private String name;
    private Integer age;
    private Integer money;

    public Student(String name, Integer age, Integer money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student test = (Student) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        Student a = (Student)o;
        if(money < a.money){
            return 1;
        }
        if(money > a.money){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
