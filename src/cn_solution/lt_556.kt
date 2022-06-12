package cn_solution

fun nextGreaterElement(n: Int): Int {
    val list = ArrayList<Int>()
    var temp = n
    do {
        list.add(temp % 10)
        temp /= 10
    } while (temp != 0)
    val t = list.toIntArray()
    val i = (1 until t.size).firstOrNull { t[it - 1] > t[it] } ?: return -1
    val j = (0 until i).firstOrNull { t[it] > t[i] } ?: return -1
    temp = t[i]
    t[i] = t[j]
    t[j] = temp
    t.reverse()
    t.sort(t.size - i)
    val result = t.fold(0L) { result, m -> result * 10 + m }
    return if (result > Int.MAX_VALUE) -1 else result.toInt()
}