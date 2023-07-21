package cn_offer

fun getLeastNumbers(arr: IntArray, k: Int): IntArray {
    val random = java.util.Random()
    fun swap(i: Int, j: Int) {
        val ex = arr[i]
        arr[i] = arr[j]
        arr[j] = ex
    }

    fun partition(l: Int, r: Int): Int {
        var p = random.nextInt(r - l + 1) + l
        val pivot = arr[p]
        swap(l, p)
        p = l
        for (i in l..r)
            if (arr[i] < pivot)
                swap(++p, i)
        swap(l, p)
        return p
    }

    fun select(l: Int, r: Int) {
        val pos = partition(l, r)
        if (pos < k - 1)
            select(pos + 1, r)
        else if (pos > k)
            select(l, pos - 1)
    }
    select(0, arr.lastIndex)
    return IntArray(k) { arr[it] }
}