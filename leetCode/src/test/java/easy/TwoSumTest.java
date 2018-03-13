package easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {

    private TwoSum twoSum = new TwoSum();
    private int[] num = new int[]{3,2,4};
    private int target = 6;

    @Test
    void twoSum() {
        System.out.println(Arrays.toString(twoSum.twoSum(num, target)));
    }

    @Test
    void twoSum2() {
        System.out.println(Arrays.toString(twoSum.twoSum2(num, target)));
    }

    @Test
    void twoSum3() {
        System.out.println(Arrays.toString(twoSum.twoSum3(num, target)));
    }

    @Test
    void twoSum4() {
        System.out.println(Arrays.toString(twoSum.twoSum4(num, target)));
    }
}