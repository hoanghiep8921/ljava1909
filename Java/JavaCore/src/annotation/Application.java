package annotation;

import java.lang.reflect.Field;

public class Application {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee(null,10);
        checkNull(employee);
        
        Integer[] arrInt = {1,2,3,4};
        Character[] arrChar = {'1','4','3','2'};
        System.out.println("List int");
        Generic.printArr(arrInt);
        System.out.println("list char");
        Generic.printArr(arrChar);
    }

    public static void checkNull(Employee employee) throws IllegalAccessException {
        Field[] fields = employee.getClass().getDeclaredFields();
        for(Field f : fields){
            NotNull notNull = f.getAnnotation(NotNull.class); //null
            f.setAccessible(true);
            //1 => f = private String name
            if(notNull != null && f.get(employee) == null){
                System.out.println("Thuộc tính này bắt buộc phải có gái trị !");
                //throw new Exception("Lỗi rồi");
            }
        }
    }

}
