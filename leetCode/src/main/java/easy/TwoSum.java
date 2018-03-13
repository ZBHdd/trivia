package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，返回这两个数字的索引，使它们合计成一个特定的目标。 1.每个输入都只有一个解决方案，2.不能使用相同的元素两次。
 * 1.蛮力法
 * 2.hash算法
 *
 * @author hdd
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(length);
        for (int i = 0; i < length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * To be determined ,don't understand this
     */
    public int[] twoSum4(int[] nums, int target) {
        int[] map = new int[20050];
        int size = 4;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = (i + 1);
            int diff = target - nums[i + 1] + size;
            if (diff < 0) {
                continue;
            }
            int d = map[diff];
            if (d > 0) {
                return new int[]{d - 1, i + 1};
            }
        }
        return null;
    }
}
