package thread;

import java.util.Arrays;

public class Interrupt2Thread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Long num = 0L;
            while (true) {
                num++;
                Interrupt3Thread.testMap(num);
            }
        });

        Thread b = new Thread(new Runnable() {
            Thread t;

            public Runnable setT(Thread t) {
                this.t = t;
                return this;
            }

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5 * 1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t.interrupt();
                    System.out.println(String.format("{%s} interrupt,thread status {%s}", t.getName(), t.getState()));
                    Arrays.stream(t.getStackTrace()).forEach(s -> System.out.println(s.toString()));
                }
            }
        }.setT(t));

        t.start();
        b.start();
    }
}
