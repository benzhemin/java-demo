package thread;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.stream.IntStream;

@Slf4j
class Printer extends Thread{
    Runnable invoke;

    int index;

    int countDown;
    public Printer(int index, int countDown, Runnable invoke) {
        this.index = index;
        this.invoke = invoke;
        this.countDown = countDown;
    }

    public void print() {
        try {
            invoke.run();
            this.countDown -= 1;

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void run() {
        while (countDown > 0) {
            print();
        }
    }
}

class Scheduler {
    List<Semaphore> semaphoreList;
    public Scheduler(int threadCount, int countDown) {

        // initialize semaphore
        this.semaphoreList = IntStream.range(0, threadCount)
                .mapToObj(index -> new Semaphore(0, true)).toList();

        IntStream.range(0, threadCount).forEach(index -> {
            Printer printer = new Printer(index, 20, () -> {
                schedule(index, threadCount, () -> {
                    System.out.println(index);
                });
            });

            printer.start();
        });
    }

    private void schedule(int index, int maxCount, Runnable runnable) {
        int next = (index+1) % maxCount;

        Semaphore curSemaphore = semaphoreList.get(index);
        Semaphore nextSemaphore = semaphoreList.get(next);

        try {
            curSemaphore.acquire();
            runnable.run();
            nextSemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void trigger() {
        semaphoreList.get(0).release();
    }
}

public class SequencePrint {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(3, 20);
        scheduler.trigger();
    }

}
