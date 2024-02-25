class SharedArray {
    private int[] array;
    private boolean filled = false;

    public synchronized void setArray(int[] array) {
        while (filled) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.array = array;
        filled = true;
        notifyAll();
    }

    public synchronized int[] getArray() {
        while (!filled) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        filled = false;
        notifyAll();
        return array;
    }
}

class FillerThread implements Runnable {
    private SharedArray sharedArray;

    public FillerThread(SharedArray sharedArray) {
        this.sharedArray = sharedArray;
    }

    @Override
    public void run() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        sharedArray.setArray(array);
    }
}

class PrinterThread implements Runnable {
    private SharedArray sharedArray;

    public PrinterThread(SharedArray sharedArray) {
        this.sharedArray = sharedArray;
    }

    @Override
    public void run() {
        int[] array = sharedArray.getArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class Task3 {
    public static void main(String[] args) {
        SharedArray sharedArray = new SharedArray();
        Thread fillerThread = new Thread(new FillerThread(sharedArray));
        Thread printerThread = new Thread(new PrinterThread(sharedArray));
        fillerThread.start();
        printerThread.start();
    }
}
