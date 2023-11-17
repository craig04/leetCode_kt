package cn_solution

class Solution_1186 {
    fun maximumSum(arr: IntArray): Int {
        var result = arr[0]
        var a = arr[0]
        var b = 0
        for (i in 1 until arr.size) {
            val n = arr[i]
            b = maxOf(b + n, a)
            a = maxOf(a, 0) + n
            result = maxOf(result, a, b)
        }
        return result
    }
}