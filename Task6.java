import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        GoldChest chest = new GoldChest();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Filler(chest, "Filler 1"));
        executor.submit(new Filler(chest, "Filler 2"));
        executor.submit(new Filler(chest, "Filler 3"));

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total gold in the chest: " + chest.getTotalGold());
    }

    public static class GoldChest {
        private AtomicInteger gold;

        public GoldChest() {
            this.gold = new AtomicInteger(0);
        }

        public void addGold(int amount) {
            gold.addAndGet(amount);
        }

        public int getTotalGold() {
            return gold.get();
        }
    }

    public static class Filler extends Thread {
        private GoldChest chest;
        private static final Random random = new Random();

        public Filler(GoldChest chest, String name) {
            super(name);
            this.chest = chest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int amount = random.nextInt(100) + 1;
                System.out.println(Thread.currentThread().getName() + " added " + amount + " gold.");
                chest.addGold(amount);

                try {
                    Thread.sleep(random.nextInt(500) + 500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}