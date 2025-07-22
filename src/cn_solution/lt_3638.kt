package cn_solution

fun maxBalancedShipments(weight: IntArray): Int {
    var ans = 0
    var i = 1
    val n = weight.size
    while (i != n) {
        if (weight[i - 1] > weight[i]) {
            ans++
            i++
        }
        i++
    }
    return ans
}