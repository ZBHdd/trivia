package sort;

/**
 * @ClassName SortUtils
 * @Description TODO
 * @Author Satan
 **/
public class SortUtils {
    /**
     * 位移运算交换（一个数对另一个数位异或两次，该数不变）
     *
     * @param arr 交换前的数组
     * @param a   交换下标
     * @param b   交换下标
     * @return 交换后的数组
     */
    public static int[] swapByXOR(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
        return arr;
    }

    /**
     * 数值相加减交换（先求得两数的和再进行减运算）
     *
     * @param arr 交换前的数组
     * @param a   交换下标
     * @param b   交换下标
     * @return 交换后的数组
     */
    public static int[] swapByCalculation(int[] arr, int a, int b) {
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
        return arr;
    }

    /**
     * 交换（借助中间量交换）
     *
     * @param arr 交换前的数组
     * @param a   交换下标
     * @param b   交换下标
     * @return 交换后的数组
     */
    public static int[] swapByCache(int[] arr, int a, int b) {

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }

    /**
     * 检验数组是否有逆序对
     * 默认升序
     * @param arr 待检验的数组
     * @return 检验结果
     */
    public static boolean checkSort(int[] arr) {
       return checkSort(arr,SortType.ASC);
    }

    /**
     * 检验数组是否有逆序对
     * @param arr 待检验的数组
     * @param type 排序方式
     * @return 检验结果
     */
    public static boolean checkSort(int[] arr, SortType type) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!checkPair(arr[i], arr[i + 1], type)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检验两个数是否逆序
     * @param preNum 前一个数
     * @param nextNum 后一个数
     * @param type 排序方式
     * @return 检验结果
     */
    private static boolean checkPair(int preNum, int nextNum, SortType type) {
        if(preNum > nextNum){
            return type.isValue();
        }else if(preNum < nextNum){
            return !type.isValue();
        }else {
            return true;
        }
    }
}
