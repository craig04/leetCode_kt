package solution_cn;

import java.util.concurrent.Semaphore;

class H2O {

    private Semaphore hydrogenSem = new Semaphore(2);
    private Semaphore oxygenSem = new Semaphore(2);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hydrogenSem.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygenSem.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oxygenSem.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogenSem.release(2);
    }
}