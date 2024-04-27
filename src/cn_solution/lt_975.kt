package cn_solution

import java.util.*

fun oddEvenJumps(arr: IntArray): Int {
    val n = arr.size
    val odd = BooleanArray(n)
    val even = BooleanArray(n)
    odd[n - 1] = true
    even[n - 1] = true
    val map = TreeMap<Int, Int>()
    for (i in arr.indices.reversed()) {
        val a = arr[i]
        val high = map.ceilingEntry(a)
        if (high != null)
            odd[i] = even[high.value]
        val low = map.floorEntry(a)
        if (low != null)
            even[i] = odd[low.value]
        map[a] = i
    }
    return odd.count { it }
}