package cn_solution

fun minimumAddedCoins(coins: IntArray, target: Int): Int {
    coins.sort()
    var sum = 1
    var result = 0
    var i = 0
    while (sum <= target) {
        if (i < coins.size && sum >= coins[i])
            sum += coins[i++]
        else {
            sum *= 2
            result++
        }
    }
    return result
}