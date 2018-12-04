package medium;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName ListSort
 * @Description TODO
 * @Author Satan
 **/
public class ListSort <E>{
    List<E> sort(List<E> list){
        if(list.get(0) instanceof BigDecimal){
            Collections.sort(list, new Comparator<E>() {
                @Override
                public int compare(E o1, E o2) {
                    return ((BigDecimal)o1).compareTo((BigDecimal)o2);
                }
            });
        }
        return list;
    }
}
