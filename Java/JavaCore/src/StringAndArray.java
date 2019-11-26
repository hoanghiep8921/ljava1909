public class StringAndArray {
    public static void main(String[] args) {
        char a = ' ';
        char b = 'b';

        String str = "A bCdeF";
        System.out.println(str.length());
        System.out.println(str.toUpperCase());

        System.out.println(str.toLowerCase());
        str = "1234";
        System.out.println(str);

        String test = "1234";
        String test2 = "1234";
        String test3 = "abcd";
        String test4 = new String("1234");

        test2 ="def";
        System.out.println(test.charAt(1));

        System.out.println(test.equals(test2));
        System.out.println(test.equals(test4));
        System.out.println("__________");
        System.out.println(test == test2);
        System.out.println(test == test4);
        System.out.println("________");
        System.out.println(test.contains("1"));
        System.out.println("______");
        System.out.println(test.concat(test2));
        System.out.println(test);
        System.out.println("_______");

        String name = "HiEp";
        String name2 = "hIeP";
        System.out.println(name.equalsIgnoreCase(name2));



        String checkString =  "abcaad";
        int max = 0;
        char character = ' ';
        for(int i = 0; i<checkString.length() ; i++){

            int count = 0;

            for(int j = 0; j<checkString.length(); j++){
                if(checkString.charAt(i) == checkString.charAt(j)){
                    count ++;
                }
            }

            if(max < count){
                max = count;
                character = checkString.charAt(i);
            }
        }


        int[] numbers = new int[10];
        System.out.println(numbers[0]);
        numbers[0] = 10;
        for(int i =0 ;i < numbers.length;i++){
            numbers[i] = i;
        }

        for(int i = 0 ;i < numbers.length;i++){
            System.out.println(numbers[i]);
        }


        int[][] arr = new int[5][5];

    }




}
