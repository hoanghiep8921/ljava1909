package annotation;

public class Generic {
    public static <T> void printArr (T[] arr){
        for(T item : arr){
            System.out.println(item);
        }
    }
}
