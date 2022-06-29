package thread;

public class InterruptThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            long num = 0;
            while (true) {
                //正常执行的时候不会打断，所以需要自己判断
                if(num++ % 1000 == 1){
                    if(Thread.interrupted()){
                        throw new RuntimeException("interrupted");
                    }
                }
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
                }
            }
        }.setT(t));

        t.start();
        b.start();
    }
}
