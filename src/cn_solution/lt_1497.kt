package cn_solution

fun canArrange(arr: IntArray, k: Int): Boolean {
    val cnt = IntArray(k)
    arr.forEach { cnt[(it % k + k) % k]++ }
    return cnt.indices.all {
        if (it == 0 || it * 2 == k) cnt[it] % 2 == 0
        else cnt[it] == cnt[k - it]
    }
}