package sort;

/**
 * @author Administrator
 */
public interface Sort {
    /**
     * 排序
     * @param arr 需要排序的数组
     * @return 已排序的数组
     */
    int[] sort(int[] arr , SortType type);
}
