package Patterns;
/** Good Technique */
public class ForLoop {
    public static void main(String[] args) {
        int n = 10;

        for(int i=0;i<n;i++){
            for(int j=0;j<n ; j++){
                //B
                if(j==0 || i ==(n-1)/2 && j < n-1 || i == 0 && j < n-1 || i == n-1 && j < n-1 || j == n-1 && i > 0 && i < n-1 && i != (n-1)/2  )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("     ");

            for(int j=0;j<n ; j++){
                //A
                if(j == 0 && i > 0 || j == n-1 && i > 0 || i ==(n-1)/2 || i == 0 && j > 0 && j <n-1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");

            for(int j=0;j<n ; j++){
                //E
                if(j == 0 || i == (n-1)/2 || i ==0 || i == n-1 )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            for(int j=0;j<n ; j++){
                //N
                if(j == 0 || j == n-1 || j == i )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            for(int j=0;j<n ; j++){
                //x
                //if(j == n-1-i || j == i )
                if(i+j == n-1 || j == i )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            for(int j=0;j<n ; j++){
                //Z
                if(i == 0 || i+j == n-1 || i == n-1 )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            for(int j=0;j<n ; j++){
                //K
                //if(j == 0 || i+j == (n-1)/2 + 1 || i == j && i > (n-1)/2 )
                //if(j == 0 || j > (n-1)/2 && i + j == n-1 || i > (n-1)/2 && i == j)
                if(j == 0 || i + j == (n-1)/2 || i - j == (n-1)/2 )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            for(int j=0;j<n ; j++){
                //C
                if(i == 0 && j > 0 || i == n-1 && j > 0 || j == 0 && i > 0 && i < n-1 )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");

            for(int j=0;j<n ; j++){
                //M
                if(j == 0  || j == n-1 || i == j && i < (n-1)/2 || i + j == n - 1 && i < (n-1)/2  )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.print("     ");
            n=10;
            for(int j=0;j<n ; j++){
                //Y
                if(i + j == n-1 || i == j && i <= (n-1)/2  )
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
        System.out.println();

        for(int i=0;i<n;i++){
        //square or Frame
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0 || i == n-1 || j == n-1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("  ");
            //diagonals
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0 || i == n-1 || j == n-1 || i == j || i + j == n - 1){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("    ");
            //observe the values to generate the / line, try sometime how i and j varies
            //made home accidentally
            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2 || j-i == (n-1)/2 || i > (n-1)/2){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("  ");

            //observe the values to generate the / line, try sometime how i and j varies
            //one more lmao
            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2 || j-i == (n-1)/2 || i > (n-1)/2 && i + j == n-1 || i > (n-1)/2 && i == j){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("  ");

            //observe the values to generate the / line, try sometime how i and j varies
            n=11;
            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2 || j-i == (n-1)/2 || i > (n-1)/2 && i + j == n-1 || i > (n-1)/2 && i == j){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("  ");

            System.out.println();
        }

        System.out.println();

        for(int i=0;i<n;i++){

            //Diamond

            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2 || i - j == (n-1)/2 || j - i == (n-1)/2 || i + j == n-1 + (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("  ");

            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2 || j - i == (n-1)/2 || i == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }


            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i < (n-1)/2 && i + j >= (n-1)/2 && j < (n-1)/2  || j - i == (n-1)/2 || i == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }


            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i + j == (n-1)/2  || i < (n-1)/2 && j - i <= (n-1)/2 && j>(n-1)/2 || i == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i < (n-1)/2 && i + j >= (n-1)/2 && j<=(n-1)/2  || i < (n-1)/2 && j - i <= (n-1)/2 && j>=(n-1)/2 || i == (n-1)/2 ){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }


            System.out.println();

        }

        System.out.println();

        for(int i=0;i<n;i++){

            for(int j=0;j<n;j++){
                if(j==0 || i == n-1 || i == j){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(j==0 || i == n-1 || i >= j){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i+j >= (n-1)/2 && i < (n-1)/2 && j <(n-1)/2 || j-i == (n-1)/2 || i +j == (n-1)+(n-1)/2 || i-j == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i+j == (n-1)/2  || j-i <= (n-1)/2 && i <(n-1)/2 && j>(n-1)/2 || i +j == (n-1)+(n-1)/2 || i-j == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i+j == (n-1)/2  || j-i == (n-1)/2|| i + j <= (n-1)+(n-1)/2 && i >(n-1)/2 && j>(n-1)/2 || i-j == (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i+j == (n-1)/2  || j-i == (n-1)/2|| i + j == (n-1)+(n-1)/2  || i-j <= (n-1)/2 && i>(n-1)/2 && j<(n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");
            //Diamond Filled
            for(int j=0;j<n;j++){
                if(i+j >= (n-1)/2 && i <= (n-1)/2 && j <=(n-1)/2 ||
                        j-i <= (n-1)/2 && i <(n-1)/2 && j>(n-1)/2 ||
                        i + j <= (n-1)+(n-1)/2 && i>=(n-1)/2 && j>=(n-1)/2  ||
                        i-j <= (n-1)/2 && i>(n-1)/2 && j<(n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");



            System.out.println();
        }
        System.out.println();

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (!(i + j >= (n - 1) / 2 && i <= (n - 1) / 2 && j <= (n - 1) / 2 ||
                        j - i <= (n - 1) / 2 && i <= (n - 1) / 2 && j >= (n - 1) / 2 ||
                        i + j <= (n - 1) + (n - 1) / 2 && i >= (n - 1) / 2 && j >= (n - 1) / 2 ||
                        i - j <= (n - 1) / 2 && i >= (n - 1) / 2 && j <= (n - 1) / 2)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.print("   ");

            for(int j=0;j<n;j++){
                if(i+j <= (n-1)/2 && i <= (n-1)/2 && j <=(n-1)/2 ||
                        j-i >= (n-1)/2 && i <(n-1)/2 && j>(n-1)/2 ||
                        i + j >= (n-1)+(n-1)/2 && i>=(n-1)/2 && j>=(n-1)/2  ||
                        i-j >= (n-1)/2 && i>(n-1)/2 && j<(n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("   ");


            for(int j=0;j<n;j++){
                if(i == 0 ||i <(n-1)/2 && i == j || i + j == n-1 && j >= (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.print("   ");


            for(int j=0;j<n;j++){
                if(i == 0 ||i <(n-1)/2 && i <= j && j<(n-1)/2 || i + j <= n-1 && j >= (n-1)/2){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }

            System.out.println();
        }






    }
}
