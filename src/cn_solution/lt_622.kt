package cn_solution

class MyCircularQueue(k: Int) {

    private val capacity = k + 1
    private val data = IntArray(capacity)

    private var front = 0
    private var rear = 0

    fun enQueue(value: Int): Boolean {
        if (isFull()) {
            return false
        }
        data[rear] = value
        rear = (rear + 1) % capacity
        return true
    }

    fun deQueue(): Boolean {
        if (isEmpty()) {
            return false
        }
        front = (front + 1) % capacity
        return true
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else data[front]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else data[(rear + capacity - 1) % capacity]
    }

    fun isEmpty(): Boolean {
        return rear == front
    }

    fun isFull(): Boolean {
        return (rear + 1) % capacity == front
    }
}