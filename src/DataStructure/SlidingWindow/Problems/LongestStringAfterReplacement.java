package DataStructure.SlidingWindow.Problems;

import java.util.Arrays;

public class LongestStringAfterReplacement {

    public static void main(String[] args) {
        System.out.println(longestStringAfterKReplacement("ABCDDDFFG",3));
        System.out.println(longestStringAfterKReplacement("AAABBCCD",2));
    }

    public static int longestStringAfterKReplacement(String s,int k){
        int[] hash = new int[26];
        int l=0,r=0,maxF=0,maxL=0;
        while(r < s.length()){
            hash[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, Arrays.stream(hash).max().getAsInt());
            //IMP: Here we are subtracting the length - Maximum frequency as they come from same Alphabet and you don't need to replace them
            // changes = r-l+1 - maxF
            //consider AAABBC k = 2 , here the 6-3 > k we are considering only 2 for changes with additional AAA(same element)
            if(r-l+1 - maxF <=k ){
                maxL = Math.max(r-l+1,maxL);
            }else{
                hash[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return maxL;
    }
}
