/**
 * @author yangyingbao
 * @description
 * @date 2018/2/14 014
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;

        for (int i = 0; i < 50; i++) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }


}
