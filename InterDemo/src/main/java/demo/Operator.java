package demo;

/**
 * @ClassName d
 * @Description TODO
 * @Author Satan
 **/
public enum Operator {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    };

    public abstract int apply(int a, int b);

}

class Demo{
    public static void main(String[] args){
        System.out.println(Operator.valueOf("ADD").apply(1,2));
    }
}
