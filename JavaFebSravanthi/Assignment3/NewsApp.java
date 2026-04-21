package Assignment3;

// 1. NewsDownloader class implementing Runnable
class NewsDownloader implements Runnable {

    private String sourceName;
    private int    delaySeconds;

    // Constructor
    public NewsDownloader(String sourceName, int delaySeconds) {
        this.sourceName   = sourceName;
        this.delaySeconds = delaySeconds;
    }

    // 2. run() — the code each thread executes
    @Override
    public void run() {
        System.out.println("Downloading from: " + sourceName + "...");

        try {
            Thread.sleep(delaySeconds * 1000L);   // simulate download delay
        } catch (InterruptedException e) {
            System.out.println(sourceName + " was interrupted!");
            Thread.currentThread().interrupt();   // restore interrupted status
        }

        System.out.println(sourceName + " download complete!");
    }
}

public class NewsApp {

    public static void main(String[] args) {

        // 3. Create three Thread objects with NewsDownloader
        Thread bbcThread     = new Thread(new NewsDownloader("BBC",     2));
        Thread cnnThread     = new Thread(new NewsDownloader("CNN",     1));
        Thread reutersThread = new Thread(new NewsDownloader("Reuters", 3));

        // Give each thread a name
        bbcThread    .setName("BBC-Thread");
        cnnThread    .setName("CNN-Thread");
        reutersThread.setName("Reuters-Thread");

        // 4. Start all three threads simultaneously
        bbcThread    .start();
        cnnThread    .start();
        reutersThread.start();

        // 5. main() waits for all threads to finish
        try {
            bbcThread    .join();
            cnnThread    .join();
            reutersThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted!");
            Thread.currentThread().interrupt();
        }

        // 6. Prints only after ALL threads complete
        System.out.println("\nAll articles downloaded. App is ready!");
    }
}