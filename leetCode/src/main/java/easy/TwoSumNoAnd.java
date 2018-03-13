package easy;

/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 *
 * 异或做加法（0,1）（1,0）为1
 * 位运算与 判断需要进位的位置（1,1）为1
 * 位移运算 进行进位
 * @author hdd
 */
public class TwoSumNoAnd {
    public static void main(String[] args){
        System.out.println(aplusb(3,2));
    }


    private static int aplusb(int a, int b){
        int a1,b1;
        while (a!=0 && b !=0){
            a1 = a ^ b;
            b1 = (a & b) << 1;

            a = a1;
            b = b1;
        }
        return a!=0 ? a:b;
    }
}
