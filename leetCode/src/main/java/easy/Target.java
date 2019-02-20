package easy;

import java.util.Arrays;

/**
 * @ClassName Target
 * @Description TODO
 * @Author Satan
 **/
public class Target {
    public static void main(String[] args) {

    }

    public int closestTargetValue(int target, int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                array[i] = array[i] ^ array[i + 1];
                array[i + 1] = array[i] ^ array[i + 1];
                array[i] = array[i] ^ array[i + 1];
            }
        }
        Arrays.stream(array).forEach(System.out::println);
        return 0;
    }
}
