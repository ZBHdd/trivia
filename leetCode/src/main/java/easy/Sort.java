package easy;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Description TODO
 * @Author Satan
 **/
public class Sort {

    public static void main(String[] args){
        Arrays.stream(selectSort(new int[]{1,3,5,11,7})).forEach(System.out::println);
    }

    public static int[] bubbleSort(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectSort(int[] array) {
        int min,temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }

    public static int[] insertSort(int[] array) {
        int preIndex,current;
        for (int i = 1; i < array.length; i++) {
            preIndex = i - 1;
            current = array[i];
            while (preIndex >= 0 && array[preIndex] > current){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
