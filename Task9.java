import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Order {
    private final int id;
    private final List<String> dishes;

    public Order(int id, List<String> dishes) {
        this.id = id;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public List<String> getDishes() {
        return dishes;
    }
}

class OrderQueue {
    private final ConcurrentLinkedQueue<Order> orders;
    private final ReentrantLock lock;
    private final Condition orderAvailable;

    public OrderQueue() {
        this.orders = new ConcurrentLinkedQueue<>();
        this.lock = new ReentrantLock();
        this.orderAvailable = lock.newCondition();
    }

    public void addOrder(Order order) {
        lock.lock();
        try {
            orders.add(order);
            orderAvailable.signal();
        } finally {
            lock.unlock();
        }
    }

    public Order takeOrder() throws InterruptedException {
        lock.lock();
        try {
            while (orders.isEmpty()) {
                orderAvailable.await();
            }
            return orders.poll();
        } finally {
            lock.unlock();
        }
    }
}

class Chef implements Runnable {
    private final OrderQueue orderQueue;

    public Chef(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = orderQueue.takeOrder();
                System.out.println("Chef " + Thread.currentThread().getId() + " is processing order " + order.getId());
                Thread.sleep(1000);
                System.out.println("Chef " + Thread.currentThread().getId() + " finished processing order " + order.getId());
            }
        } catch (InterruptedException e) {
            System.out.println("Chef " + Thread.currentThread().getId() + " was interrupted");
        }
    }
}

class Waiter implements Runnable {
    private final OrderQueue orderQueue;

    public Waiter(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Order order = orderQueue.takeOrder();
                System.out.println("Waiter " + Thread.currentThread().getId() + " is delivering order " + order.getId());
                Thread.sleep(1000);
                System.out.println("Waiter " + Thread.currentThread().getId() + " finished delivering order " + order.getId());
            }
        } catch (InterruptedException e) {
            System.out.println("Waiter " + Thread.currentThread().getId() + " was interrupted");
        }
    }
}

public class Task9 {
    public static void main(String[] args) {
        OrderQueue orderQueue = new OrderQueue();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Chef(orderQueue));
        }

        for (int i = 0; i < 2; i++) {
            executorService.submit(new Waiter(orderQueue));
        }

        for (int i = 0; i < 10; i++) {
            Order order = new Order(i, Arrays.asList("dish1", "dish2", "dish3"));
            orderQueue.addOrder(order);
        }

        executorService.shutdown();
    }
}