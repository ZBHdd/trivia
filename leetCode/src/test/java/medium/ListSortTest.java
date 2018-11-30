package medium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ListSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 7, 2018</pre>
 */
public class ListSortTest {

    List<BigDecimal> list = new ArrayList<>();
    ListSort<BigDecimal> listSort = new ListSort<>();
    @Before
    public void before() throws Exception {
        list.add(new BigDecimal(1));
        list.add(new BigDecimal(8));
        list.add(new BigDecimal(6));
        list.add(new BigDecimal(9));
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sort(List<E> list)
     */
    @Test
    public void testSort() throws Exception {
        listSort.sort(list);
        for (BigDecimal bigDecimal : list) {
            System.out.println(bigDecimal);
        }
    }


} 
