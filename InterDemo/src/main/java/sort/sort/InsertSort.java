package sort.sort;

import sort.Sort;
import sort.SortType;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author Satan
 **/
public class InsertSort implements Sort {

    /**
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * @param arr 需要排序的数组
     * @return 已排序的数组
     */
    @Override
    public int[] sort(int[] arr , SortType type) {
        int current,preIndex;

        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >= 0 && (type.isValue() ^ (arr[preIndex] > current))){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }
}
