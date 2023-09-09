package cn_solution

class MyStack() {

    private var q1 = ArrayDeque<Int>()
    private var q2 = ArrayDeque<Int>()

    fun push(x: Int) {
        q2.addLast(x)
        while (q1.isNotEmpty()) {
            q2.addLast(q1.removeFirst())
        }
        val q3 = q1
        q1 = q2
        q2 = q3
    }

    fun pop(): Int {
        return q1.removeFirst()
    }

    fun top(): Int {
        return q1.first()
    }

    fun empty(): Boolean {
        return q1.isEmpty()
    }
}