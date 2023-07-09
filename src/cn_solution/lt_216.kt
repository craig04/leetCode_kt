package cn_solution

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>()
    for (i in 0 until 1.shl(9)) {
        var bit = 0
        var sum = 0
        val list = ArrayList<Int>()
        for (j in 0 until 9) {
            if (i and 1.shl(j) != 0) {
                bit++
                sum += j + 1
                list.add(j + 1)
            }
        }
        if (bit == k && sum == n)
            result.add(list)
    }
    return result
}