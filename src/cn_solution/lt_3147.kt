package cn_solution

fun maximumEnergy(energy: IntArray, k: Int): Int {
    var ans = Int.MIN_VALUE
    val n = energy.size
    for (i in n - 1 downTo 0) {
        if (i + k < n)
            energy[i] += energy[i + k]
        ans = maxOf(ans, energy[i])
    }
    return ans
}