package medium;

import com.google.common.base.Joiner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MapSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十一月 6, 2018</pre>
 */
public class MapSortTest {
    private Map<String, String> map = new HashMap<>();
    private Map<String, String> map2 = new HashMap<>();
    private Map<Long, BigDecimal> map3 = new HashMap<>();
    private MapSort mapSort = new MapSort();

    @Before
    public void before() throws Exception {
        map.put("100023", "3");
        map.put("600023", "1");
        map.put("120023", "2");
        map.put("1003023", "4");
        map3.put(100023l, new BigDecimal(3));
        map3.put(120023l, new BigDecimal(2));
        map3.put(600023l, new BigDecimal(1));
        map3.put(1003023l,new BigDecimal(4));
    }

    @After
    public void after() throws Exception {
        for(Map.Entry<String,String> mapping:map2.entrySet()){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

    /**
     * Method: sortByKey(Map<String, String> map)
     */
    @Test
    public void testSortByKey() throws Exception {
        map2 = mapSort.sortByKey(map);
    }

    /**
     * Method: sortByValue(Map<String, String> map)
     */
    @Test
    public void testSortByValue() throws Exception {
        Map<Long, BigDecimal> map1 = mapSort.sortByValue(map3, 1);
        for(Map.Entry<Long, BigDecimal> mapping:map1.entrySet()){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }

    @Test
    public void test() throws Exception {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        String join = Joiner.on(",").join(list);
        System.out.println(join);
    }


} 
