package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// https://www.java67.com/2012/12/producer-consumer-problem-with-wait-and-notify-example.html
class Data {
    static final int maxSize = 5;
    private final List<String> dataList = new ArrayList<>();

    public synchronized void produce(String item) {

        while (dataList.size() >= maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }

        dataList.add(item);
        notifyAll();
    }

    public synchronized String consume() {
        while (dataList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        String removed = dataList.remove(0);
        notifyAll();
        return removed;
    }
}

public class ProviderConsumer {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Data data = new Data();
        Runnable producerThread = () -> {
            int to = 20;
            int from = 0;
            IntStream.rangeClosed(from, to)
                    .map(index -> to - index)
                    .boxed()
                    .forEach(item -> data.produce("item: " + item));
        };

        Runnable consumerThread = () -> {
            do {
                String item = data.consume();
                System.out.println("consumed: " + item);
            } while (true);
        };


        new Thread(producerThread).start();
        new Thread(consumerThread).start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
