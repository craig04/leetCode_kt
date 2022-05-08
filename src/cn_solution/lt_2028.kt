package cn_solution

fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
    val sum = (rolls.size + n) * mean - rolls.sum()
    if (sum > n * 6 || sum < n) {
        return intArrayOf()
    }
    val quotient = sum / n
    val remainder = sum % n
    return IntArray(n) { if (it < remainder) quotient + 1 else quotient }
}