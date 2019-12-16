package collection;

import java.util.*;

public class Application {


    public static void main(String[] args) {
        List lst = new List() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public Object[] toArray(Object[] a) {
                return new Object[0];
            }

            @Override
            public boolean add(Object o) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(Collection c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public Object set(int index, Object element) {
                return null;
            }

            @Override
            public void add(int index, Object element) {

            }

            @Override
            public Object remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator listIterator() {
                return null;
            }

            @Override
            public ListIterator listIterator(int index) {
                return null;
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        List arrayList = null;
//        int i = 0;
//        if(i % 2 == 0){
//            arrayList = new LinkedList();
//        }else{
//            arrayList = new ArrayList();
//        }
        ArrayList arrayList1 = new ArrayList();
        List linkedList = new LinkedList();

        int [] arr = new int[5];
        arr[0] = 1;

        ArrayList<String> list = new ArrayList<>();
        list.add("Name A");
        list.add("ABCD");
        list.add("DEFG");
        list.add(0,"First Element");
        //list.remove(1);
        list.remove("ABCD");
        list.add("First Element");
        list.isEmpty();

        ArrayList<String> newArr = new ArrayList<>();
        newArr.add("123");
        newArr.add("456");
        newArr.set(1,"789");
        list.addAll(newArr);
        //list.addAll(1,newArr);
        list.size();
        System.out.println(list.contains("123"));
        System.out.println(list.get(1)) ; // arr[1]
        System.out.println("____");

        for(String s : list){
            System.out.println(s);
        }

        ArrayList<Integer> testList = new ArrayList<>();

        //Set
        System.out.println("______SET_____");
        Set set = new HashSet();
        Set<String> setStr = new HashSet<>();
        setStr.add("123");
        setStr.add("123");
        setStr.add("123");
        setStr.add("123");
        System.out.println(setStr.size());
        System.out.println("______");
        TreeSet<Integer> sortSet = new TreeSet<>();
        sortSet.add(10);
        sortSet.add(1);
        sortSet.add(5);

        for(Integer number : sortSet){
            System.out.println(number);
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("a",123);
        map.put("b",456);
        map.put("c",789);

        System.out.println("____MAP_____");
        for(String key : map.keySet()){
            System.out.println("Key là : "+ key + " value : "+map.get(key));
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("Key là : "+ entry.getKey() + " value : "+ entry.getValue());
        }
//        for(Integer a : map.values()){
//            System.out.println(a);
//        }

        Student s1 = new Student("h1",10,5);
        Student s2 = new Student("h2",5,15);
        Student s3 = new Student("h3",4,51);
        Student s4 = new Student("h4",15,25);

        System.out.println("____ SORT List Object");
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });

        Collections.sort(studentList);

        for(Student s : studentList){
            System.out.println(s.toString());
        }


        String checkStr = "abcaacd";
        Map<Character,Integer> countMap = new HashMap<>();

        for(int i = 0; i <checkStr.length() ; i++){
            Character key = checkStr.charAt(i);
            if(countMap.containsKey(key)){
                countMap.put(key,countMap.get(key) + 1 );
            }else{
                countMap.put(key,1);
            }
        }

        for(Map.Entry<Character,Integer> entry : countMap.entrySet()){
            System.out.println("Key là : "+ entry.getKey() + " value : "+ entry.getValue());
        }

    }
}
