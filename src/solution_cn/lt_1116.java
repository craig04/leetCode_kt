package solution_cn;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {

    private int n;

    private Semaphore zeroLock = new Semaphore(1);
    private Semaphore oddLock = new Semaphore(0);
    private Semaphore evenLock = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroLock.acquire();
            printNumber.accept(0);
            (i % 2 == 0 ? oddLock : evenLock).release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenLock.acquire();
            printNumber.accept(i);
            zeroLock.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddLock.acquire();
            printNumber.accept(i);
            zeroLock.release();
        }
    }
}