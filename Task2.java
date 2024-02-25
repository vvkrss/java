class PrintThread extends Thread {
    private String name;
    private int repetitions;

    public PrintThread(String name, int repetitions) {
        this.name = name;
        this.repetitions = repetitions;
    }

    public void run() {
        for (int i = 0; i < repetitions; i++) {
            System.out.println("Thread " + name + " repeating: " + i);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide the number of threads and their repetitions as command-line arguments.");
            return;
        }

        int numThreads = Integer.parseInt(args[0]);
        int[] repetitions = new int[numThreads];

        for (int i = 0; i < numThreads; i++) {
            if (i + 1 > args.length - 1) {
                System.out.println("Please provide a repetition count for each thread as command-line arguments.");
                return;
            }
            repetitions[i] = Integer.parseInt(args[i + 1]);
        }

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new PrintThread("Thread " + (i + 1), repetitions[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}