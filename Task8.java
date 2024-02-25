import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class Ship {
    private int cargo;
    private int type;

    public Ship(int type, int cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public int getType() {
        return type;
    }
}

class Dock {
    private int type;
    private int loadingTime;

    public Dock(int type, int loadingTime) {
        this.type = type;
        this.loadingTime = loadingTime;
    }

    public int getType() {
        return type;
    }

    public int getLoadingTime() {
        return loadingTime;
    }
}

class ShipGenerator implements Runnable {
    private BlockingQueue<Ship> queue;
    private Semaphore semaphore;

    public ShipGenerator(BlockingQueue<Ship> queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
                Ship ship = new Ship((int) (Math.random() * 3), (int) (Math.random() * 100));
                queue.put(ship);
                System.out.println("Ship " + ship.getType() + " generated with cargo " + ship.getCargo());
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DockManager implements Runnable {
    private BlockingQueue<Ship> queue;
    private Dock[] docks;

    public DockManager(BlockingQueue<Ship> queue, Dock[] docks) {
        this.queue = queue;
        this.docks = docks;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Ship ship = queue.take();
                for (Dock dock : docks) {
                    if (dock.getType() == ship.getType()) {
                        System.out.println("Ship " + ship.getType() + " loaded on dock " + dock.getType());
                        TimeUnit.SECONDS.sleep(dock.getLoadingTime());
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Task8 {
    public static void main(String[] args) {
        BlockingQueue<Ship> queue = new ArrayBlockingQueue<>(10);
        Semaphore semaphore = new Semaphore(3);
        Dock[] docks = {new Dock(0, 2), new Dock(1, 3), new Dock(2, 4)};

        Thread generator = new Thread(new ShipGenerator(queue, semaphore));
        Thread manager = new Thread(new DockManager(queue, docks));

        generator.start();
        manager.start();

        try {
            generator.join();
            manager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}