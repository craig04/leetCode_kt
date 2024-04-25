package cn_solution

fun resultArray(nums: IntArray): IntArray {
    val data = nums.toHashSet().toIntArray()
    data.sort()
    val map = HashMap<Int, Int>()
    for (i in data.indices)
        map[data[i]] = i + 1
    val n = nums.size
    val c = IntArray(n + 1)
    val a1 = IntArray(n)
    val a2 = IntArray(n)
    var p1 = 0
    var p2 = 0
    fun add(x: Int, offset: Int) {
        var t = x
        do {
            c[t] += offset
            t += t and -t
        } while (t <= n)
    }
    a1[p1++] = nums[0]
    add(map[nums[0]] ?: 0, 1)
    a2[p2++] = nums[1]
    add(map[nums[1]] ?: 0, -1)
    for (i in 2 until n) {
        val num = nums[i]
        val x = map[num] ?: 0
        var t = x
        var diff = p1 - p2
        do {
            diff -= c[t]
            t = t and (t - 1)
        } while (t > 0)
        if (diff > 0 || (diff == 0 && p1 <= p2)) {
            a1[p1++] = num
            add(x, 1)
        } else {
            a2[p2++] = num
            add(x, -1)
        }
    }
    a2.copyInto(a1, p1, 0, p2)
    return a1
}