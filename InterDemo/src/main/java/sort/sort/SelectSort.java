package sort.sort;

import sort.Sort;
import sort.SortType;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author Satan
 **/
public class SelectSort implements Sort {
    /**
     * 初始状态：无序区为R[1..n]，有序区为空；
     * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
     * 该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
     * 使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
     * n-1趟结束，数组有序化了。
     * @param arr 需要排序的数组
     * @return 已排序的数组
     */
    @Override
    public int[] sort(int[] arr , SortType type) {
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            for (int j = i + 1; j < arr.length; j++){
                if (type.isValue() ^ (min > arr[j])) {
                    min = min ^ arr[j];
                    arr[j] = min ^ arr[j];
                    min = min ^ arr[j];
                }
            }
            arr[i] = min;
        }
        return arr;
    }
}
