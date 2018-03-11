package easy;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] agrs){
        System.out.println(Arrays.toString(twoSum(new int[]{3,2, 4}, 6)));
    }


    private static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(target-nums[i] == nums[j]){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }
}
