package easy;

import java.util.Scanner;

/**
 * @ClassName FactorAcquisition
 * @Description TODO
 * @Author Administrator
 **/
public class FactorAcquisition {
    public static void main(String[] args) {
        Scanner reader=new Scanner(System.in);
        long l = reader.nextLong();
        if(l<2)
        {
            reader.close();
            return ;
        }
        System.out.println(getFactor(l));
        reader.close();
    }

    public static String getFactor(Long l) {
        if (l == null) {
            return "";
        }
        Long num = l;

        StringBuilder sb = new StringBuilder();
        for (long i = 2; i < l; i++) {
            while (true) {
                Long quotient = isFactor(num, i);
                if (quotient.compareTo(num) < 0) {
                    sb.append(i).append(" ");
                    num = quotient;
                }else {
                    break;
                }
            }
        }
        if("".equals(sb.toString())){
            sb.append(l.toString());
        }
        return sb.toString();
    }

    /*

     */
    private static Long isFactor(Long num, long i) {
        long remainder = 0L;
        remainder = num % i;
        if (remainder == 0L) {
            num = num / i;
            return num;
        }else {
            return num;
        }
    }

}
