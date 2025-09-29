package cn_solution

fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
    var bottles = numBottles
    var exchange = numExchange
    var ans = numBottles
    while (bottles >= exchange) {
        ans++
        bottles -= exchange++ - 1
    }
    return ans
}