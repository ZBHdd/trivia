package demo;

/**
 * @ClassName Thread1
 * @Description TODO
 * @Author Satan
 **/
public class Thread1 extends Thread {
    @Override
    public void run() {
        Integer a = 1;
        synchronized(a){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(++a);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        Thread1 thread3 = new Thread1();

        Long l = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();

//        thread1.join();
//        thread2.join();
//        thread3.join();
//
//        System.out.println(System.currentTimeMillis() - l);
    }
}
