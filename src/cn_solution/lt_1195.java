package cn_solution;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

class FizzBuzz {

    private final int n;
    private final CyclicBarrier cb = new CyclicBarrier(4);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        execute(1, (_) -> printFizz.run());
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        execute(2, (_) -> printBuzz.run());
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        execute(3, (_) -> printFizzBuzz.run());
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        execute(0, printNumber);
    }

    private void execute(int type, IntConsumer consumer) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            int t = i % 3 == 0 ? 1 : 0;
            if (i % 5 == 0)
                t += 2;
            if (t == type) {
                consumer.accept(i);
            }
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }
    }
}