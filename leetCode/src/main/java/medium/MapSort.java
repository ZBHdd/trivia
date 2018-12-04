package medium;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName MapSort
 * @Description TODO
 * @Author Satan
 **/
public class MapSort {

    public Map<String, String> sortByKey(Map<String, String> map) {
        Map<String,String> map2 = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return Integer.valueOf(obj2) - Integer.valueOf(obj1);
                    }
                });
        for(Map.Entry<String,String> mapping:map.entrySet()){
            map2.put(mapping.getKey(),mapping.getValue());
        }
        return map2;
    }

    public Map<String, String> sortByValue(Map<String, String> map) {

        List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
        //升序排序
        Collections.sort(list, Comparator.comparingInt(o -> Integer.valueOf(o.getValue())));
        Map<String,String> map2 = new LinkedHashMap<>();
        for(Map.Entry<String,String> mapping:list){
            map2.put(mapping.getKey(),mapping.getValue());
        }
        return map2;
    }

    public Map<Long, BigDecimal> sortByValue(Map<Long, BigDecimal> map , Integer type) {

        List<Map.Entry<Long,BigDecimal>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Long,BigDecimal>>() {
            //升序排序
            @Override
            public int compare(Map.Entry<Long, BigDecimal> o1,
                               Map.Entry<Long, BigDecimal> o2) {
                return type * (o1.getValue().compareTo(o2.getValue()));
            }
        });
        Map<Long,BigDecimal> map2 = new LinkedHashMap<>();
        for(Map.Entry<Long,BigDecimal> mapping:list){
            map2.put(mapping.getKey(),mapping.getValue());
        }
        return map2;
    }
}
