package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLock {
    public static void main(String[] args) {
        Lock producerLock = new ReentrantLock();

        while (true) {
            if(producerLock.tryLock()) {
                try {
                    break;
                } finally {
                    producerLock.unlock();
                    break;
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }

            }
        }


    }
}
