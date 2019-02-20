package sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sort.sort.BubbleSort;
import sort.sort.InsertSort;
import sort.sort.SelectSort;

import java.util.Arrays;

public class SortTest {
    private int[] arr = new int[]{8,5,6,7,9,3,1,2,4,6};
    private Sort sort;
    private SortType type;

    @Before
    public void before() {
        arr = new int[]{8,5,6,7,9,3,1,2,4,6};
        type = SortType.DESC;
    }

    @After
    public void after(){
        sort.sort(arr , type);
        Assert.assertTrue("数组没有排序成功，"+Arrays.toString(arr),
                SortUtils.checkSort(arr, type));
    }

    @Test
    public void bubbleSort() {
        sort = new BubbleSort();
    }

    @Test
    public void insertSortTest() {
        sort = new InsertSort();
    }

    @Test
    public void selectSortTest() {
        sort = new SelectSort();
    }
}