import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = prepareHorsesAndStart(10);
        while (calculateHorsesFinished(horses) != horses.size()) {
            System.out.println("Waiting for all horses to finish...");
        }
        System.out.println("All horses have finished!");
    }

    public static int calculateHorsesFinished(List<Horse> horses) throws InterruptedException {
        int finishedCount = 0;
        while (finishedCount < horses.size()) {
            for (int i = 0; i < horses.size(); i++) {
                Horse horse = horses.get(i);
                if (!horse.isFinished()) {
                    System.out.println("Waiting for " + horse.getName() + " to finish...");
                    horse.join();
                }
                if (horse.isFinished()) {
                    finishedCount++;
                }
            }
        }
        return finishedCount;
    }

    public static List<Horse> prepareHorsesAndStart(int horseCount) {
        List<Horse> horses = new ArrayList<>(horseCount);
        for (int i = 1; i <= horseCount; i++) {
            horses.add(new Horse("Horse_" + i));
            horses.get(i - 1).start();
        }
        return horses;
    }

    public static class Horse extends Thread {

        private boolean isFinished;

        public Horse(String name) {
            super(name);
            this.isFinished = false;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void run() {
            System.out.println(getName() + " is running...");
            // Simulate horse running for a random amount of time between 1 and 10 seconds
            try {
                Thread.sleep((long) (Math.random() * 9000 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " has finished!");
            this.isFinished = true;
        }
    }
}