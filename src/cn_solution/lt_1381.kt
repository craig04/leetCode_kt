package cn_solution

class CustomStack(maxSize: Int) {

    val s = IntArray(maxSize)
    val x = IntArray(maxSize)
    var top = -1

    fun push(x: Int) {
        if (top < s.lastIndex)
            s[++top] = x
    }

    fun pop(): Int {
        if (top == -1)
            return -1
        val res = s[top] + x[top]
        if (top != 0)
            x[top - 1] += x[top]
        x[top--] = 0
        return res
    }

    fun increment(k: Int, `val`: Int) {
        val t = minOf(k - 1, top)
        if (t != -1)
            x[t] += `val`
    }
}