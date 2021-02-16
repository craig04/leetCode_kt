package solution

fun stoneGameVI(aliceValues: IntArray, bobValues: IntArray): Int {
    val sums = Array(aliceValues.size) {
        aliceValues[it] + bobValues[it] to it
    }
    sums.sortBy { -it.first }
    var alice = 0
    var bob = 0
    sums.forEachIndexed { index, p ->
        if (index and 1 == 0) {
            alice += aliceValues[p.second]
        } else {
            bob += bobValues[p.second]
        }
    }
    return alice.compareTo(bob)
}