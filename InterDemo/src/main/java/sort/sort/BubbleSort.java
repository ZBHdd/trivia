package sort.sort;

import sort.Sort;
import sort.SortType;
import sort.SortUtils;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author Satan
 **/
public class BubbleSort implements Sort {
    /**
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * @param arr 需要排序的数组
     * @return 已排序的数组
     */
    @Override
    public int[] sort(int[] arr , SortType type) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++){
                if (type.isValue() ^ (arr[j] > arr[j+1])) {
                    SortUtils.swapByXOR(arr,j,j+1);
                }
            }
        }
        return arr;
    }
}
