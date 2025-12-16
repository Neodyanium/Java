package DataStructure.Arrays;
import java.util.*;
public class Union {
    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        int[] b = {2,2,2,2,2};
        findUnion(a,b);
    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int i=0,j=0;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
                if(list.isEmpty() || list.get(list.size()-1) != a[i]){
                    list.add(a[i]);
                }
                i++;;
            }else{
                if(list.isEmpty() || list.get(list.size()-1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }
        }
        while(i < a.length){
            if(list.get(list.size() -1) != a[i])
                list.add(a[i]);
            i++;

        }

        while(j < b.length ){
            if(list.get(list.size() -1) != b[j])
                list.add(b[j]);
            j++;
        }
        return list;
    }
}
