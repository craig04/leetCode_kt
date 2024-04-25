package cn_solution

fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
    var origin = 0
    var temp = 0
    var delta = 0
    for (i in customers.indices) {
        if (grumpy[i] == 0)
            origin += customers[i]
        else
            temp += customers[i]
        if (i >= minutes - 1) {
            delta = maxOf(temp, delta)
            val left = i - minutes + 1
            if (grumpy[left] == 1)
                temp -= customers[left]
        }
    }
    return origin + delta
}