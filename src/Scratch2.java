
public class Scratch2 extends Student {


    public static void println(Object s){
        System.out.println(s);
    }
    public static void main(String args[]) {



    }
    public static double sqrt(double a){
        return Math.sqrt(a);
    }












//    ArrayList al = new ArrayList();

//    if(x.length == 2){
//        label
//    }




        //        int y = 128;
//        byte x = (byte)y;
////        int b,c,d;
//        int a=b=c=d=10;
//        System.out.println(x);

//        boolean x = Double.NaN != Double.NaN;



        /**
         * Armstrong Number
         *         int temp,n = 153,digits=0,sum=0;
         *         temp=n;
         *         while(temp>0){
         *             temp = temp/10;
         *             digits++;
         *         }
         *         temp = n;
         *         while(temp>0){
         *             int last = temp %10;
         *             sum += (int) (Math.pow(last,digits));
         *             temp = temp/10;
         *         }
         *         if(sum==n)
         *             System.out.println("Yes");
         *         else
         *             System.out.println("No");
         *     --------------------------------------
         *     Static Block
         *      {
         *             int x =12;
         *             System.out.println(x);
         *      }
         */
//        Scanner read = new Scanner(System.in);
//        int T = read.nextInt();
//        while(T-- > 0){
//            int pair1 = read.nextInt();
//            int pair2 = read.nextInt();
//            int f1 = read.nextInt();
//            int f2 = read.nextInt();
//            int f3 = read.nextInt();
//            int f4 = read.nextInt();
//            if(f1 == pair1 || f2 == pair2)
//                System.out.println(1);
//            else if(f3 == pair1 || f4 == pair2)
//                System.out.println(2);
//            else
//                System.out.println(0);
//
//        }
//        int p1 = 1;
//        int p2 = 2;
//        int f1 = 2;
//        int f2 = 1;
//        if ((p1 == f1 || p1 == f2) && (p2 == f1 || p2 == f2)) {
//            System.out.println("True");
//        }
//        Scanner read = new Scanner(System.in);
//        int T = read.nextInt();
//        while(T-- > 0){
//            int p1 = read.nextInt();
//            int p2 = read.nextInt();
//            int f1 = read.nextInt();
//            int f2 = read.nextInt();
//            int f3 = read.nextInt();
//            int f4 = read.nextInt();
//            if((p1 == f1 || p1 == f2) && (p2 == f1 || p2 == f2)){
//                System.out.println(1);
//                break;
//            }
//            else if((p1 == f3 || p1 == f4) && (p2 == f3 || p2 == f4)){
//                System.out.println(2);
//                break;
//            }
//            else{
//                System.out.print(0);
//                break;
//            }
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        while (T-- > 0) {
//            String var = "";
//            int n = in.nextInt();
//            //fixed 1s and var 0s
//            //You can also do 1 at start and end all between 0
//            if(n % 2 != 0){
//                for(int i=0;i<n/2;i++){
//                    var = var + "1";
//                }
//                var= var + "0";
//                for(int i=0;i<n/2;i++){
//                    var = var + "1";
//                }
//            }
//            else{
//                for(int i=0;i<n/2-1;i++){
//                    var = var + "1";
//                }
//                var= var + "00";
//                for(int i=0;i<n/2-1;i++){
//                    var = var + "1";
//                }
//
//            }
//            System.out.println(var);
//        }
//        Scanner scn = new Scanner(System.in);
//        int T = scn.nextInt();
//        while(T-- > 0) {
//            int dolls = scn.nextInt();
//            Map<Integer, Integer> res = new HashMap<>();
//            for (int i = 0; i < dolls; i++) {
//                int type = scn.nextInt();
//                if (!res.containsKey(type)) {
//                    res.put(type, 1);
//                    continue;
//                }
//                res.computeIfPresent(type, (k, v) -> v + 1);
//            }
//            for(int i: res.keySet()){
//                if(res.get(i) % 2 != 0){
//                    System.out.println(i);
//                }
//            }
//        }
//        final int String = 999;
//        String = 42;
//        Scanner scn = new Scanner(System.in);
//        int T = scn.nextInt();
//        boolean ind = false;
//        while(T-- > 0) {
//            int size = scn.nextInt();
//            String seq = scn.next();
//            String arr = "";
//            for (int i = 0; i < size; i++) {
//                if (seq.charAt(i) == '.')
//                    continue;
//                else
//                    arr = arr + seq.charAt(i);
//            }
//            for(int i=0;i<size;i++){
//                if(seq.chatAt(i) == '.')
//                    continue;
//                else if(seq.charAt(i) == 'H'){
//
//                }
//                else if(seq.charAt(i)=='T'){
//                    System.out.println("Invalid");
//                    break;
//                }
//            }
//
//        }
//        Scanner scn = new Scanner(System.in);
//        int T = scn.nextInt();
//        while(T-- > 0){
//            boolean ind = true;
//            boolean comp = false;
//            int size = scn.nextInt();
//            String seq = scn.next();
//
//            for(int i=0;i<size;i++){
//                if(seq.charAt(i) == '.')
//                    continue;
//                else if(seq.charAt(i) == 'H'){
//                    if(i == size-1 && seq.charAt(i) != 'T'){
//                        System.out.println("Invalid");
//                        ind = false;
//                        break;
//                    }
//                    i++;
//                    while(seq.charAt(i) != 'T'){
//                        if(seq.charAt(i) == '.')
//                            i++;
//                        else if(seq.charAt(i) == 'H'){
//                            System.out.println("Invalid");
//                            ind = false;
//                            comp=true;
//                            break;
//                        }
//                    }
//                    if(comp)
//                        break;
//                }
//                else if(seq.charAt(i)=='T'){
//                    System.out.println("Invalid");
//                    ind = false;
//                    break;
//                }
//            }
//            if(ind)
//                System.out.println("Valid");
//        }
//        byte b = -128;
//        long a = 0xf;
//        float f = 12345l;
//        int String = 12;
//        String[] x = new String[2147483647];
//        System.out.println(Integer.MAX_VALUE);
//        Integer n = 4;
//        int num =5;
//        int l = num+n;
//        int[][] arr = new int[4][3];
//        arr[0] = new int[3];
//        arr[1] = new int[4];
//        arr = new int[3][2];


}
