package cn_solution

fun memLeak(memory1: Int, memory2: Int): IntArray {
    var left1 = memory1
    var left2 = memory2
    var time = 1
    while (maxOf(left1, left2) >= time) {
        if (left1 >= left2)
            left1 -= time
        else
            left2 -= time
        time++
    }
    return intArrayOf(time, left1, left2)
}