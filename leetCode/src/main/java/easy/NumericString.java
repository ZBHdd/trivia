package easy;

import java.util.*;

/**
 * @ClassName NumericString
 * @Description 设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
 *              如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
 *              如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
 * @Author Satan
 **/
public class NumericString {
    public static void main(String[] args){
        Scanner san = new Scanner(System.in);
        int n = san.nextInt();
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(san.nextInt());
            n--;
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.valueOf(""+o1+o2) + Integer.valueOf(""+o2+o1);
            }
        });
        list.forEach(System.out::print);
    }

}
