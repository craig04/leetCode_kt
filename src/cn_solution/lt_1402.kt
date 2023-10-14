package cn_solution

fun maxSatisfaction(satisfaction: IntArray): Int {
    satisfaction.sortDescending()
    var result = 0
    var sum = 0
    for (s in satisfaction) {
        sum += s
        if (sum <= 0)
            break
        result += sum
    }
    return result
}