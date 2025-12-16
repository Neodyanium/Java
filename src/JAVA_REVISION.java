
import OtherPackage.Utility;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class Customer {
    Customer() {
        System.out.println("Parent Constructor");
    }
}

class Custom extends Customer {
    Custom() {
        System.out.println("Child Constructor");
    }

    public static void main(String[] args) {
        Custom c = new Custom();
    }
}

abstract class Person {
    String name;

    final void create(String name) {
        this.name = name;
    }

    void info() {
        System.out.println("My name is :" + name);
    }
}

class Man extends Person {
    void create(String name, int age) {
        this.name = name;
    }
}

public class JAVA_REVISION {
    String s = "Hello";
    static int i = 20;
    Thread t;

//    public static void sort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        print(arr);
//    }

    //0 1 2 3 4 5 6 7
    public static void main(String[] args){
        Comparator<Integer> MyComparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                if(i1 > i2) return i2-i1;
                else if(i1 < i2) return i2-i1;
                return 0;
                }
        };

        TreeSet<Integer> t = new TreeSet<>(MyComparator);
        t.add(4);
        t.add(1);
        t.add(5);
        t.add(9);
        t.add(6);
        System.out.println(t);

    }




}







//    Second Highest
//    int[] array = {21,45,32,65,91,69};
//    int highest=Integer.MIN_VALUE;
//    int secondHighest=Integer.MIN_VALUE;
//        for(int n:array){
//                if(n > highest){
//                secondHighest=highest;
//                highest=n;
//                }
//                else if(n > secondHighest){
//                secondHighest=n;
//                }
//                }
//                System.out.println("Second Highest");
//Palindrome
//
//    String input = "NAYAN";
//        if (input.equals(reverse(input))) {
//                System.out.println("PaLiNDRoMe");
//                } else {
//                System.out.println("NOT PALINDROME");
//                }
//                }
//
//public static String reverse(String input) {
//        String result = "";
//        for (int i = input.length() - 1; i >= 0; i--) {
//        result += input.charAt(i);
//        }
//        return result;
//        }
//    //Swap Numbers
//    Scanner in = new Scanner(System.in);
//    int n1= in.nextInt();
//    int n2= in.nextInt();
//        System.out.println("Number1="+n1+" Number2="+n2);
////        L2
////        n1 = n1 ^ n2;
////        n2 = n1 ^ n2;
////        n1 = n1 ^ n2;
////        4- 0100 (n1)
////        3- 0011 (n2)
////        --------
////           0111(r)--------
////        0111(r)
////        0011(n2)
////        -----
////        0100(r-n1)
////        ----------
////        0111(r)
////        0100(n1)
////        --------
////        0011(r-n2)
////        L1
////        n1=n1+n2;
////        n2=n1-n2;
////        n1=n1-n2;
//                System.out.println("Number1="+n1+" Number2="+n2);
//Fibonacii
//public static void main(String[] args) {
//    int count=10;
//
//    for(int i=0;i<count;i++){
//        System.out.print(fibonacci(i) + " ");
//    }
//}
//
//    public static int fibonacci(int count) {
//        if(count<=0)
//            return -count;
//        return fibonacci(count-1) + fibonacci(count-2);
//
//    }

//    int[] arr = {3, 54, 64, 75, 685, 423, 65, 7, 86, 4};
//        Arrays.sort(arr);
//                System.out.print("Here's your Array:");
//                for (int n : arr
//                ) {
//                System.out.print(n+" ");
//                }
//                System.out.println("\nEnter your key:");
//                Scanner in = new Scanner(System.in);
//                int key = in.nextInt();
//                int l = 0, r = arr.length-1;
//                while (l <= r) {
//                int m = (l + r) / 2;
//                if (key == arr[m]) {
//                System.out.println("Found the element at index:" + m);
//                break;
//                } else if (key > arr[m]) {
//                l = m + 1;
//                } else {
//                r = m - 1;
//                }
//                }

//    int[] arr = {23,42,10,78,32};
//    int largest=0;
//        for(int i=0;i<arr.length;i++){
//        if(largest < arr[i]){
//            largest=arr[i];
//        }
//    }
//        System.out.println(largest);
//}
//    int[] arr = {300,100,200,400,500};
//        for(int i =0;i<arr.length;i++){
//        for(int j=i+1;j<arr.length;j++){
//        if(arr[i]>arr[j]){
//        int temp=arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//        }
//        }
//        break;
//        }
//        System.out.println(arr[0]);

//    Scanner in = new Scanner(System.in);
//    String s = in.nextLine();
//        System.out.println("Entered String:"+s);
//                char[] arr = s.toCharArray();
//                int right = arr.length-1;
//                for(int i=0;i<arr.length/2;i++){
//        char temp = arr[right-i];
//        arr[right-i] = arr[i];
//        arr[i]=temp;
//        }
//        System.out.println(new String(arr));
//        }


//    int[] arr = {5, 7, 81, 3, 4};
//        for (int i = 0; i < arr.length; i++) {
//        for (int j = i+1; j < arr.length; j++) {
//            if (arr[i] > arr[j]) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//    }
//        for(int n:arr){
//        System.out.print(n+ " ");
//    }
//}