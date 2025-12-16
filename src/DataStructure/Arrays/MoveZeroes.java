package DataStructure.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        //2 Pointers i keep tracks of Non Zero and other j tracks Zero, swaps when condition true
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0 && nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

            if (nums[j] != 0) {
                j++;
            }

            i++;

        }

    }

    /**
     * We keep track of last 0 index, and put the value of latest non zero we found in the array.
     * 0 1 0 3 12 (i=0) (id=0)
     * 1 1 0 3 12 (i=1) (id=1)
     * 1 1 0 3 12 (i=2) (id=1)
     * 1 3 0 3 12 (i=3) (id=2)
     * 1 3 12 3 12 (=4) (id=3)
     * <p>
     * At lastZeroIndex (id3) last zero appeared so we can start filing zero from that index onwards
     */
    public void moveZeroesOPT(int[] nums) {
        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastZeroIndex++] = nums[i];
            }
        }

        for (int i = lastZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroesOPT2(int[] nums) {
        for (int i = 0, lastIndexZero = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastIndexZero];
                nums[lastIndexZero] = temp;
                lastIndexZero++;
            }
        }
    }


}
