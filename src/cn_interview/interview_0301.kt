package cn_interview

class TripleInOne(private val stackSize: Int) {

    private val data = IntArray(stackSize * 3)
    private val top = IntArray(3) { it * stackSize }

    fun push(stackNum: Int, value: Int) {
        if (top[stackNum] == (stackNum + 1) * stackSize)
            return
        data[top[stackNum]++] = value
    }

    fun pop(stackNum: Int): Int {
        if (isEmpty(stackNum))
            return -1
        return data[--top[stackNum]]
    }

    fun peek(stackNum: Int): Int {
        if (isEmpty(stackNum))
            return -1
        return data[top[stackNum] - 1]
    }

    fun isEmpty(stackNum: Int): Boolean {
        return top[stackNum] == stackNum * stackSize
    }
}