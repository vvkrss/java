public class Task4 {
    private static class PrintThread extends Thread {
        private int start, end;
        static Object lock = new Object();

        public PrintThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notifyAll();                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintThread oddThread = new PrintThread(1, 10);
        PrintThread evenThread = new PrintThread(2, 10);

        oddThread.start();
        evenThread.start();
    }
}