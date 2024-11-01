package cn_lcp

fun getMinimumTime(time: IntArray, fruits: Array<IntArray>, limit: Int): Int {
    return fruits.sumOf { (type, num) -> (num + limit - 1) / limit * time[type] }
}