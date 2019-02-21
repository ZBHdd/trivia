package sort.sort;

/**
 * @ClassName demo
 * @Description
 * @Author Satan
 **/
public class Test{
    static{
        int x=5;
    }
    private static int x=1,y;
    public static void main(String[] args){
        x--;
        myMethod( );
        System.out.println(x+y+ ++x);
    }
    private static void myMethod(){
        y=x++ + ++x;
    }
}
