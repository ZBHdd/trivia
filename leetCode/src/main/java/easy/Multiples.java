package easy;

/**
 * @ClassName Multiples
 * @Description project euler
 * @Author Satan
 **/
public class Multiples {
    /**
     * Multiples of 3 and 5
     */
    public static void multiples() {
        int n = 1000;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    /**
     * Even Fibonacci numbers
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 0;
        int n = 4000000;
        long sum = b;
        while (b < n){
            c = a + b;
            a = b;
            b = c;
            if(c % 2 == 0){
                sum += c;
            }
        }
        System.out.println(sum);
    }

}
