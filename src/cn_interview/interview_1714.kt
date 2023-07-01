package cn_interview

fun smallestK(arr: IntArray, k: Int): IntArray {
    val random = java.util.Random()
    fun swap(a: Int, b: Int) {
        val ex = arr[a]
        arr[a] = arr[b]
        arr[b] = ex
    }

    fun partition(l: Int, r: Int): Int {
        var p = random.nextInt(r - l + 1) + l
        val pivot = arr[p]
        swap(p, l)
        p = l
        for (i in l + 1..r)
            if (arr[i] < pivot)
                swap(++p, i)
        swap(p, l)
        return p
    }

    fun select(l: Int, r: Int) {
        val pos = partition(l, r)
        if (pos < k - 1)
            select(pos + 1, r)
        else if (pos > k)
            select(l, pos - 1)
    }
    if (minOf(arr.size, k) == 0) {
        return IntArray(0)
    }
    select(0, arr.lastIndex)
    return IntArray(k) { arr[it] }
}