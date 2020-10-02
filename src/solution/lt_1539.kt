package solution

fun findKthPositive(arr: IntArray, k: Int): Int {
    var res = k
    arr.forEach {
        if (it <= res) {
            res++
        }
    }
    return res
}